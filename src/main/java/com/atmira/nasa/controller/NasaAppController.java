package com.atmira.nasa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atmira.nasa.exception.NasaAppException;
import com.atmira.nasa.model.Asteroids;
import com.atmira.nasa.service.INasaAppService;

@RestController
public class NasaAppController {

	@Autowired
	private INasaAppService nasaAppService;

	@GetMapping("/asteroids")
		public ResponseEntity<List<Asteroids>> getAsteroids(@RequestParam(name = "planet", required = true) String planet) throws NasaAppException {

		checkParam(planet);

		List<Asteroids> asteroids = nasaAppService.getAsteroids(planet);

		if (asteroids.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<>(asteroids, HttpStatus.OK);
	}

	private void checkParam(String planet) throws NasaAppException {
		if (planet == null || "".equals(planet)) {
			throw new NasaAppException("You must enter the name of the planet");
		}
	}

}
