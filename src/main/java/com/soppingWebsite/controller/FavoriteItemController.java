package com.soppingWebsite.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.soppingWebsite.model.FavoriteItem;
import com.soppingWebsite.service.FavoriteItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/favoriteItem")
public class FavoriteItemController {
    @Autowired
    private FavoriteItemService favoriteItemService;

    @PostMapping("/create")
    public ResponseEntity<?> createFavoriteItem(@RequestBody FavoriteItem favoriteItem) throws JsonProcessingException {
        try {
            favoriteItemService.createFavoriteItem(favoriteItem);
            return ResponseEntity.ok("Favorite item created successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{favoriteItemId}")
    public ResponseEntity<?> deleteFavoriteItemById(@PathVariable Long favoriteItemId){
        try {
            favoriteItemService.deleteFavoriteItemById(favoriteItemId);
            return ResponseEntity.ok("Favorite item deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/byUserId/{userId}")
    public ResponseEntity<?> deleteFavoriteItemByUserId(@PathVariable Long userId){
        try {
            favoriteItemService.deleteFavoriteItemByUserId(userId);
            return ResponseEntity.ok("Favorite items of user " + userId + " have been deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/all/byUserId/{userId}")
    public ResponseEntity<?> getAllFavoriteItemsByUserId(@PathVariable Long userId){
        try {
            return ResponseEntity.ok(favoriteItemService.getAllFavoriteItemsByUserId(userId));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }


}
