package com.hiddenFounders.shops.services;

import java.util.List;

import com.hiddenFounders.shops.Utils.STATUS;
import com.hiddenFounders.shops.entities.Shop;
import com.hiddenFounders.shops.entities.User;
import com.hiddenFounders.shops.entities.UserShops;

public interface DbService {
	
    User createUser(User user);

    void deleteUser(String id);

    List<User> findAllUser();

    User findUserById(String id);

    User findUserByEmail(String email);

    User updateUser(User user);

    void deleteAllUsers();

    void addShopToLikeList(String userEmail, String idShop);

    void addShopToDislikeList(String userEmail, String idShop);

    void removeShopFromList(String userEmail, String idShop, STATUS status);

    Shop createShop(Shop shop);

    void deleteShop(String id);

    List<Shop> findAllShop();

    Shop findShopById(String id);

    List<Shop> findAllLikedShop(String idUser);

    List<Shop> findAllDislikedShop(String idUser);

    List<Shop> findAllNotCommentedShop(String email);

    UserShops createUserShops(UserShops status);

    void deleteUserShops(UserShops status);

    List<UserShops> findAllUserShopsWhere(String idUser, STATUS status);

    UserShops updateUserShops(UserShops status);

}
