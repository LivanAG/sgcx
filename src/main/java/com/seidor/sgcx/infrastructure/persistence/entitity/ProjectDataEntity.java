package com.seidor.sgcx.infrastructure.persistence.entitity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "projects_data")
@Getter
@Setter
public class ProjectDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_add", nullable = false)
    private LocalDateTime dateAdd;

    @Column(name = "date_update")
    private LocalDateTime dateUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_add_id", nullable = false)
    private UserEntity userAdd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_update_id")
    private UserEntity userUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private ProjectEntity project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "period_id", nullable = false)
    private PeriodEntity period;

    private Integer reviewStatus;
    private Double budget;
    private Double editableProduction;
    private Double actualProgress;
    private Double actualProduction;
    private Double actualCost;
    private Double actualMargin;
    @Column(nullable = false)
    private Double actualInvoiced = 0.0;
    @Column(nullable = false)
    private Double actualWip = 0.0;
    private LocalDate expectedEndDate;
    private Double expectedEndMargin;
    private Double expectedNextPeriodProduction;
    private Double expectedYearProduction;
    @Column(nullable = false)
    private Double lastPeriodProgress = 0.0;
    @Column(nullable = false)
    private Double lastPeriodProduction = 0.0;
    @Column(nullable = false)
    private Double lastPeriodCost = 0.0;
    @Column(nullable = false)
    private Double lastPeriodMargin = 0.0;
    @Column(nullable = false)
    private Double lastPeriodInvoiced = 0.0;
    @Column(nullable = false)
    private Double lastPeriodWip = 0.0;
    private Double periodProgress;
    private Double periodProduction;
    private Double periodCost;
    private Double periodMargin;
    @Column(nullable = false)
    private Double periodInvoiced = 0.0;
    @Column(nullable = false)
    private Double periodWip = 0.0;
    @Column(nullable = false)
    private boolean blocked = false;
}
