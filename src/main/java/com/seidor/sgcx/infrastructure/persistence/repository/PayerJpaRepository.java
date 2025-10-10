package com.seidor.sgcx.infrastructure.persistence.repository;

import com.seidor.sgcx.infrastructure.persistence.entitity.PayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayerJpaRepository extends JpaRepository<PayerEntity, Long> {}