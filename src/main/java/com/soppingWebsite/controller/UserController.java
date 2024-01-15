package com.soppingWebsite.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.soppingWebsite.model.CustomUser;
import com.soppingWebsite.model.CustomUserRequest;
import com.soppingWebsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody CustomUserRequest customUserRequest){
        try{
            userService.createUser(customUserRequest);
            return null;
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long userId){
        try {
            userService.deleteUserById(userId);
            return ResponseEntity.ok("CustomUser deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId){
        try {
            return ResponseEntity.ok(userService.getUserById(userId));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/getByUsername/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username){
        try {
            return ResponseEntity.ok(userService.findUserByUsername(username));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }




}
