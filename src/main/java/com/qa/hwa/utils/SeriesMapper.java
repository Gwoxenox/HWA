package com.qa.hwa.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.hwa.domain.Series;
import com.qa.hwa.domain.Race;
import com.qa.hwa.dto.SeriesDTO;
import com.qa.hwa.dto.RaceDTO;

@Service
public class SeriesMapper {

	private RaceMapper raceMapper;

	public SeriesMapper(RaceMapper raceMapper) {
		super();
		this.raceMapper = raceMapper;
	}

	public SeriesDTO mapToDTO(Series series) {
		SeriesDTO dto = new SeriesDTO();
		dto.setSeriesId(series.getSeriesId());
		dto.setName(series.getName());
		dto.setCar(series.getCar());
		List<RaceDTO> races = new ArrayList<>();
		for (Race race : series.getRaces()) {
			races.add(this.raceMapper.mapToDTO(race));
		}
		dto.setRaces(races);
		return dto;
	}

}
