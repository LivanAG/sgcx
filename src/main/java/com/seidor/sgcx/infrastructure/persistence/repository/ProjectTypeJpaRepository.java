package com.seidor.sgcx.infrastructure.persistence.repository;

import com.seidor.sgcx.infrastructure.persistence.entitity.ProjectTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectTypeJpaRepository extends JpaRepository<ProjectTypeEntity, Long> {}