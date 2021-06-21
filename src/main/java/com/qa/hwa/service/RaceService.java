package com.qa.hwa.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.qa.hwa.domain.Race;
import com.qa.hwa.dto.RaceDTO;
import com.qa.hwa.utils.RaceMapper;

import org.springframework.data.jpa.repository.JpaRepository;


@Service
public class RaceService {

	private JpaRepository<Race, Integer> repo;

	private RaceMapper mapper;

	public RaceService(JpaRepository<Race, Integer> repo, RaceMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	public RaceDTO createRace(Race race) {
		Race saved = this.repo.save(race);
		return this.mapper.mapToDTO(saved);
	}

	public RaceDTO findRace(Integer id) {
		Optional<Race> optionalRace = this.repo.findById(id);
		Race found = optionalRace.orElseThrow(() -> new EntityNotFoundException());
		return this.mapper.mapToDTO(found);
	}

	public RaceDTO updateRace(Integer id, Race newData) {
		Race existing = this.repo.findById(id).orElseThrow(() -> new EntityNotFoundException());
																								
		existing.setRaceNo(newData.getRaceNo());
		existing.setCircuit(newData.getCircuit());
		existing.setNoOfLaps(newData.getNoOfLaps());
		Race updated = this.repo.save(existing);
		return this.mapper.mapToDTO(updated);
	}

	public boolean delete(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	public List<RaceDTO> getRace() {
		return this.repo.findAll().stream().map(race -> this.mapper.mapToDTO(race)).collect(Collectors.toList());
	}

}