package com.seidor.sgcx.infrastructure.persistence.adapter;

import com.seidor.sgcx.application.ports.out.UserRepositoryPort;
import com.seidor.sgcx.domain.model.User;
import com.seidor.sgcx.infrastructure.persistence.mapper.UserEntityMapper;
import com.seidor.sgcx.infrastructure.persistence.repository.UserJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserJpaRepository userJpaRepository;
    private final UserEntityMapper userEntityMapper;

    public UserRepositoryAdapter(UserJpaRepository userJpaRepository, UserEntityMapper userEntityMapper) {
        this.userJpaRepository = userJpaRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userJpaRepository.findById(id).map(userEntityMapper::toDomain);
    }

}
