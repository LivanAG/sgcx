package com.seidor.sgcx.infrastructure.persistence.entitity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payers")
@Getter
@Setter
public class PayerEntity {
    @Id
    private Long id;

    @Column(length = 50)
    private String name;
}