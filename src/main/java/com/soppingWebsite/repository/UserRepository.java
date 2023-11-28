package com.soppingWebsite.repository;

import com.soppingWebsite.model.User;

public interface UserRepository {
    void createUser(User user);
    void updateUser(User user);
    void deleteUserById(Long userId);
    User getUserById(Long userId);
    User getUserByEmail(String email);
    User getUserByUsername(String username);
}
