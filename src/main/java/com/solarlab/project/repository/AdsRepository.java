package com.solarlab.project.repository;

import com.solarlab.project.entity.Advertisments;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdsRepository extends PagingAndSortingRepository<Advertisments, Long> {
}
