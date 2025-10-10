package com.seidor.sgcx.infrastructure.persistence.entitity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "projects")
@Getter
@Setter
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PEP", nullable = false, unique = true, length = 50)
    private String pep;

    @Column(nullable = false, length = 100)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private ClientEntity client;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "sold_margin", nullable = false)
    private double soldMargin;

    @Column(nullable = false, length = 2)
    private String division;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id", nullable = false)
    private AreaEntity area;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_type_id", nullable = false)
    private ProjectTypeEntity projectType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_model_id", nullable = false)
    private ProjectModelEntity projectModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_manager_id", nullable = false)
    private UserEntity projectManager;

    @Column(nullable = false, length = 50)
    private String commercial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sales_office_id", nullable = false)
    private OfficeEntity salesOffice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_office_id", nullable = false)
    private OfficeEntity deliveryOffice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "technology_id", nullable = false)
    private TechnologyEntity technology;
}
