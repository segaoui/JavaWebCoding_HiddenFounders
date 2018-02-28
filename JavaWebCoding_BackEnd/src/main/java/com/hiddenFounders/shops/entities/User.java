package com.hiddenFounders.shops.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
	@Id
	private String id;
	private String username;
	private String email;
	private String password;
    private List<UserShops> shopLiked;
    private List<UserShops> shopDisliked;

	public User(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public User(String id, String username, String email, String password) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
	}

    public User(String email, String password, List<UserShops> shopLiked, List<UserShops> shopdisliked) {
        this.email = email;
        this.password = password;
        this.shopLiked = shopLiked;
        this.shopDisliked = shopdisliked;
    }
    
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public List<UserShops> getShopLiked() {
		return shopLiked;
	}

	public List<UserShops> getShopDisliked() {
		return shopDisliked;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setShopLiked(List<UserShops> shopLiked) {
		this.shopLiked = shopLiked;
	}

	public void setShopDisliked(List<UserShops> shopDisliked) {
		this.shopDisliked = shopDisliked;
	}

	
}
