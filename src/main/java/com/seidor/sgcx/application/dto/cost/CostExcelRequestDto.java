package com.seidor.sgcx.application.dto.cost;

public class CostExcelRequestDto {

    private String pep;
    private Double coste;

    // Constructores
    public CostExcelRequestDto() {}
    public CostExcelRequestDto(String pep, Double coste) {
        this.pep = pep;
        this.coste = coste;
    }

    // Getters y setters
    public String getPep() { return pep; }
    public void setPep(String pep) { this.pep = pep; }

    public Double getCoste() { return coste; }
    public void setCoste(Double coste) { this.coste = coste; }
}
