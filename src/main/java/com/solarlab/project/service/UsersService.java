package com.solarlab.project.service;

import com.solarlab.project.entity.User;
import com.solarlab.project.mapper.UsersMapper;
import com.solarlab.project.repository.UsersRepository;
import com.solarlab.project.user.UserCreateDto;
import com.solarlab.project.user.UserDto;
import com.solarlab.project.user.UsersUpdate;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@Data
public class UsersService {

    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;

    public UsersService(UsersRepository usersRepository, UsersMapper usersMapper) {
        this.usersRepository = usersRepository;
        this.usersMapper = usersMapper;
    }

    public Iterable<User> getUser() { return usersRepository.findAll(); }

    public UserDto create(UserCreateDto request) {
        User user = usersMapper.toUser(request);
        usersRepository.save(user);
        return usersMapper.userToUserDto(user);
    }

    public void deleteById(Long userId) {
        usersRepository.deleteById(userId);
    }

    public UserDto update(Long userId, UsersUpdate request) {
        User user = usersMapper.taskUpdateRequest(request, userId);
        usersRepository.save(user);
        return usersMapper.userToUserDto(user);
    }


}
