package com.hiddenFounders.shops.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hiddenFounders.shops.entities.Shop;

@Repository
public interface ShopRepository extends MongoRepository<Shop, String>{

}
