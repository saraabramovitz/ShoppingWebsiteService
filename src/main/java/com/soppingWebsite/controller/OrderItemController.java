package com.soppingWebsite.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.soppingWebsite.model.OrderItemQuantity;
import com.soppingWebsite.model.OrderItemRequest;
import com.soppingWebsite.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderItem")
@CrossOrigin
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/create")
    public ResponseEntity<?> createOrderItem(@RequestBody OrderItemRequest orderItemRequest) throws JsonProcessingException {
        try {
            return ResponseEntity.ok(orderItemService.createOrderItem(orderItemRequest));
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @PutMapping("/updateQuantity")
    public ResponseEntity<?> updateOrderItemQuantity(@RequestBody OrderItemQuantity orderItemQuantity ) {
        try {
            orderItemService.updateOrderItemQuantity (orderItemQuantity);
            return ResponseEntity.ok("Order item updated successfully");
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }


    @DeleteMapping("/delete/{orderItemId}")
    public ResponseEntity<?> deleteOrderItemById(@PathVariable Long orderItemId){
        try {
            orderItemService.deleteOrderItemById(orderItemId);
            return ResponseEntity.ok("Order item deleted successfully");
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @GetMapping("/{orderItemId}")
    public ResponseEntity<?> getOrderItemById(@PathVariable Long orderItemId){
        try {
            return ResponseEntity.ok(orderItemService.getOrderItemById(orderItemId));
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @GetMapping("/getByOrderId/{orderId}")
    public ResponseEntity<?> getOrderItemsByOrderId(@PathVariable Long orderId){
        try {
            return ResponseEntity.ok(orderItemService.getOrderItemsByOrderId(orderId));
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }


    @GetMapping("/getByTempOrder/{userId}")
    public ResponseEntity<?> getOrderItemsByTempOrder(@PathVariable Long userId){
        try {
            return ResponseEntity.ok(orderItemService.getOrderItemsByTempOrder(userId));
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }






}
