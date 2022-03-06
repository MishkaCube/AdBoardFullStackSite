package com.solarlab.project.controller;

import com.solarlab.project.user.user;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class TaskController {

    @GetMapping("/people")
    public List<user> start() {
        return List.of(
                new user(
                        1L,
                        "Michael",
                        "michael@gmail.com",
                        13,
                        15
                ));
    }
}
