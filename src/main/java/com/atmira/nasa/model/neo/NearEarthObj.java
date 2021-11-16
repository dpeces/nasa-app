package com.atmira.nasa.model.neo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NearEarthObj {

	private String name;

	private Diameter estimated_diameter;

	private boolean is_potentially_hazardous_asteroid;

	private List<CloseApproachData> close_approach_data;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Diameter getEstimated_diameter() {
		return estimated_diameter;
	}

	public void setEstimated_diameter(Diameter estimated_diameter) {
		this.estimated_diameter = estimated_diameter;
	}

	public boolean isIs_potentially_hazardous_asteroid() {
		return is_potentially_hazardous_asteroid;
	}

	public void setIs_potentially_hazardous_asteroid(boolean is_potentially_hazardous_asteroid) {
		this.is_potentially_hazardous_asteroid = is_potentially_hazardous_asteroid;
	}

	public List<CloseApproachData> getClose_approach_data() {
		return close_approach_data;
	}

	public void setClose_approach_data(List<CloseApproachData> close_approach_data) {
		this.close_approach_data = close_approach_data;
	}
}
