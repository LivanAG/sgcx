package com.seidor.sgcx.application.ports.out;

import com.seidor.sgcx.domain.model.AreaManager;
import com.seidor.sgcx.domain.model.ProjectManagerAssignment;

import java.util.List;

public interface ProjectManagerRepositoryPort {
    List<ProjectManagerAssignment> findByUserId(Long userId);
    boolean existsByUserId(Long userId);
}
