package com.soppingWebsite.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.soppingWebsite.model.OrderProduct;
import com.soppingWebsite.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderProduct")
public class OrderProductController {

    @Autowired
    private OrderProductService orderProductService;

    @PostMapping("/create")
    public ResponseEntity<?> createOrderProduct(@RequestBody OrderProduct orderProduct) throws JsonProcessingException {
        try {
            orderProductService.createOrderProduct(orderProduct);
            return ResponseEntity.ok("Order product created successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateOrderProduct(@RequestBody OrderProduct orderProduct) {
        try {
            orderProductService.updateOrderProduct(orderProduct);
            return ResponseEntity.ok("Order product updated successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }


    @DeleteMapping("/delete/{orderProductId}")
    public ResponseEntity<?> deleteOrderProductById(@PathVariable Long orderProductId){
        try {
            orderProductService.deleteOrderProductById(orderProductId);
            return ResponseEntity.ok("Favorite product deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteOrderProductByUserId(@PathVariable Long userId){
        try {
            orderProductService.deleteOrderProductByUserId(userId);
            return ResponseEntity.ok("Favorite product of user " + userId + "have been deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/{orderProductId}")
    public ResponseEntity<?> getOrderProductById(@PathVariable Long orderProductId){
        try {
            return ResponseEntity.ok(orderProductService.getOrderProductById(orderProductId));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getOrderProductsByUserId(@PathVariable Long userId){
        try {
            return ResponseEntity.ok(orderProductService.getOrderProductById(userId));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrderProductsByOrderId(@PathVariable Long orderId){
        try {
            return ResponseEntity.ok(orderProductService.getOrderProductsByOrderId(orderId));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }





}
