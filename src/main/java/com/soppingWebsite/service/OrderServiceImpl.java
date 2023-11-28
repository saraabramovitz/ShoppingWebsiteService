package com.soppingWebsite.service;

import com.soppingWebsite.model.Order;
import com.soppingWebsite.model.OrderItem;
import com.soppingWebsite.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserService userService;
    @Autowired
    OrderItemService orderItemService;


    @Override
    public Long createOrder(Long userId, String shippingAddress) {
        if(userService.getUserById(userId) == null){
            throw new IllegalArgumentException("CustomUser does not exist.");
        }
        return orderRepository.createOrder(userId, shippingAddress);
    }

    @Override
    public void updateShippingAddress(Long orderId, String shippingAddress) {
        if(orderRepository.getOrderById(orderId) == null) {
            throw new IllegalArgumentException("Order does not exist.");
        }
        orderRepository.updateShippingAddress(orderId, shippingAddress);
    }

    @Override
    public void closeOrder(Long orderId) {
        if(orderRepository.getOrderById(orderId) == null) {
            throw new IllegalArgumentException("Order does not exist.");
        }
        if(orderRepository.getTempOrderByOrderId(orderId) == null){
            throw new IllegalArgumentException("The order is not a temp order.");
        }
        orderRepository.closeOrder(orderId);
    }

    @Override
    public void deleteOrderById(Long orderId) {
        if(orderRepository.getOrderById(orderId) == null) {
            throw new IllegalArgumentException("Order does not exist.");
        }
        orderItemService.deleteOrderItemByOrderId(orderId);
        orderRepository.deleteOrderById(orderId);
    }

    @Override
    public void deleteOrderByUserId(Long userId) {
        if(userService.getUserById(userId) == null){
            throw new IllegalArgumentException("CustomUser does not exist.");
        }
        orderItemService.deleteOrderItemByUserId(userId);
        orderRepository.deleteOrderByUserId(userId);
    }

    @Override
    public Order getOrderById(Long orderId) {
        if(orderRepository.getOrderById(orderId) == null){
            throw new IllegalArgumentException("Order does not exist.");
        }
        return orderRepository.getOrderById(orderId);
    }

    @Override
    public List<Order> getOrdersByUserId(Long userId) {
        if(userService.getUserById(userId) == null){
            throw new IllegalArgumentException("CustomUser does not exist.");
        }
        return orderRepository.getOrdersByUserId(userId);
    }

    @Override
    public Order getTempOrderByUserId(Long userId) {
        if(userService.getUserById(userId) == null){
            throw new IllegalArgumentException("CustomUser does not exist.");
        }
        return orderRepository.getTempOrderByUserId(userId);
    }
}
