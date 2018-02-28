package com.hiddenFounders.shops.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hiddenFounders.shops.Utils.STATUS;


@Document(collection = "userShops")
public class UserShops {
	@Id
	private String id;
    private STATUS status;
	private Date dislikeDate;
    private String idShop;

	public UserShops(String id, STATUS status, Date dislikeDate, String idShop) {
		super();
		this.id = id;
		this.status = status;
		this.dislikeDate = dislikeDate;
		this.idShop = idShop;
	}
	
	public UserShops(STATUS status, String idShop) {
		super();
		this.status = status;
		this.idShop = idShop;
	}
	
	public UserShops(STATUS status, String idShop,Date dislikeDate) {
		super();
		this.status = status;
		this.dislikeDate = dislikeDate;
		this.idShop = idShop;
	}
	
	public UserShops() {
		super();
	}
	

	public String getId() {
		return id;
	}

	public STATUS getStatus() {
		return status;
	}

	public Date getDislikeDate() {
		return dislikeDate;
	}

	public String getIdShop() {
		return idShop;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	public void setDislikeDate(Date dislikeDate) {
		this.dislikeDate = dislikeDate;
	}

	public void setIdShop(String idShop) {
		this.idShop = idShop;
	}

    

}
