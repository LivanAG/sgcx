package com.seidor.sgcx.application.service.CostExcel;

import com.seidor.sgcx.application.dto.cost.CostExcelRequestDto;
import com.seidor.sgcx.application.ports.in.ReadAndGetCostFromExcelStreamingUseCase;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

@Service
public class CostExcelStreamingService implements ReadAndGetCostFromExcelStreamingUseCase {

    @Override
    public List<CostExcelRequestDto> readExcelFileAndGetCostsStreaming(MultipartFile file) {
        try (InputStream is = file.getInputStream()) {
            OPCPackage pkg = OPCPackage.open(is); // leo el zip
            XSSFReader reader = new XSSFReader(pkg);
            SharedStringsTable sst = (SharedStringsTable) reader.getSharedStringsTable();
            StylesTable styles = reader.getStylesTable();

            // Crear el handler de lógica de negocio
            CostSheetHandler handler = new CostSheetHandler(sst);

            // Crear el parser SAX
            //Es un lector que no carga el XML completo en memoria: lee evento por evento.
            XMLReader parser = XMLReaderFactory.createXMLReader();//Parser SAX (lector de XML)

            // Crear el handler SAX del Excel con la firma correcta
            XSSFSheetXMLHandler xmlHandler = new XSSFSheetXMLHandler(
                    styles,            // estilos
                    null,              // comentarios (null si no hay)
                    sst,               // tabla de strings compartidos
                    handler,           // tu handler
                    new DataFormatter(), // formateador
                    false              // false = leer valores, true = fórmulas
            );

            parser.setContentHandler(xmlHandler);

            XSSFReader.SheetIterator sheets = (XSSFReader.SheetIterator) reader.getSheetsData();

            while (sheets.hasNext()) {
                try (InputStream sheetStream = sheets.next()) {
                    String sheetName = sheets.getSheetName();

                    if (!"coste".equalsIgnoreCase(sheetName)) {
                        continue;
                    }
                    parser.parse(new InputSource(sheetStream));
                }
            }

            pkg.close();
            return handler.getCosts();
        } catch (IOException | InvalidFormatException e) {
            throw new RuntimeException(e);
        } catch (OpenXML4JException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
