package com.atmira.nasa.model.neo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ObjAsteroids {
	
	private List<NearEarthObj> near_earth_objects;

	public List<NearEarthObj> getNear_earth_objects() {
		return near_earth_objects;
	}
}
