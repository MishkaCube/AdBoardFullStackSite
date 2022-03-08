package com.solarlab.project.repository;

import com.solarlab.project.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsersRepository extends
        JpaRepository<Users, Long> {

    @Query("SELECT u FROM USERS u WHERE u.email = ?1")
    Optional<Users> findByEmail(String email);
}
