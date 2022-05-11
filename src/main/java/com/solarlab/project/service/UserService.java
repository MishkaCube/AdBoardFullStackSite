//package com.solarlab.project.service;
//
//import com.solarlab.project.Users.UsersDto;
//import com.solarlab.project.entity.User;
//import com.solarlab.project.mapper.UsersMapper;
//import com.solarlab.project.repository.UsersRepository;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//Недопиленный сервис когда еще пользовался code-first
//@Service
//@Slf4j
//@AllArgsConstructor
//public class UserService {
//    private final UsersRepository repository;
//    private final UsersMapper mapper;
//
//    public Iterable<User> getUsers() {
//        return repository.findAll();
//    }
//
//    public UsersDto createUser(UsersDto userRequest) {
//        User user = mapper.toUser(userRequest);
//        user = repository.save(user);
//        return mapper.userToUser(user);
//    }
//}
