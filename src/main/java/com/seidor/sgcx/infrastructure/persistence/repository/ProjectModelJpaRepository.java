package com.seidor.sgcx.infrastructure.persistence.repository;

import com.seidor.sgcx.infrastructure.persistence.entitity.ProjectModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectModelJpaRepository extends JpaRepository<ProjectModelEntity, Long> {}