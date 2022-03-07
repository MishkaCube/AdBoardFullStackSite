package com.solarlab.project.service;

import com.solarlab.project.repository.UsersRepository;
import com.solarlab.project.user.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    public List<Users> getUser() {
        return usersRepository.findAll();
    }
}
