package com.seidor.sgcx.infrastructure.persistence.entitity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "commercial_sectors")
@Getter
@Setter
public class CommercialSectorEntity {
    @Id
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String name;
}