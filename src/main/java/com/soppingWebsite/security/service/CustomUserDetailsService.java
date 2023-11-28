package com.soppingWebsite.security.service;

import com.soppingWebsite.model.CustomUser;
import com.soppingWebsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUser customUser = userService.getUserByUsername(username);

        if(customUser == null){
            throw new UsernameNotFoundException("The provided username can't be found");
        }
        return User.withDefaultPasswordEncoder().username(customUser.getUsername()).password(customUser.getPassword()).roles().build();
    }
}


