package com.seidor.sgcx.infrastructure.persistence.mapper;

import com.seidor.sgcx.domain.model.CommercialSector;
import com.seidor.sgcx.infrastructure.persistence.entitity.CommercialSectorEntity;
import org.springframework.stereotype.Component;

@Component
public class CommercialSectorEntityMapper {


    public CommercialSector toDomain(CommercialSectorEntity entity) {
        if (entity == null) return null;
        CommercialSector domain = new CommercialSector();
        domain.setId(entity.getId());
        domain.setName(entity.getName());
        return domain;
    }

    public CommercialSectorEntity toEntity(CommercialSector domain) {
        if (domain == null) return null;
        CommercialSectorEntity entity = new CommercialSectorEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        return entity;
    }
}
