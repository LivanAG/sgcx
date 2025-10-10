package com.seidor.sgcx.infrastructure.persistence.mapper;

import com.seidor.sgcx.domain.model.Payer;
import com.seidor.sgcx.infrastructure.persistence.entitity.PayerEntity;
import org.springframework.stereotype.Component;

@Component
public class PayerEntityMapper {

    public Payer toDomain(PayerEntity entity) {
        if (entity == null) return null;
        Payer domain = new Payer();
        domain.setId(entity.getId());
        domain.setName(entity.getName());
        return domain;
    }

    public PayerEntity toEntity(Payer domain) {
        if (domain == null) return null;
        PayerEntity entity = new PayerEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        return entity;
    }
}