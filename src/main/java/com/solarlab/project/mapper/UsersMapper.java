package com.solarlab.project.mapper;

import com.solarlab.project.entity.Usr;
import com.solarlab.project.user.UserCreateDto;
import com.solarlab.project.user.UserDto;
import com.solarlab.project.user.UsersUpdate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    UserDto userToUserDto(Usr entity);
    Usr userUpdateRequest(UsersUpdate dto, Long id);
    Usr toUser(UserCreateDto dto);

}
