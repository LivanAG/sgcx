package com.seidor.sgcx.application.service.CostExcel;

import com.seidor.sgcx.application.dto.cost.CostExcelRequestDto;
import org.apache.poi.xssf.eventusermodel.*;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

public class CostSheetHandler extends DefaultHandler implements XSSFSheetXMLHandler.SheetContentsHandler {

    private final SharedStringsTable sst;
    private final List<CostExcelRequestDto> costs = new ArrayList<>();

    private String currentPep;
    private Double currentCoste;
    private boolean isHeader = true;
    private Map<String, Integer> columns = new HashMap<>();
    private int currentCol = -1;

    public CostSheetHandler(SharedStringsTable sst) {
        this.sst = sst;
    }

    @Override
    //Este callback se ejecuta al empezar una fila nueva
    //Si es la primera fila, la trato como cabecera.
    //Si no, limpias las variables para procesar una nueva fila de datos.
    public void startRow(int rowNum) {
        if (rowNum == 0) { // cabecera
            columns.clear();
            isHeader = true;
        } else {
            currentPep = null;
            currentCoste = null;
            isHeader = false;
        }
    }

    @Override
    public void endRow(int rowNum) {
        if (!isHeader && currentPep != null) {
            costs.add(new CostExcelRequestDto(currentPep, currentCoste));
        }
    }

    @Override
    public void cell(String cellReference, String formattedValue, XSSFComment comment) {
        //Si es la cabecera voy guardando en un hash map NombreColumna:Posicion
        if (isHeader) {
            columns.put(formattedValue.trim().toLowerCase(), getColumnIndex(cellReference));
        } else {
            // si la cabecera ya nos dijo dónde están las columnas
            if (getColumnIndex(cellReference) == columns.getOrDefault("pep", -1)) {
                currentPep = formattedValue;
            } else if (getColumnIndex(cellReference) == columns.getOrDefault("coste", -1)) {
                try {
                    currentCoste = Double.parseDouble(formattedValue.replace(",", "."));
                } catch (NumberFormatException e) {
                    currentCoste = null;
                }
            }
        }
    }

    @Override
    public void endSheet() {
       // no hago nada, no me interesa este metodo
    }

    public List<CostExcelRequestDto> getCosts() {
        return costs;
    }

    // Helper para obtener el índice de columna (A→0, B→1, etc.)
    private int getColumnIndex(String cellRef) {
        if (cellRef == null) return -1;
        int col = 0;

        //cellRef.replaceAll("\\d", "") Elimino todos los digitos numericos de la referencia
        //Solo me interesa la parte de las letras, que representa la columna.
        for (char c : cellRef.replaceAll("\\d", "").toCharArray()) {
            col = col * 26 + (c - 'A' + 1);
            /*
                La lógica “base 26”:
                Excel numera las columnas como si fueran un sistema de numeración en base 26

                A-1
                B-2
                Z-26
                Y cuando se pasa de Z, empieza de nuevo, como en un odómetro:
                Z = 26
                AA = 27
                AB = 28

                * Ejemplo: "BAZ"
                Letras → B,A,Z → 2,1,26

                col=0
                (Iteracion 1)Lee B: col = 0*26 + 2 = 2
                (Iteracion 2)Lee A: col = 2*26 + 1 = 53
                (Iteracion 3)Lee Z: col = 53*26 + 26 = 1404

                Base 0: 1404 - 1 = 1403
                *
             */

        }
        return col - 1;
    }
}