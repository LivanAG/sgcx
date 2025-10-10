package com.seidor.sgcx.infrastructure.persistence.adapter;

import com.seidor.sgcx.application.ports.out.ProjectRepositoryPort;
import com.seidor.sgcx.domain.model.Project;
import com.seidor.sgcx.infrastructure.persistence.mapper.ProjectEntityMapper;
import com.seidor.sgcx.infrastructure.persistence.repository.ProjectJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ProjectRepositoryAdapter implements ProjectRepositoryPort {

    private final ProjectJpaRepository projectJpaRepository;
    private final ProjectEntityMapper projectEntityMapper;

    public ProjectRepositoryAdapter(ProjectJpaRepository projectJpaRepository, ProjectEntityMapper projectEntityMapper) {
        this.projectJpaRepository = projectJpaRepository;
        this.projectEntityMapper = projectEntityMapper;
    }

    @Override
    public List<Project> findAll() {
        return projectJpaRepository.findAll().stream().map(projectEntityMapper::toDomain).toList();
    }

    @Override
    public List<Project> findByAreaId(Long id) {
        return projectJpaRepository.findByArea_Id(id).stream().map(projectEntityMapper::toDomain).toList();
    }


}
