package com.solarlab.project.mapper;

import com.solarlab.project.entity.User;
import com.solarlab.project.user.UserCreateDto;
import com.solarlab.project.user.UserDto;
import com.solarlab.project.user.UsersUpdate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    UserDto userToUserDto(User entity);
    User taskUpdateRequest(UsersUpdate dto, Long id);
    User toUser(UserCreateDto dto);

}
