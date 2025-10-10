package com.seidor.sgcx.application.ports.out;

import com.seidor.sgcx.domain.model.User;

import java.util.Optional;

public interface UserRepositoryPort {
    Optional<User> findUserById(Long id);
}
