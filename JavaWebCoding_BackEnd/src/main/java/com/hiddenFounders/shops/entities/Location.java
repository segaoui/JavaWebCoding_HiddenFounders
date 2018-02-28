package com.hiddenFounders.shops.entities;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Location {

	private String type;
	private List<Float> coordinates;

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Location(String type, List<Float> coordinates) {
		super();
		this.type = type;
		this.coordinates = coordinates;
	}

	public String getType() {
		return type;
	}

	public List<Float> getCoordinates() {
		return coordinates;
	}

}
