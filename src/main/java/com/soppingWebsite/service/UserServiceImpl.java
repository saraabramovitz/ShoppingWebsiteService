package com.soppingWebsite.service;

import com.soppingWebsite.model.CustomUser;
import com.soppingWebsite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderService orderService;

    @Override
    public void createUser(CustomUser customUser) {
        if(customUser.getUserId() != null) {
            throw new IllegalArgumentException("Invalid id.");
        }
        if(userRepository.getUserByUsername(customUser.getUsername()) != null) {
            throw new IllegalArgumentException("Username already exist.");
        }
        userRepository.createUser(customUser);
    }

    @Override
    public void deleteUserById(Long userId) {
        if(userRepository.getUserById(userId) == null){
            throw new IllegalArgumentException("CustomUser id does not exist.");
        }
        orderService.deleteOrderByUserId(userId);
        userRepository.deleteUserById(userId);
    }

    @Override
    public CustomUser getUserById(Long userId) {
        if(userRepository.getUserById(userId) == null){
            throw new IllegalArgumentException("CustomUser id does not exist.");
        }
        return userRepository.getUserById(userId);
    }

    @Override
    public CustomUser getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }
}
