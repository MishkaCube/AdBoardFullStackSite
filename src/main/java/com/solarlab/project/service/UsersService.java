package com.solarlab.project.service;

import com.solarlab.project.repository.UsersRepository;
import com.solarlab.project.user.Users;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    public List<Users> getUser() { return usersRepository.findAll(); }

    public void addUser(Users users) {
        Optional<Users> usersOptional = usersRepository.findByEmail(users.getEmail());
        if (usersOptional.isPresent()) {
            throw new IllegalStateException("EMail is already exists.");
        }
        usersRepository.save(users);
    }

    public void deleteUserById(Long id) {
        boolean exists = usersRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("This user doesn't exists.");
        } else {
            usersRepository.deleteById(id);
        }
    }

    @Transactional
    public void putUser(Long id) {
        boolean exists = usersRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("This user doesn't exists");
        } else {
            return;
        }
    }
}
