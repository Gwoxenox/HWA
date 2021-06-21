package com.qa.hwa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hwa.domain.Series;
import com.qa.hwa.dto.SeriesDTO;
import com.qa.hwa.service.SeriesService;

@RestController
@RequestMapping("/series")
public class SeriesController {

	private SeriesService service;

	@Autowired
	public SeriesController(SeriesService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public SeriesDTO createSeries(@RequestBody Series series) {
		return this.service.createSeries(series);
	}

	@GetMapping("/find/{id}")
	public SeriesDTO find(@PathVariable int id) {
		return this.service.findSeries(id);
	}

	@GetMapping("/")
	public List<SeriesDTO> getSeries() {
		return this.service.getSeries();
	}

	@PutMapping("/update/{id}")
	public SeriesDTO updateSeries(@RequestBody Series series, @PathVariable int id) {
		return this.service.updateSeries(id, series);
	}

	@DeleteMapping("/remove/{id}")
	public boolean delete(@PathVariable int id) {
		return this.service.delete(id);
	}

}