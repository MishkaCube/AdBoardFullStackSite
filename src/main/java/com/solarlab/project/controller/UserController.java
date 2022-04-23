package com.solarlab.project.controller;

import com.solarlab.project.entity.Usr;
import com.solarlab.project.service.UsersService;
import com.solarlab.project.user.UserCreateDto;
import com.solarlab.project.user.UserDto;
import com.solarlab.project.user.UsersUpdate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Tag(name = "UserController", description = "API контролера по работе с пользователями")
public class UserController {

    private final UsersService usersService;

    @Operation(description = "Получение списка пользователей")
    @GetMapping("api/getuser")
    public ResponseEntity<Iterable<Usr>> getUser() {
        return ResponseEntity.ok(usersService.getUser());
    }

    @Operation(description = "Обновление пользователя")
    @PutMapping(path = "api/insertuser/{userId}")
    public ResponseEntity<UserDto> updateUser(
            @PathVariable("userId") Long userId ,
            @RequestBody(required = false) UsersUpdate request) {
        return ResponseEntity.ok(usersService.update(userId, request));
    }

    @Operation(description = "Удаление пользователя")
    @DeleteMapping( value = "api/deleteuser/{userId}")
    public ResponseEntity<Void> deleteTask(@PathVariable("userId") Long userId) {
        usersService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }


    @Operation(description = "Добавление пользователя")
    @PostMapping(value = "api/adduser")
    public ResponseEntity<UserDto> createTask(@RequestBody UserCreateDto request) {
        return new ResponseEntity<>(usersService.create(request), HttpStatus.CREATED);
    }


}
