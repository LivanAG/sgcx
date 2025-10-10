package com.seidor.sgcx.infrastructure.persistence.repository;

import com.seidor.sgcx.infrastructure.persistence.entitity.InvoicingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoicingJpaRepository extends JpaRepository<InvoicingEntity, Long> {}
