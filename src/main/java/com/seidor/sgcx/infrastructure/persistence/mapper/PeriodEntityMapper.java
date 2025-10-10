package com.seidor.sgcx.infrastructure.persistence.mapper;

import com.seidor.sgcx.domain.model.Period;
import com.seidor.sgcx.infrastructure.persistence.entitity.PeriodEntity;
import org.springframework.stereotype.Component;

@Component
public class PeriodEntityMapper {


    public Period toDomain(PeriodEntity entity) {
        if (entity == null) return null;
        Period domain = new Period();
        domain.setId(entity.getId());
        domain.setCode(entity.getCode());
        domain.setYear(entity.getYear());
        domain.setMonth(entity.getMonth());
        domain.setEnabled(entity.isEnabled());
        return domain;
    }

    public PeriodEntity toEntity(Period domain) {
        if (domain == null) return null;
        PeriodEntity entity = new PeriodEntity();
        entity.setId(domain.getId());
        entity.setCode(domain.getCode());
        entity.setYear(domain.getYear());
        entity.setMonth(domain.getMonth());
        entity.setEnabled(domain.isEnabled());
        return entity;
    }
}