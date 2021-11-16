package com.atmira.nasa.model.neo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CloseApproachData {

	private String close_approach_date;

	private RelativeVelocity relative_velocity;
	
	private String orbiting_body;

	public String getClose_approach_date() {
		return close_approach_date;
	}

	public RelativeVelocity getRelative_velocity() {
		return relative_velocity;
	}

	public String getOrbiting_body() {
		return orbiting_body;
	}

	public void setClose_approach_date(String close_approach_date) {
		this.close_approach_date = close_approach_date;
	}

	public void setRelative_velocity(RelativeVelocity relative_velocity) {
		this.relative_velocity = relative_velocity;
	}

	public void setOrbiting_body(String orbiting_body) {
		this.orbiting_body = orbiting_body;
	}
	
	

}
