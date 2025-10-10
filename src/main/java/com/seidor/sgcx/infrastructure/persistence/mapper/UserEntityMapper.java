package com.seidor.sgcx.infrastructure.persistence.mapper;

import com.seidor.sgcx.domain.model.User;
import com.seidor.sgcx.infrastructure.persistence.entitity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {

    public User toDomain(UserEntity entity) {
        User user = new User();
        user.setId(entity.getId());
        user.setUsername(entity.getUsername());
        user.setFullAccess(entity.isFullAccess());
        user.setName(entity.getName());

        return user;
    }

    public UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setUsername(user.getUsername());
        entity.setFullAccess(user.isFullAccess());
        entity.setName(user.getName());
        return entity;
    }
}
