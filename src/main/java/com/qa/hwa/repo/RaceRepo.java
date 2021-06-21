package com.qa.hwa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.hwa.domain.Race;

@Repository
public interface RaceRepo extends JpaRepository<Race,Integer> {

}
