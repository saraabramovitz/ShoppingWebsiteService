package com.soppingWebsite.repository;

import com.soppingWebsite.model.CustomUser;

public interface UserRepository {
    void createUser(CustomUser customUser);
    void deleteUserById(Long userId);
    CustomUser getUserById(Long userId);
    CustomUser getUserByEmail(String email);
    CustomUser getUserByUsername(String username);
}
