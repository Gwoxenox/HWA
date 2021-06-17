package com.qa.hwa.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Race {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer raceId;
	
	private Integer raceNo;
	private String circuit;
	private Integer noOfLaps;
	
	@ManyToOne
	private Series series;
	
	public Race(Integer raceNo, String circuit, Integer noOfLaps, Series series) {
		this.raceNo = raceNo;
		this.circuit = circuit;
		this.noOfLaps = noOfLaps;
		this.series = series;
	}
	
	public Race(Integer id, Integer raceNo, String circuit, Integer noOfLaps, Series series) {
		this.raceId = id;
		this.raceNo = raceNo;
		this.circuit = circuit;
		this.noOfLaps = noOfLaps;
		this.series = series;
	}

	public Integer getRaceId() {
		return raceId;
	}

	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}

	public Integer getRaceNo() {
		return raceNo;
	}

	public void setRaceNo(Integer raceNo) {
		this.raceNo = raceNo;
	}

	public String getCircuit() {
		return circuit;
	}

	public void setCircuit(String circuit) {
		this.circuit = circuit;
	}

	public Integer getNoOfLaps() {
		return noOfLaps;
	}

	public void setNoOfLaps(Integer noOfLaps) {
		this.noOfLaps = noOfLaps;
	}

	public Series getSeries() {
		return series;
	}

	public void setSeries(Series series) {
		this.series = series;
	}


}
