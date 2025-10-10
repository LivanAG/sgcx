package com.seidor.sgcx.infrastructure.persistence.repository;

import com.seidor.sgcx.infrastructure.persistence.entitity.CommercialSectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommercialSectorJpaRepository extends JpaRepository<CommercialSectorEntity, Long> {}
