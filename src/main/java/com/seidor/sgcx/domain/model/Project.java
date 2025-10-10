package com.seidor.sgcx.domain.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Project {
    private Long id;
    private String pep;
    private String name;
    private Client client;
    private LocalDate startDate;
    private double soldMargin;
    private String division;
    private Area area;
    private ProjectType projectType;
    private ProjectModel projectModel;
    private User projectManager;// No sirve para el control de acceso
    private String commercial;
    private Office salesOffice;
    private Office deliveryOffice;
    private Technology technology;
}
