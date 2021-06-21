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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hwa.domain.Race;
import com.qa.hwa.dto.RaceDTO;
import com.qa.hwa.service.RaceService;

@RestController
@RequestMapping("/race")
public class RaceController {

	private RaceService service;

	@Autowired
	public RaceController(RaceService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public RaceDTO createRace(@RequestBody Race race) {
		return this.service.createRace(race);
	}

	@GetMapping("/find/{id}")
	public RaceDTO find(@PathVariable int id) {
		return this.service.findRace(id);
	}

	@GetMapping("/")
	public List<RaceDTO> getRace() {
		return this.service.getRace();
	}

	@PutMapping("/update/{id}")
	public RaceDTO updateRace(@RequestBody Race race, @PathVariable int id) {
		return this.service.updateRace(id, race);
	}

	@DeleteMapping("/remove/{id}")
	public boolean delete(@PathVariable int id) {
		return this.service.delete(id);
	}

}