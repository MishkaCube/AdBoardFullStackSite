package com.solarlab.project.service;

import com.solarlab.project.user.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UsersService {
    @GetMapping
    public List<User> getUser() {
        return List.of(new User(
                        1L,
                        "Michael",
                        "michael@gmail.com",
                        13,
                        15)
        );
    }
}
