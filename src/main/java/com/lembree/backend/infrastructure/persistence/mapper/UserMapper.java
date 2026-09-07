package com.lembree.backend.infrastructure.persistence.mapper;


import com.lembree.backend.domain.model.User;
import com.lembree.backend.infrastructure.persistence.entity.UserEntity;

public class UserMapper {

    public static User toDomain(UserEntity userEntity) {
        return new User(
            userEntity.getId(),
            userEntity.getName(),
            userEntity.getEmail(),
            userEntity.getHashPassword(),
            userEntity.getStandardDeadlineHours(),
            userEntity.isActivePersistentNotification(),
            userEntity.getCreatedOn()
        );
    }

    public static UserEntity toEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setHashPassword(user.getHashPassword());
        userEntity.setStandardDeadlineHours(user.getStandardDeadlineHours());
        userEntity.setActivePersistentNotification(user.isActivePersistentNotification());
        userEntity.setCreatedOn(user.getCreatedOn());
        return userEntity;
    }
}
