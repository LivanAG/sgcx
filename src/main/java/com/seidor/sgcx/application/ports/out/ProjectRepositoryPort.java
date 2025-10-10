package com.seidor.sgcx.application.ports.out;

import com.seidor.sgcx.domain.model.Project;

import java.util.List;

public interface ProjectRepositoryPort {

    List<Project> findAll();

    List<Project> findByAreaId(Long id);

}
