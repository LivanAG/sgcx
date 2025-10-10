package com.seidor.sgcx.infrastructure.persistence.repository;

import com.seidor.sgcx.infrastructure.persistence.entitity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectJpaRepository extends JpaRepository<ProjectEntity, Long> {

    /**
     * Busca todos los proyectos asociados a un ID de área específico.
     * Spring Data JPA traduce este nombre de método a la consulta:
     * WHERE area.id = :areaId
     * * Nota: 'Area' es el nombre de la propiedad en ProjectEntity.
     * '_Id' se usa para acceder a la clave primaria (ID) de la entidad AreaEntity.
     */
    List<ProjectEntity> findByArea_Id(Long areaId);

    /**
     * Alternativa: Usando JPQL para mayor claridad, aunque el método derivado es suficiente.
     * * @Query("SELECT p FROM ProjectEntity p WHERE p.area.id = :areaId")
     * List<ProjectEntity> findProjectsByAreaId(@Param("areaId") Long areaId);
     */
}