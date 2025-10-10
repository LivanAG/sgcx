package com.seidor.sgcx.infrastructure.persistence.mapper;

import com.seidor.sgcx.domain.model.Project;
import com.seidor.sgcx.infrastructure.persistence.entitity.ProjectEntity;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class ProjectEntityMapper {


    private final ClientEntityMapper clientMapper;
    private final AreaEntityMapper areaMapper;
    private final ProjectTypeEntityMapper projectTypeMapper;
    private final ProjectModelEntityMapper projectModelMapper;
    private final UserEntityMapper userMapper; // Para ProjectManager
    private final OfficeEntityMapper officeMapper; // Para SalesOffice y DeliveryOffice
    private final TechnologyEntityMapper technologyMapper;

    public Project toDomain(ProjectEntity entity) {
        if (entity == null) return null;

        Project project = new Project();
        project.setId(entity.getId());
        project.setPep(entity.getPep());
        project.setName(entity.getName());

        // Mapeo de campos simples
        project.setStartDate(entity.getStartDate());
        project.setSoldMargin(entity.getSoldMargin());
        project.setDivision(entity.getDivision());
        project.setCommercial(entity.getCommercial());

        // Mapeo de Entidades a Modelos de Dominio usando mappers
        project.setClient(clientMapper.toDomain(entity.getClient()));
        project.setArea(areaMapper.toDomain(entity.getArea()));
        project.setProjectType(projectTypeMapper.toDomain(entity.getProjectType()));
        project.setProjectModel(projectModelMapper.toDomain(entity.getProjectModel()));
        project.setProjectManager(userMapper.toDomain(entity.getProjectManager()));
        project.setSalesOffice(officeMapper.toDomain(entity.getSalesOffice()));
        project.setDeliveryOffice(officeMapper.toDomain(entity.getDeliveryOffice()));
        project.setTechnology(technologyMapper.toDomain(entity.getTechnology()));

        return project;
    }

    public ProjectEntity toEntity(Project project) {
        if (project == null) return null;

        ProjectEntity entity = new ProjectEntity();
        //entity.setId(project.getId());
        entity.setPep(project.getPep());
        entity.setName(project.getName());

        // Mapeo de campos simples
        entity.setStartDate(project.getStartDate());
        entity.setSoldMargin(project.getSoldMargin());
        entity.setDivision(project.getDivision());
        entity.setCommercial(project.getCommercial());

        // Mapeo de Modelos de Dominio a Entidades usando mappers
        entity.setClient(clientMapper.toEntity(project.getClient()));
        entity.setArea(areaMapper.toEntity(project.getArea()));
        entity.setProjectType(projectTypeMapper.toEntity(project.getProjectType()));
        entity.setProjectModel(projectModelMapper.toEntity(project.getProjectModel()));
        entity.setProjectManager(userMapper.toEntity(project.getProjectManager()));
        entity.setSalesOffice(officeMapper.toEntity(project.getSalesOffice()));
        entity.setDeliveryOffice(officeMapper.toEntity(project.getDeliveryOffice()));
        entity.setTechnology(technologyMapper.toEntity(project.getTechnology()));

        return entity;
    }
}