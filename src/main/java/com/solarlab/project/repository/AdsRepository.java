package com.solarlab.project.repository;

import com.solarlab.project.entity.Advertisment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdsRepository extends PagingAndSortingRepository<Advertisment, Long> {

    List<Advertisment> findByTitle(String title);

}
