package com.soppingWebsite.service;

import com.soppingWebsite.model.CustomUser;

public interface UserService {
    void createUser(CustomUser customUser);
    void deleteUserById(Long userId);
    CustomUser getUserById(Long userId);
    CustomUser getUserByUsername(String username);
}
