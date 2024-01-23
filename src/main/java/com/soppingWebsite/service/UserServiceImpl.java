package com.soppingWebsite.service;

import com.soppingWebsite.model.CustomUser;
import com.soppingWebsite.model.CustomUserRequest;
import com.soppingWebsite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    FavoriteItemService favoriteItemService;
    @Autowired
    OrderService orderService;

    @Override
    public void createUser(CustomUserRequest customUserRequest) throws Exception {
        CustomUser existingUser = userRepository.findUserByUsername(customUserRequest.getUsername());
        if(existingUser != null){
            throw new Exception("Username is already taken");
        }
        userRepository.createUser(customUserRequest.toCustomUser());
    }

    @Override
    public void deleteUserById(Long userId) {
        if(userRepository.getUserById(userId) != null){
            orderService.deleteOrderByUserId(userId);
            favoriteItemService.deleteFavoriteItemByUserId(userId);
            userRepository.deleteUserById(userId);
        } else {
            throw new IllegalArgumentException("User does not exist");
        }
    }

    @Override
    public CustomUser getUserById(Long userId) {
        return userRepository.getUserById(userId);
    }

    @Override
    public CustomUser findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
