package com.seidor.sgcx.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;
import com.seidor.sgcx.domain.model.*;
import com.seidor.sgcx.infrastructure.persistence.entitity.*;


@Component
public class GroupEntityMapper {


    public Group toDomain(GroupEntity entity) {
        if (entity == null) return null;
        Group domain = new Group();
        domain.setId(entity.getId());
        domain.setName(entity.getName());
        domain.setShortName(entity.getShortName());
        return domain;
    }

    public GroupEntity toEntity(Group domain) {
        if (domain == null) return null;
        GroupEntity entity = new GroupEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setShortName(domain.getShortName());
        return entity;
    }
}
