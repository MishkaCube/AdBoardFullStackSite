package com.solarlab.project.repository;

import com.solarlab.project.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
