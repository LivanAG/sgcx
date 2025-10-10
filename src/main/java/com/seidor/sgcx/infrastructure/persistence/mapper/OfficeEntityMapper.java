package com.seidor.sgcx.infrastructure.persistence.mapper;

import com.seidor.sgcx.domain.model.Office;
import com.seidor.sgcx.infrastructure.persistence.entitity.OfficeEntity;
import org.springframework.stereotype.Component;

@Component
public class OfficeEntityMapper {


    public Office toDomain(OfficeEntity entity) {
        if (entity == null) return null;
        Office domain = new Office();
        domain.setId(entity.getId());
        domain.setName(entity.getName());
        return domain;
    }

    public OfficeEntity toEntity(Office domain) {
        if (domain == null) return null;
        OfficeEntity entity = new OfficeEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        return entity;
    }
}