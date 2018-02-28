package com.hiddenFounders.shops;

import java.util.Arrays;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hiddenFounders.shops.entities.Location;
import com.hiddenFounders.shops.entities.Shop;
import com.hiddenFounders.shops.entities.User;
import com.hiddenFounders.shops.entities.UserShops;
import com.hiddenFounders.shops.repository.UserRepository;
import com.hiddenFounders.shops.repository.UserShopRepository;

@Component
public class DBseeder implements CommandLineRunner {
	private UserRepository userRepository;
	private UserShopRepository userShopRepository;

	public DBseeder(UserRepository userRepository, UserShopRepository userShopRepository) {
		super();
		this.userRepository = userRepository;
		this.userShopRepository = userShopRepository;
	}

	@Override
	public void run(String... arg0) throws Exception {

		// userRepository.insert(Arrays.asList(new User("isam", "asa",
		// "saasa")));
		// userRepository.deleteAll();
		/*
		 * userRepository.insert(new User("isam", "asa", "saasa"));
		 * 
		 * userShopRepository.insert(new UserShops(true, false, new Date(), new
		 * User("isam", "asa", "saasa"), new Shop(null, "ffgd", "fsd", "sdfsdf",
		 * null)));
		 */
	}
}
