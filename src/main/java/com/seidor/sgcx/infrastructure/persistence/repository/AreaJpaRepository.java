package com.seidor.sgcx.infrastructure.persistence.repository;

import com.seidor.sgcx.infrastructure.persistence.entitity.AreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaJpaRepository extends JpaRepository<AreaEntity, Long> {}
