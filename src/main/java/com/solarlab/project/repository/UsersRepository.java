package com.solarlab.project.repository;

import com.solarlab.project.entity.Usr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Usr, Long> {
    Optional<Usr> findByEmail(String email);
}
