package com.solarlab.project.repository;

import com.solarlab.project.entity.Advertisment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdsRepository extends PagingAndSortingRepository<Advertisment, Long> {

}
