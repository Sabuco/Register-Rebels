package com.concatel.restful.models;

import java.time.LocalDate;

public class Rebel {
	
	private int id;
	private String name;
	private String planet;
	private LocalDate datetime;
	
	public Rebel() {
		super();
	}
	
	
	public Rebel(int id, String name, String planet, LocalDate datetime) {
		super();
		this.id = id;
		this.name = name;
		this.planet = planet;
		this.datetime = datetime;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlanet() {
		return planet;
	}

	public void setPlanet(String planet) {
		this.planet = planet;
	}

	public LocalDate getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDate datetime) {
		this.datetime = datetime;
	}
	
	
}
