package com.qa.hwa.dto;

import java.util.List;

public class SeriesDTO {

	private Integer seriesId;	
	private String name;
	private String car;
	private List<RaceDTO> races;
	
	public SeriesDTO() {
		
	}
	
	public SeriesDTO(String name, String car) {
		this.name = name;
		this.car = car;
	}
	
	public SeriesDTO(Integer id, String name, String car) {
		this.seriesId = id;
		this.name = name;
		this.car = car;
	}

	public List<RaceDTO> getRaces() {
		return races;
	}

	public void setRaces(List<RaceDTO> races) {
		this.races = races;
	}

	public Integer getSeriesId() {
		return seriesId;
	}

	public void setSeriesId(Integer seriesId) {
		this.seriesId = seriesId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}
	
	
}