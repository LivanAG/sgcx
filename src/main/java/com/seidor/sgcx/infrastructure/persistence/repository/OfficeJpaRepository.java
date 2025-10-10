package com.seidor.sgcx.infrastructure.persistence.repository;

import com.seidor.sgcx.infrastructure.persistence.entitity.OfficeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeJpaRepository extends JpaRepository<OfficeEntity, Long> {}