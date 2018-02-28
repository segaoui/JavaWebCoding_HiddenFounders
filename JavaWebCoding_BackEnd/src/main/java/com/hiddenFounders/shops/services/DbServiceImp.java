package com.hiddenFounders.shops.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiddenFounders.shops.entities.Shop;
import com.hiddenFounders.shops.entities.User;
import com.hiddenFounders.shops.entities.UserShops;
import com.hiddenFounders.shops.repository.ShopRepository;
import com.hiddenFounders.shops.repository.UserRepository;
import com.hiddenFounders.shops.repository.UserShopRepository;
import com.hiddenFounders.shops.Utils.STATUS;

@Service
public class DbServiceImp implements DbService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShopRepository shopRepository;


    @Autowired
    private UserShopRepository userShopRepository;


    //######################################
    //-------------- USER ----------------
    //######################################
    @Override
    public User createUser(User user) {
        List<UserShops> likedUserShops = new ArrayList<>();
        for (UserShops status : user.getShopLiked()) {
            likedUserShops.add(createUserShops(status));
        }

        List<UserShops> dislikedUserShops = new ArrayList<>();
        for (UserShops status : user.getShopDisliked()) {
            dislikedUserShops.add(createUserShops(status));
        }

        User persist = new User(user.getEmail(),user.getPassword(),dislikedUserShops,likedUserShops);
        
        return userRepository.save(persist);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.delete(id);

    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }


    public User updateUser(User user){
        return userRepository.save(user);
    }

    @Override
    public User findUserById(String  id) {
        return userRepository.findOne(id);
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    public User findUserByEmail(String email) {
        List<User> userList = userRepository.findAll();
        for (User user : userList) {
            if (user.getEmail().equals(email))
                return user;
        }

        return null;
    }

    public void addShopToLikeList(String userEmail, String  idShop) {
        User user = findUserByEmail(userEmail);
        if (user == null) return;

        List<UserShops> statusList = findAllUserShopsWhere(user.getId(), STATUS.LIKE);
        UserShops status = new UserShops(STATUS.LIKE,idShop);
        
        status = userShopRepository.save(status);
        statusList.add(status);
        user.setShopLiked(statusList);
        userRepository.save(user);
    }

    public void addShopToDislikeList(String userEmail, String idShop) {
        User user = findUserByEmail(userEmail);
        if (user.getId() == null) return;

        List<UserShops> statusList = findAllUserShopsWhere(user.getId(),STATUS.DISLIKE);
        UserShops status = new UserShops(STATUS.DISLIKE,idShop);
        		
        status = userShopRepository.save(status);
        statusList.add(status);
        user.setShopDisliked(statusList);
        userRepository.save(user);
    }


    public void removeShopFromList(String userEmail, String idShop, STATUS statusCode) {
        User user = findUserByEmail(userEmail);
        if (user != null) {
            List<UserShops> statusList = new ArrayList<>();
            if (statusCode == STATUS.LIKE)
                statusList = user.getShopLiked();
            else
                statusList = user.getShopDisliked();

            UserShops status = new UserShops();

            boolean hasIdShop = false;

            for (UserShops s : statusList) {
                if (s.getIdShop().equals(idShop)) {
                    statusList.remove(s);
                    status = s;
                    hasIdShop = true;
                    break;
                }
            }

            if (hasIdShop) {
            	userShopRepository.delete(status);

                if (statusCode.compareTo(STATUS.LIKE) == 0)
                    user.setShopLiked(statusList);
                else
                    user.setShopDisliked(statusList);


                userRepository.save(user);
            }

        }
    }

    //######################################
    //-------------- SHOP ----------------
    //######################################

    @Override
    public Shop createShop(Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    public void deleteShop(String id) {
        shopRepository.delete(id);
    }

    @Override
    public List<Shop> findAllShop() {
        return shopRepository.findAll();
    }

    @Override
    public Shop findShopById(String id) {
        return shopRepository.findOne(id);
    }


    public List<Shop> findAllLikedShop(String idUser) {
        List<UserShops> statusList = findAllUserShopsWhere(idUser, STATUS.LIKE);
        List<Shop> shopList = new ArrayList<>();

        for (UserShops status : statusList) {
            shopList.add(findShopById(status.getIdShop()));
        }

        return shopList;
    }


    public List<Shop> findAllDislikedShop(String idUser) {
        List<UserShops> statusList = findAllUserShopsWhere(idUser, STATUS.DISLIKE);
        List<Shop> shopList = new ArrayList<>();

        for (UserShops status : statusList) {
            shopList.add(findShopById(status.getIdShop()));
        }

        return shopList;
    }


    public List<Shop> findAllNotCommentedShop(String email) {

    	String id = findUserByEmail(email).getId();
        List<UserShops> likedUserShopsList = findAllUserShopsWhere(id, STATUS.LIKE);
        List<UserShops> dislikedUserShopsList = findAllUserShopsWhere(id, STATUS.DISLIKE);

        List<UserShops> allUserShops = new ArrayList<>();
        allUserShops.addAll(dislikedUserShopsList);
        allUserShops.addAll(likedUserShopsList);

        List<Shop> shopList = findAllShop();

        HashSet<String> commentedIdShops = new HashSet<>();
        HashSet<String> idShops = new HashSet<>();
        for (UserShops status : allUserShops) {
            commentedIdShops.add(status.getIdShop());
        }

        for (Shop shop : shopList) {
            idShops.add(shop.getId());
        }

        idShops.removeAll(commentedIdShops);

        shopList = new ArrayList<>();

        for (String objectId : idShops) {
            shopList.add(findShopById(objectId));
        }

        return shopList;
    }


    //######################################
    //-------------- STATUS ----------------
    //######################################


    /**
     * @param status
     * @return
     */
    @Override
    public UserShops createUserShops(UserShops status) {
        return userShopRepository.save(status);
    }


    /**
     * @param status
     */
    @Override
    public void deleteUserShops(UserShops status) {
    	userShopRepository.delete(status);
    }


    /**
     * @param idUser
     * @param status
     * @return
     */
    @Override
    public List<UserShops> findAllUserShopsWhere(String idUser, STATUS status) {
        User user = userRepository.findOne(idUser);
        if (status.compareTo(STATUS.LIKE) == 0) {
            if (user.getShopLiked().isEmpty())
                return new ArrayList<>();
            return user.getShopLiked();
        } else {
            if (user.getShopDisliked().isEmpty())
                return new ArrayList<>();
            return user.getShopDisliked();
        }

    }

    @Override
    public UserShops updateUserShops(UserShops status) {
        UserShops oldUserShops = userShopRepository.findOne(status.getId());
        oldUserShops.setDislikeDate(status.getDislikeDate());
        oldUserShops.setStatus(status.getStatus());


        return userShopRepository.save(oldUserShops);
    }


}
