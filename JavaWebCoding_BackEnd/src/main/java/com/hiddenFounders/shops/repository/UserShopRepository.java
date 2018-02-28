package com.hiddenFounders.shops.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.hiddenFounders.shops.entities.UserShops;

@Repository
public interface UserShopRepository extends MongoRepository<UserShops, String>{

}
