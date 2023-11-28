package com.soppingWebsite.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.soppingWebsite.model.FavoriteProduct;
import com.soppingWebsite.service.FavoriteProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/favoriteProduct")
public class FavoriteProductController {
    @Autowired
    private FavoriteProductService favoriteProductService;

    @PostMapping("/create")
    public ResponseEntity<?> createFavoriteProduct(@RequestBody FavoriteProduct favoriteProduct) throws JsonProcessingException {
        try {
            favoriteProductService.createFavoriteProduct(favoriteProduct);
            return ResponseEntity.ok("Favorite product created successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{favoriteProductId}")
    public ResponseEntity<?> deleteFavoriteProductById(@PathVariable Long favoriteProductId){
        try {
            favoriteProductService.deleteFavoriteProductById(favoriteProductId);
            return ResponseEntity.ok("Favorite product deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteFavoriteProductByUserId(@PathVariable Long userId){
        try {
            favoriteProductService.deleteFavoriteProductByUserId(userId);
            return ResponseEntity.ok("Favorite product of user " + userId + "have been deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<?> getAllFavoriteProductsByUserId(@PathVariable Long userId){
        try {
            return ResponseEntity.ok(favoriteProductService.getAllFavoriteProductsByUserId(userId));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }


}
