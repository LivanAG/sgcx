package com.seidor.sgcx.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Invoicing {
    private Long id;
    private LocalDateTime dateAdd;
    private LocalDateTime dateUpdate;
    private User userAdd;
    private User userUpdate;
    private Period period;
    private Client client;
    private Project project;
    private Payer payer;
    private String projectName;

    private LocalDate date;
    private int status;
    private boolean billable;
    private boolean wip;
    private double amount;
    private double saleCost;
    private double addedValue;
    private String concept;
    private String comments;
    private String invoiceNumber;
}
