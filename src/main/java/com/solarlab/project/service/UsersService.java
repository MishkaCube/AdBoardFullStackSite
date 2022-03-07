package com.solarlab.project.service;

import com.solarlab.project.user.Users;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UsersService {
    @GetMapping
    public List<Users> getUser() {
        return null;
    }
}
