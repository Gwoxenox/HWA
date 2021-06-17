package com.qa.hwa.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Series {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer seriesId;
	
	private String name;
	private String car;
	
	@OneToMany(mappedBy = "series")
	@JsonIgnore
	private List<Race> races;
	
	public Series(String name, String car) {
		this.name = name;
		this.car = car;
	}
	
	public Series(Integer id, String name, String car) {
		this.seriesId = id;
		this.name = name;
		this.car = car;
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

	public List<Race> getRaces() {
		return races;
	}

	public void setRaces(List<Race> races) {
		this.races = races;
	}

}
