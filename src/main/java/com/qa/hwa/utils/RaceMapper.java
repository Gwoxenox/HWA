package com.qa.hwa.utils;

import org.springframework.stereotype.Service;

import com.qa.hwa.domain.Race;
import com.qa.hwa.dto.RaceDTO;

@Service
public class RaceMapper {

	public RaceDTO mapToDTO(Race race) {
		RaceDTO dto = new RaceDTO();
		dto.setRaceId(race.getRaceId());
		dto.setRaceNo(race.getRaceNo());
		dto.setCircuit(race.getCircuit());
		dto.setNoOfLaps(race.getNoOfLaps());
		dto.setSeriesId(race.getSeriesId());

		return dto;
	}
}
