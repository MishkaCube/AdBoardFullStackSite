package com.solarlab.project.service;

import com.solarlab.project.repository.UsersRepository;
import com.solarlab.project.user.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    public List<Users> getUser() { return usersRepository.findAll(); }

    public void addUser(Users users) {
        Optional<Users> usersOptional = usersRepository
                .findByEmail(users.getEmail());
        if (usersOptional.isPresent()) {
            throw new IllegalStateException("EMail is already exists.");
        }
        usersRepository.save(users);
    }
}
