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
@CrossOrigin
public class FavoriteItemController {
    @Autowired
    private FavoriteItemService favoriteItemService;

    @PostMapping("/create")
    @CrossOrigin
    public ResponseEntity<?> createFavoriteItem(@RequestBody FavoriteItem favoriteItem) throws Exception {
        try {
            return ResponseEntity.ok(favoriteItemService.createFavoriteItem(favoriteItem));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{favoriteItemId}")
    @CrossOrigin
    public ResponseEntity<?> deleteFavoriteItem(@PathVariable Long favoriteItemId){
        try {
            favoriteItemService.deleteFavoriteItem(favoriteItemId);
            return ResponseEntity.ok("Favorite item deleted successfully");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/byUserId/{userId}")
    public ResponseEntity<?> deleteFavoriteItemByUserId(@PathVariable Long userId){
        try {
            favoriteItemService.deleteFavoriteItemByUserId(userId);
            return ResponseEntity.ok("Favorite items of user " + userId + " have been deleted successfully");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @GetMapping("/all/byUserId/{userId}")
    public ResponseEntity<?> getAllFavoriteItemsByUserId(@PathVariable Long userId){
        try {
            return ResponseEntity.ok(favoriteItemService.getAllFavoriteItemsByUserId(userId));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }


}
