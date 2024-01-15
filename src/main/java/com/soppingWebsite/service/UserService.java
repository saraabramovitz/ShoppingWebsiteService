package com.soppingWebsite.service;

import com.soppingWebsite.model.CustomUser;
import com.soppingWebsite.model.CustomUserRequest;

public interface UserService {

    void createUser(CustomUserRequest customUserRequest) throws Exception;
    void deleteUserById(Long userId);
    CustomUser getUserById(Long userId);
    CustomUser findUserByUsername(String username);
}
