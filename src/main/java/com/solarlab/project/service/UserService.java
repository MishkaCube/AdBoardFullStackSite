package com.solarlab.project.service;

import com.solarlab.project.users.UsersCreateDto;
import com.solarlab.project.users.UsersDto;
import com.solarlab.project.entity.Users;
import com.solarlab.project.mapper.UserMapper;
import com.solarlab.project.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {
    private final UserRepository repository;

    @Autowired
    private final UserMapper mapper;
    public Iterable<Users> getUsers() {
        return repository.findAll();
    }

    public UsersDto createUser(UsersCreateDto userRequest) {

        Users user = mapper.toUsersCreateDto(userRequest);
        user = repository.save(user);
        return mapper.usersDtoToUsers(user);
    }

}
