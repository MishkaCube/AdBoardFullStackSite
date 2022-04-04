package com.solarlab.project.repository;

import com.solarlab.project.entity.Advertisments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdsRepository extends JpaRepository<Advertisments, Long> {
}
