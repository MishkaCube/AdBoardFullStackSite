package com.solarlab.project.service;

import com.solarlab.project.users.UsersCreateDto;
import com.solarlab.project.users.UsersDto;
import com.solarlab.project.entity.Users;
import com.solarlab.project.mapper.UserMapper;
import com.solarlab.project.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final BCryptPasswordEncoder passwordEncoder;

    public List<Users> getUsers() {
        return repository.findAll();
    }

    public UsersDto createUser(UsersCreateDto userRequest) {
        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        Users user = mapper.toUsersCreateDto(userRequest);
        user = repository.save(user);
        return mapper.usersDtoToUsers(user);
    }

}
