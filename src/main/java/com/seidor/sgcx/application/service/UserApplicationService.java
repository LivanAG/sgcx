package com.seidor.sgcx.application.service;

import com.seidor.sgcx.application.ports.out.UserRepositoryPort;
import com.seidor.sgcx.domain.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserApplicationService {

    private final UserRepositoryPort userRepositoryPort;
    private final AreaManagerApplicationService areaManagerApplicationService;
    private final ProjectManagerApplicationService projectManagerApplicationService ;


    public User getUserById(Long id) {
        Optional<User> user = userRepositoryPort.findUserById(id);
        if (user.isEmpty()) {
            throw new RuntimeException("User not found");
        }else{
            return user.get();
        }
    }

    public boolean isUserManager(Long userId) {
        return areaManagerApplicationService.isAreaManager(userId);
    }

    public boolean isProjectManager(Long userId) {
        return projectManagerApplicationService.isProjectManager(userId);
    }
}
