package com.seidor.sgcx.application.service;

import com.seidor.sgcx.application.ports.out.ProjectManagerRepositoryPort;
import com.seidor.sgcx.application.ports.out.ProjectRepositoryPort;
import com.seidor.sgcx.domain.model.AccessLevel;
import com.seidor.sgcx.domain.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PermissionsApplicationService {


    private final UserApplicationService userApplicationService;
    private final ProjectManagerApplicationService projectManagerApplicationService ;


    public AccessLevel getUserAccessLevel(Long userId) {
        User user = userApplicationService.getUserById(userId);

        if(user.isFullAccess()){
            return AccessLevel.FULL_ACCESS;
        }
        else if(userApplicationService.isUserManager(userId)){
            return AccessLevel.MANAGER;
        }
        else if(userApplicationService.isProjectManager(user.getId())){
            return AccessLevel.PROJECT_MANAGER;
        }else{
            throw  new RuntimeException("Access Permission Not Found");
        }

    }
}
