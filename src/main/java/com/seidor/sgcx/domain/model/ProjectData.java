package com.seidor.sgcx.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectData {
    private Long id;
    private LocalDateTime dateAdd;
    private LocalDateTime dateUpdate;
    private User userAdd;
    private User userUpdate;
    private Project project;
    private Period period;// AAAA MM
    private Integer reviewStatus;// (0 sin revisar)(1 revisado por el project manager)(2 revisado por el mandager)

    private Double budget;
    //Entre editableProduction y actualProgress solo podra existir valor en uno solo de ellos
    private Double editableProduction;// produccion
    private Double actualProgress;//AVANCE  % de avance (es un % DEL BUDGET)
    private Double actualProduction;
    private Double actualCost;// viene del archivo externo
    private Double actualMargin; //actualProduction-actualCost/actualProduction
    private Double actualInvoiced;// la suma de todos los hitos de facturacion
    private Double actualWip;// actualProduction-actualInvoiced

    private LocalDate expectedEndDate;
    private Double expectedEndMargin;
    private Double expectedNextPeriodProduction;
    private Double expectedYearProduction;

    private Double lastPeriodProgress;
    private Double lastPeriodProduction;
    private Double lastPeriodCost;
    private Double lastPeriodMargin;
    private Double lastPeriodInvoiced;
    private Double lastPeriodWip;

    private Double periodProgress;
    private Double periodProduction;
    private Double periodCost;
    private Double periodMargin;
    private Double periodInvoiced;
    private Double periodWip;

    private boolean blocked;



    public void calculateActualProduction(){
        //Hay dos formas de calcular la produccion actual

        //Forma 1
        //Nos pueden dar en el campo actualProgress el % de avance que seria
        // x = (actualProgress / 100) * budget
        if(this.editableProduction == null && this.budget != null){
            this.actualProduction = (this.actualProgress/100) * this.budget;
        }
        //Forma 2
        //Nos pueden dar directamente el valor de la produccion que seria el valor del campo
        else{
            this.actualProduction = editableProduction;
        }
    }

    public void calculateActualMargin(){
        this.actualMargin = (this.actualProduction-this.actualCost)/this.actualProduction;
    }

    public void calculateActualWip(){
        this.actualMargin = this.actualProduction-this.actualInvoiced;
    }
}
