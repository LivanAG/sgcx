package com.seidor.sgcx.application.service;

import com.seidor.sgcx.application.ports.in.GetProjectsOverviewByUserUseCase;
import com.seidor.sgcx.application.ports.out.ProjectManagerRepositoryPort;
import com.seidor.sgcx.application.ports.out.ProjectRepositoryPort;
import com.seidor.sgcx.application.ports.out.UserRepositoryPort;
import com.seidor.sgcx.domain.model.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProjectApplicationService implements GetProjectsOverviewByUserUseCase {

    private final UserApplicationService userApplicationService;
    private final ProjectRepositoryPort projectRepositoryPort;
    private final AreaManagerApplicationService areaManagerApplicationService;
    private final ProjectManagerRepositoryPort projectManagerRepositoryPort;
    private final PermissionsApplicationService permissionsApplicationService;



    @Override
    public List<Project> getProjectsOverviewByUser(Long userId) {

        //Este metodo debe recuperar el User a partir del userId
        User user = userApplicationService.getUserById(userId);

        //Obtengo sus permisos
        AccessLevel accessLevel = permissionsApplicationService.getUserAccessLevel(user.getId());
        List<Project> projects = new ArrayList<>();


        //Caso 1 Full Access
        if(accessLevel.equals(AccessLevel.FULL_ACCESS)){
            projects = projectRepositoryPort.findAll();
            return projects;
        }


        //Caso 2 Area Manager Access
        if(accessLevel.equals(AccessLevel.MANAGER)){
            List<AreaManager> areaManager = areaManagerApplicationService.findByUserId(user.getId());
            List<ProjectManagerAssignment> projectManagerAssignments = projectManagerRepositoryPort.findByUserId(user.getId());

            for (AreaManager area : areaManager) {
                projects.addAll(projectRepositoryPort.findByAreaId(area.getId()));
            }

            //Recuperamos los ids de las areas que es manager
            List<Long> areaManagerId = areaManager.stream().map(AreaManager::getId).toList();

            for (ProjectManagerAssignment projectManagerAssignment : projectManagerAssignments) {
                Long projectAreaId = projectManagerAssignment.getProject().getArea().getId();
                if(!areaManagerId.contains(projectAreaId)){
                    projects.add(projectManagerAssignment.getProject());
                }
            }

            return projects;
        }

        //Caso 3 Project Manager Access
        List<ProjectManagerAssignment> projectManagerAssignments = projectManagerRepositoryPort.findByUserId(user.getId());
        for (ProjectManagerAssignment projectManagerAssignment : projectManagerAssignments) {
                projects.add(projectManagerAssignment.getProject());
        }

        return projects;

        }

}
