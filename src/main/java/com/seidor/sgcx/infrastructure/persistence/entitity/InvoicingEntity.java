package com.seidor.sgcx.infrastructure.persistence.entitity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "invoicing")
@Getter
@Setter
public class InvoicingEntity {

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
    @JoinColumn(name = "period_id", nullable = false)
    private PeriodEntity period;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private ProjectEntity project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payer_id")
    private PayerEntity payer;

    // 🟢 Nuevo campo según la primera versión del SQL
    @Column(name = "project_name", length = 100)
    private String projectName;

    // 🟢 Cambiar tipo: era Integer, ahora es Date
    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Integer status;

    @Column(nullable = false)
    private boolean billable = false;

    @Column(name = "WIP", nullable = false)
    private boolean wip = false;

    @Column(nullable = false)
    private double amount = 0.0;

    @Column(name = "sale_cost", nullable = false)
    private double saleCost = 0.0;

    @Column(name = "added_value", nullable = false)
    private double addedValue = 0.0;

    @Column(length = 1000)
    private String concept;

    @Column(length = 1000)
    private String comments;

    @Column(name = "invoice_number", length = 12)
    private String invoiceNumber;
}
