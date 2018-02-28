package com.hiddenFounders.shops;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hiddenFounders.shops.entities.User;
import com.hiddenFounders.shops.repository.UserRepository;

@SpringBootApplication
public class ShopsApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShopsApplication.class, args);
	}

}
