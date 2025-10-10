package com.seidor.sgcx.infrastructure.persistence.repository;

import com.seidor.sgcx.infrastructure.persistence.entitity.ProjectDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDataJpaRepository extends JpaRepository<ProjectDataEntity, Long> {}
