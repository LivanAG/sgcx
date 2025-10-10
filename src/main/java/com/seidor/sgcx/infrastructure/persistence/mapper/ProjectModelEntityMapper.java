package com.seidor.sgcx.infrastructure.persistence.mapper;

import com.seidor.sgcx.domain.model.ProjectModel;
import com.seidor.sgcx.infrastructure.persistence.entitity.ProjectModelEntity;
import org.springframework.stereotype.Component;

@Component
public class ProjectModelEntityMapper {

    // Campos: id, name
    public ProjectModel toDomain(ProjectModelEntity entity) {
        if (entity == null) return null;
        ProjectModel domain = new ProjectModel();
        domain.setId(entity.getId());
        domain.setName(entity.getName());
        return domain;
    }

    public ProjectModelEntity toEntity(ProjectModel domain) {
        if (domain == null) return null;
        ProjectModelEntity entity = new ProjectModelEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        return entity;
    }
}