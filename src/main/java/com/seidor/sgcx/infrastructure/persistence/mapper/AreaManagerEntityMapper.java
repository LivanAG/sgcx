package com.seidor.sgcx.infrastructure.persistence.mapper;
import com.seidor.sgcx.domain.model.AreaManager;
import com.seidor.sgcx.infrastructure.persistence.entitity.AreaManagerEntity;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class AreaManagerEntityMapper {


    private final AreaEntityMapper areaMapper;
    private final UserEntityMapper userMapper;


    public AreaManager toDomain(AreaManagerEntity entity) {
        if (entity == null) {
            return null;
        }

        AreaManager domain = new AreaManager();
        domain.setId(entity.getId());

        domain.setArea(areaMapper.toDomain(entity.getArea()));
        domain.setUser(userMapper.toDomain(entity.getUser()));

        return domain;
    }


    public AreaManagerEntity toEntity(AreaManager domain) {
        if (domain == null) {
            return null;
        }

        AreaManagerEntity entity = new AreaManagerEntity();
        entity.setId(domain.getId());

        entity.setArea(areaMapper.toEntity(domain.getArea()));
        entity.setUser(userMapper.toEntity(domain.getUser()));

        return entity;
    }
}