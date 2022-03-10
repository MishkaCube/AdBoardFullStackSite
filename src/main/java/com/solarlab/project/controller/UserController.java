package com.solarlab.project.controller;

import com.solarlab.project.service.UsersService;
import com.solarlab.project.user.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UsersService usersService;

    @GetMapping("/getuser")
    public List<Users> getUser() {
        return usersService.getUser();
    }

    @PostMapping(path = "/adduser")
    public void registerNewUser(@RequestBody Users users) {
        usersService.addUser(users);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        usersService.deleteUserById(id);
    }

    /*
    @PutMapping(path = "/insertuser/{id}")
    public void putUser(@PathVariable("id"), Long id) {
        usersService.putUser(id);
    }

     */
}
