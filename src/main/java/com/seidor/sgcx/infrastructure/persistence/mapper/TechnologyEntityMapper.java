package com.seidor.sgcx.infrastructure.persistence.mapper;

import com.seidor.sgcx.domain.model.Technology;
import com.seidor.sgcx.infrastructure.persistence.entitity.TechnologyEntity;
import org.springframework.stereotype.Component;

@Component
public class TechnologyEntityMapper {

    public Technology toDomain(TechnologyEntity entity) {
        if (entity == null) return null;
        Technology domain = new Technology();
        domain.setId(entity.getId());
        domain.setName(entity.getName());
        return domain;
    }

    public TechnologyEntity toEntity(Technology domain) {
        if (domain == null) return null;
        TechnologyEntity entity = new TechnologyEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        return entity;
    }
}