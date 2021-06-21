package com.qa.hwa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.hwa.domain.Series;

@Repository
public interface SeriesRepo extends JpaRepository<Series,Integer> {

}