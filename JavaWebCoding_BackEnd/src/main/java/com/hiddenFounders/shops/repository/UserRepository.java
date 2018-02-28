package com.hiddenFounders.shops.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hiddenFounders.shops.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
