package com.qa.hwa.dto;

public class RaceDTO {

		private Integer raceId;
		private Integer raceNo;
		private String circuit;
		private Integer noOfLaps;	
		private Integer seriesId;
		
		public RaceDTO() {
			
		}
		
		public RaceDTO(Integer raceNo, String circuit, Integer noOfLaps, Integer seriesId) {
			this.raceNo = raceNo;
			this.circuit = circuit;
			this.noOfLaps = noOfLaps;
			this.seriesId = seriesId;
		}
		
		public RaceDTO(Integer id, Integer raceNo, String circuit, Integer noOfLaps, Integer seriesId) {
			this.raceId = id;
			this.raceNo = raceNo;
			this.circuit = circuit;
			this.noOfLaps = noOfLaps;
			this.seriesId = seriesId;
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

		public Integer getSeriesId() {
			return seriesId;
		}

		public void setSeriesId(Integer seriesId) {
			this.seriesId = seriesId;
		}
}
