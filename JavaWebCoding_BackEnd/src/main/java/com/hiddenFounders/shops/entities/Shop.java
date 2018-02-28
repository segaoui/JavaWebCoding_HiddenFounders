package com.hiddenFounders.shops.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shops")
public class Shop {

	@Id
	private String id;
	private String picture;
	private String name;
	private String email;
	private String city;
	private Location location;

	public Shop() {
		super();
	}

	public Shop(String picture, String name, String email, String city, Location location) {
		super();
		this.picture = picture;
		this.name = name;
		this.email = email;
		this.city = city;
		this.location = location;
	}

	public Shop(String id, String picture, String name, String email, String city, Location location) {
		super();
		this.id = id;
		this.picture = picture;
		this.name = name;
		this.email = email;
		this.city = city;
		this.location = location;
	}

	public String getId() {
		return id;
	}

	public String getPicture() {
		return picture;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getCity() {
		return city;
	}

	public Location getlocation() {
		return location;
	}

}