package com.soppingWebsite.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.soppingWebsite.model.FavoriteItem;
import com.soppingWebsite.model.Item;
import com.soppingWebsite.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemController {

    @Autowired
    ItemService itemService;


    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody Item item) throws Exception {
        try {
            itemService.createItem(item);
            return ResponseEntity.ok("Item created successfully");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateItem(@RequestBody Item item) {
        try {
            itemService.updateItem(item);
            return ResponseEntity.ok("Item updated successfully");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{itemId}")
    public ResponseEntity<?> deleteItemById(@PathVariable Long itemId){
        try {
            itemService.deleteItemById(itemId);
            return ResponseEntity.ok("Item deleted successfully");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<?> getItemById(@PathVariable Long itemId){
        try {
            return ResponseEntity.ok(itemService.getItemById(itemId));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllItems(){
        try {
            return ResponseEntity.ok(itemService.getAllItems());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @GetMapping("/containingSearchText/{searchText}")
    public ResponseEntity<?> getItemsContainingSearchText(@PathVariable String searchText){
        try {
            return ResponseEntity.ok(itemService.getItemsContainingSearchText(searchText));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }


}
