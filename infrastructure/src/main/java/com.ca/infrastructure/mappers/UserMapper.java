package com.ca.infrastructure.mappers;

import com.ca.core.domain.User;
import com.ca.infrastructure.entity.UserEntity;

public class UserMapper {
    public UserEntity toUserEntity(User user) {
        return new UserEntity(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getTaxNumber().toString(),
                user.getFullname(),
                user.getType(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
