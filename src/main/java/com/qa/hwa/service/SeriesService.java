package com.qa.hwa.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.qa.hwa.domain.Series;
import com.qa.hwa.dto.SeriesDTO;
import com.qa.hwa.utils.SeriesMapper;
import com.qa.hwa.repo.SeriesRepo;

@Service
public class SeriesService {

	private SeriesRepo repo;

	private SeriesMapper mapper;

	public SeriesService(SeriesRepo repo, SeriesMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	public SeriesDTO createSeries(Series series) {
		Series saved = this.repo.save(series);
		return this.mapper.mapToDTO(saved);
	}

	public SeriesDTO findSeries(Integer id) {
		Optional<Series> optionalseries = this.repo.findById(id);
		Series found = optionalseries.orElseThrow(() -> new EntityNotFoundException());
		return this.mapper.mapToDTO(found);
	}

	public SeriesDTO updateSeries(Integer id, Series newData) {
		Series existing = this.repo.findById(id).orElseThrow(() -> new EntityNotFoundException());
		existing.setName(newData.getName());
		existing.setCar(newData.getCar());
		existing.setRaces(newData.getRaces());
		Series updated = this.repo.save(existing);
		return this.mapper.mapToDTO(updated);
	}

	public boolean delete(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	public List<SeriesDTO> getSeries() {
		return this.repo.findAll().stream().map(series -> this.mapper.mapToDTO(series)).collect(Collectors.toList());
	}

}