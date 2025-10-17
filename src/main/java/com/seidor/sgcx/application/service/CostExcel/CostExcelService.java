package com.seidor.sgcx.application.service.CostExcel;


import com.seidor.sgcx.application.dto.cost.CostExcelRequestDto;
import com.seidor.sgcx.application.ports.in.ReadAndGetCostFromExcelUseCase;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CostExcelService implements ReadAndGetCostFromExcelUseCase {

    @Override
    public List<CostExcelRequestDto> readExcelFileAndGetCosts(MultipartFile file) {
        List<CostExcelRequestDto> costsExcelList = new ArrayList<>();


        DataFormatter formatter = new DataFormatter();

        //Cargo mi excel
        try(Workbook workbook = WorkbookFactory.create(file.getInputStream())){

            //Obtengo la hoja que necesito trabajar en este caso asumo que se llama coste
            Sheet sheet = workbook.getSheet("coste");
            if (sheet == null) {
                throw new IllegalArgumentException("No existe la hoja llamada coste");
            }

            //Recupero la cabecera asumiendo que esta en la posicion 0
            Row headerRow = sheet.getRow(0);
            if (headerRow == null) {
                throw new IllegalArgumentException("La hoja coste no tiene cabecera");
            }

            //Ahora tengo que buscar las dos columnas que necesito, no recuerdo con claridad
            // Creo que son la columna Cost y Pep
            //Para ello recorro el headerRow y guardo en un hash map NombreColumna:Posicion
            Map<String, Integer> columns = new HashMap<>();
            for (Cell cell : headerRow) {
                String columnName = formatter.formatCellValue(cell).trim().toLowerCase();
                columns.put(columnName, cell.getColumnIndex());
            }

            if (!columns.containsKey("coste") || !columns.containsKey("pep")) {
                throw new IllegalArgumentException("Faltan columnas coste o pep en la hoja");
            }



            for (int i = 1; i < sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                Cell pepCell = row.getCell(columns.get("pep"));
                String pep = formatter.formatCellValue(pepCell);

                Cell costeCell = row.getCell(columns.get("coste"));
                String costStr = formatter.formatCellValue(costeCell);

                Double coste = null;
                if (!costStr.isBlank()) {
                    try {
                        coste = Double.parseDouble(costStr.replace(",", "."));
                    } catch (NumberFormatException e) {
                        costStr = null;
                    }
                }

                CostExcelRequestDto dto = new CostExcelRequestDto(pep, coste);
                costsExcelList.add(dto);
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return costsExcelList;
    }
}
