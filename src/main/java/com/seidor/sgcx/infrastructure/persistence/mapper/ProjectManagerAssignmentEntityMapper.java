package com.seidor.sgcx.infrastructure.persistence.mapper;
import com.seidor.sgcx.domain.model.ProjectManagerAssignment;
import com.seidor.sgcx.infrastructure.persistence.entitity.ProjectManagerAssignmentEntity;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

// Nota: Asegúrate de que UserEntityMapper y ProjectEntityMapper existan y sean @Component
@Component
@RequiredArgsConstructor
public class ProjectManagerAssignmentEntityMapper {

    // Inyección de mappers de las entidades relacionadas
    private final UserEntityMapper userMapper;
    private final ProjectEntityMapper projectMapper;

    /**
     * Mapea desde la Entidad de Persistencia (ProjectManagerAssignmentEntity)
     * al Modelo de Dominio (ProjectManagerAssignment).
     */
    public ProjectManagerAssignment toDomain(ProjectManagerAssignmentEntity entity) {
        if (entity == null) {
            return null;
        }

        ProjectManagerAssignment domain = new ProjectManagerAssignment();
        domain.setId(entity.getId());

        domain.setUser(userMapper.toDomain(entity.getUser()));
        domain.setProject(projectMapper.toDomain(entity.getProject()));

        return domain;
    }

    /**
     * Mapea desde el Modelo de Dominio (ProjectManagerAssignment)
     * a la Entidad de Persistencia (ProjectManagerAssignmentEntity).
     */
    public ProjectManagerAssignmentEntity toEntity(ProjectManagerAssignment domain) {
        if (domain == null) {
            return null;
        }

        ProjectManagerAssignmentEntity entity = new ProjectManagerAssignmentEntity();
        entity.setId(domain.getId());

        entity.setUser(userMapper.toEntity(domain.getUser()));
        entity.setProject(projectMapper.toEntity(domain.getProject()));

        return entity;
    }
}