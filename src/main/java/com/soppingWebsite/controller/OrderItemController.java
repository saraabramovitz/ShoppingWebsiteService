package com.soppingWebsite.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.soppingWebsite.model.OrderItemRequest;
import com.soppingWebsite.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/create")
    public ResponseEntity<?> createOrderItem(@RequestBody OrderItemRequest orderItemRequest) throws JsonProcessingException {
        try {
            orderItemService.createOrderItem(orderItemRequest);
            return ResponseEntity.ok("Order item created successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @PutMapping("/updateQuantity")
    public ResponseEntity<?> updateOrderItemQuantity(@RequestParam Long orderItemId, Integer quantity) {
        try {
            orderItemService.updateOrderItemQuantity (orderItemId, quantity);
            return ResponseEntity.ok("Order item updated successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }


    @DeleteMapping("/delete/{orderItemId}")
    public ResponseEntity<?> deleteOrderItemById(@PathVariable Long orderItemId){
        try {
            orderItemService.deleteOrderItemById(orderItemId);
            return ResponseEntity.ok("Order item deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/{orderItemId}")
    public ResponseEntity<?> getOrderItemById(@PathVariable Long orderItemId){
        try {
            return ResponseEntity.ok(orderItemService.getOrderItemById(orderItemId));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/getByOrderId/{orderId}")
    public ResponseEntity<?> getOrderItemsByOrderId(@PathVariable Long orderId){
        try {
            return ResponseEntity.ok(orderItemService.getOrderItemsByOrderId(orderId));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }


    @GetMapping("/getByTempOrder/{userId}")
    public ResponseEntity<?> getOrderItemsByTempOrder(@PathVariable Long userId){
        try {
            return ResponseEntity.ok(orderItemService.getOrderItemsByTempOrder(userId));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }






}
