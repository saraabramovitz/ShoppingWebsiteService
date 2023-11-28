package com.soppingWebsite.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.soppingWebsite.model.Item;
import com.soppingWebsite.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody Item item) throws JsonProcessingException {
        try {
            itemService.createItem(item);
            return ResponseEntity.ok("Item created successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateItem(@RequestBody Item item) {
        try {
            itemService.updateItem(item);
            return ResponseEntity.ok("Item updated successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{itemId}")
    public ResponseEntity<?> deleteItemById(@PathVariable Long itemId){
        try {
            itemService.deleteItemById(itemId);
            return ResponseEntity.ok("Item deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<?> getItemById(@PathVariable Long itemId){
        try {
            return ResponseEntity.ok(itemService.getItemById(itemId));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllItems(){
        try {
            return ResponseEntity.ok(itemService.getAllItems());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/containingSearchText/{searchText}")
    public ResponseEntity<?> getItemsContainingSearchText(String searchText){
        try {
            return ResponseEntity.ok(itemService.getItemsContainingSearchText(searchText));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }


}
