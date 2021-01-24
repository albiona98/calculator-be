package com.school.app.mapper;

import com.school.app.db.entity.UserEntity;
import com.school.app.model.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

  User fromEntity(UserEntity userEntity);

  UserEntity toEntity(User user);
}
