package com.seidor.sgcx.application.ports.in;

import com.seidor.sgcx.domain.model.Project;

import java.util.List;

public interface GetProjectsOverviewByUserUseCase {
    List<Project> getProjectsOverviewByUser(Long userId);
}
