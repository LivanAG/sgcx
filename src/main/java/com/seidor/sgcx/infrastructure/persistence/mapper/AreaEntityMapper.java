package com.seidor.sgcx.infrastructure.persistence.mapper;
import com.seidor.sgcx.domain.model.Area;
import com.seidor.sgcx.infrastructure.persistence.entitity.AreaEntity;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AreaEntityMapper {

    private final GroupEntityMapper groupMapper;

    public Area toDomain(AreaEntity entity) {
        if (entity == null) return null;
        Area area = new Area();
        area.setId(entity.getId());
        area.setName(entity.getName());
        area.setShortName(entity.getShortName());
        area.setGroup(groupMapper.toDomain(entity.getGroup()));
        return area;
    }

    public AreaEntity toEntity(Area domain) {
        if (domain == null) return null;
        AreaEntity entity = new AreaEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setShortName(domain.getShortName());
        entity.setGroup(groupMapper.toEntity(domain.getGroup()));
        return entity;
    }
}