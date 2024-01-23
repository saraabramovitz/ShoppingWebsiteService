package com.soppingWebsite.controller;

import com.soppingWebsite.model.ShippingAddress;
import com.soppingWebsite.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    @Autowired
    OrderService orderService;

    @CrossOrigin
    @PutMapping("/updateShippingAddress")
    public ResponseEntity<?> updateShippingAddress(@RequestBody ShippingAddress shippingAddress) {
        try {
            orderService.updateShippingAddress(shippingAddress);
            return ResponseEntity.ok("Order closed successfully");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @CrossOrigin
    @PutMapping("/closeOrder/{orderId}")
    public ResponseEntity<?> closeOrder(@PathVariable Long orderId) {
        try {
            orderService.closeOrder(orderId);
            return ResponseEntity.ok("Order closed successfully");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<?> deleteOrderById(@PathVariable Long orderId){
        try {
            orderService.deleteOrderById(orderId);
            return ResponseEntity.ok("Order deleted successfully");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }


    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable Long orderId){
        try {
            return ResponseEntity.ok(orderService.getOrderById(orderId));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }


    @GetMapping("/getByUser/{userId}")
    public ResponseEntity<?> getOrdersByUserId(@PathVariable Long userId){
        try {
            return ResponseEntity.ok(orderService.getOrdersByUserId(userId));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @GetMapping("/getTempOrderByUser/{userId}")
    public ResponseEntity<?> getTempOrderByUserId(@PathVariable Long userId){
        try {
            return ResponseEntity.ok(orderService.getTempOrderByUserId(userId));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }







}
