package com.seidor.sgcx.infrastructure.persistence.repository;

import com.seidor.sgcx.infrastructure.persistence.entitity.PeriodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodJpaRepository extends JpaRepository<PeriodEntity, Long> {}