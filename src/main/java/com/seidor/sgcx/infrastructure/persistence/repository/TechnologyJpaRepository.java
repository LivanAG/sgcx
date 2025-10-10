package com.seidor.sgcx.infrastructure.persistence.repository;

import com.seidor.sgcx.infrastructure.persistence.entitity.TechnologyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyJpaRepository extends JpaRepository<TechnologyEntity, Long> {}