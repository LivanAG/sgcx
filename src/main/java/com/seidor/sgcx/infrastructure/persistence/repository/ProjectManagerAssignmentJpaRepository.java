package com.seidor.sgcx.infrastructure.persistence.repository;

import com.seidor.sgcx.domain.model.AreaManager;
import com.seidor.sgcx.infrastructure.persistence.entitity.AreaManagerEntity;
import com.seidor.sgcx.infrastructure.persistence.entitity.ProjectManagerAssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectManagerAssignmentJpaRepository extends JpaRepository<ProjectManagerAssignmentEntity, Long> {

    List<ProjectManagerAssignmentEntity> findByUserId(Long userId);

    boolean existsByUserId(Long userId);
}
