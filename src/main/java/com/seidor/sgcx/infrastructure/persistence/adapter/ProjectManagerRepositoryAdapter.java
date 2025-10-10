package com.seidor.sgcx.infrastructure.persistence.adapter;

import com.seidor.sgcx.application.ports.out.ProjectManagerRepositoryPort;
import com.seidor.sgcx.application.ports.out.ProjectRepositoryPort;
import com.seidor.sgcx.domain.model.ProjectManagerAssignment;
import com.seidor.sgcx.infrastructure.persistence.mapper.ProjectManagerAssignmentEntityMapper;
import com.seidor.sgcx.infrastructure.persistence.repository.ProjectManagerAssignmentJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ProjectManagerRepositoryAdapter implements ProjectManagerRepositoryPort {

    private final ProjectManagerAssignmentJpaRepository  projectManagerAssignmentJpaRepository;
    private final ProjectManagerAssignmentEntityMapper  projectManagerAssignmentEntityMapper;

    @Override
    public List<ProjectManagerAssignment> findByUserId(Long userId) {
        return projectManagerAssignmentJpaRepository.findByUserId(userId).stream()
                .map(projectManagerAssignmentEntityMapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByUserId(Long userId) {
        return projectManagerAssignmentJpaRepository.existsByUserId(userId);
    }
}
