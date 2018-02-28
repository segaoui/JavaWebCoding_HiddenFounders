package com.hiddenFounders.shops.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hiddenFounders.shops.entities.Shop;
import com.hiddenFounders.shops.services.DbService;

@RestController
@RequestMapping("/shops")
public class ShopController {

	@Autowired
	DbService dbService;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/all")
	public List<Shop> allShops() {
		return dbService.findAllShop();
	}

}
