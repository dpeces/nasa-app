package com.atmira.nasa.model.neo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Diameter {

	private Kilometers kilometers;

	private Double mean;

	public Diameter() {
	}

	public Kilometers getKilometers() {
		return kilometers;
	}

	public Double getMean() {
		return (Double.parseDouble(kilometers.getEstimated_diameter_max())
				+ Double.parseDouble(kilometers.getEstimated_diameter_min()) / 2);
	}

	public void setMean(Double mean) {
		this.mean = mean;
	}

	public void setKilometers(Kilometers kilometers) {
		this.kilometers = kilometers;
	}

}
