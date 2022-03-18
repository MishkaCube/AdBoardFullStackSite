package com.solarlab.project.controller;

import com.solarlab.project.service.UsersService;
import com.solarlab.project.entity.User;
import com.solarlab.project.user.UserCreateDto;
import com.solarlab.project.user.UserDto;
import com.solarlab.project.user.UsersUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final UsersService usersService;

    @GetMapping("v1/getuser")
    public ResponseEntity<Iterable<User>> getTasks(
            @RequestParam(value = "limit", required = false) Integer limit) {
        return ResponseEntity.ok(usersService.getUser());
    }

    @PutMapping(path = "v1/insertuser/{userId}")
    public ResponseEntity<UserDto> updateUser(
            @PathVariable("userId") Long userId ,
            @RequestBody(required = false) UsersUpdate request) {
        return ResponseEntity.ok(usersService.update(userId, request));
    }

    @DeleteMapping( value = "/v1/deleteuser/{userId}")
    public ResponseEntity<Void> deleteTask(@PathVariable("userId") Long userId) {
        usersService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/v1/adduser")
    public ResponseEntity<UserDto> createTask(@RequestBody UserCreateDto request) {
        return new ResponseEntity<>(usersService.create(request), HttpStatus.CREATED);
    }


}
