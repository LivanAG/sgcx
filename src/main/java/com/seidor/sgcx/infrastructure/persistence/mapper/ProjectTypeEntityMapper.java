package com.seidor.sgcx.infrastructure.persistence.mapper;

import com.seidor.sgcx.domain.model.ProjectType;
import com.seidor.sgcx.infrastructure.persistence.entitity.ProjectTypeEntity;
import org.springframework.stereotype.Component;

@Component
public class ProjectTypeEntityMapper {


    public ProjectType toDomain(ProjectTypeEntity entity) {
        if (entity == null) return null;
        ProjectType domain = new ProjectType();
        domain.setId(entity.getId());
        domain.setName(entity.getName());
        return domain;
    }

    public ProjectTypeEntity toEntity(ProjectType domain) {
        if (domain == null) return null;
        ProjectTypeEntity entity = new ProjectTypeEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        return entity;
    }
}