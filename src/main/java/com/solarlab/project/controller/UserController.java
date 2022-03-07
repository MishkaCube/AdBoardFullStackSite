package com.solarlab.project.controller;

import com.solarlab.project.service.UsersService;
import com.solarlab.project.user.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UsersService usersService;

    @GetMapping
    public List<Users> getUser() {
        return usersService.getUser();
    }
}
