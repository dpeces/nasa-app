package com.atmira.nasa.model;

public class Asteroids {

	private String name;
	private Double diameter;
	private String speed;
	private String date;
	private String planet;

	public Asteroids() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDiameter() {
		return diameter;
	}

	public void setDiameter(Double diameter) {
		this.diameter = diameter;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPlanet() {
		return planet;
	}

	public void setPlanet(String planet) {
		this.planet = planet;
	}

	@Override
	public String toString() {
		return "Asteroids [name=" + name + ", diameter=" + diameter + ", speed=" + speed + ", date=" + date
				+ ", planet=" + planet + "]";
	}

}
