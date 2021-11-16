package com.atmira.nasa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import com.atmira.nasa.model.Asteroids;
import com.atmira.nasa.model.neo.CloseApproachData;
import com.atmira.nasa.model.neo.NearEarthObj;
import com.atmira.nasa.model.neo.ObjAsteroids;

@Service
public class NasaAppServiceImpl implements INasaAppService {

	private final String URL = "https://api.nasa.gov/neo/rest/v1/neo/browse?api_key=";
	private final String API_KEY = "zdUP8ElJv1cehFM0rsZVSQN7uBVxlDnu4diHlLSb";

	@Override
	public List<Asteroids> getAsteroids(String planet) {
		return getListAsteroids(getNeo(planet), planet);
	}

	@Override
	public ObjAsteroids getObjFromJsonNasa() {
		ObjAsteroids neo = new ObjAsteroids();
		try {
			Client cliente = ClientBuilder.newClient();
			neo = cliente.target(URL + API_KEY).request(MediaType.APPLICATION_JSON).get(ObjAsteroids.class);
			cliente.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return neo;
	}

	public List<NearEarthObj> getNeo(String planet) {

		List<NearEarthObj> neo = getObjFromJsonNasa().getNear_earth_objects();

		List<NearEarthObj> newNeo = neo.stream()
				.filter(n -> n.isIs_potentially_hazardous_asteroid() && n.getClose_approach_data().get(0).getOrbiting_body().equalsIgnoreCase(planet))
				.sorted((d1, d2) -> Double.compare(d2.getEstimated_diameter().getMean(),
						d1.getEstimated_diameter().getMean()))
				.limit(3L).collect(Collectors.toList());
		return newNeo;
	}

	public List<Asteroids> getListAsteroids(List<NearEarthObj> neos, String planet) {
		List<Asteroids> asteroids = new ArrayList<Asteroids>();
		for (NearEarthObj neo : neos) {
			asteroids.add(createAsteroids(neo, planet));
		}
		return asteroids;
	}

	public Asteroids createAsteroids(NearEarthObj neo, String planet) {
		Asteroids asteroid = new Asteroids();
		asteroid.setName(neo.getName());
		asteroid.setDiameter(neo.getEstimated_diameter().getMean());
		CloseApproachData cad = neo.getClose_approach_data().get(0);
		asteroid.setPlanet(cad.getOrbiting_body());
		asteroid.setDate(cad.getClose_approach_date());
		asteroid.setSpeed(cad.getRelative_velocity().getKilometers_per_hour());
		return asteroid;
	}

}
