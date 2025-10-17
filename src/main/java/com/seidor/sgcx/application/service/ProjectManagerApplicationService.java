package com.seidor.sgcx.application.service;

import com.seidor.sgcx.application.ports.out.ProjectManagerRepositoryPort;
import com.seidor.sgcx.domain.model.ProjectManagerAssignment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectManagerApplicationService {

    private final ProjectManagerRepositoryPort projectManagerRepositoryPort;

    public List<ProjectManagerAssignment> findByUserId(Long userId) {
        return projectManagerRepositoryPort.findByUserId(userId);
    }

    public boolean isProjectManager(Long userId) {
        return projectManagerRepositoryPort.existsByUserId(userId);
    }
}
