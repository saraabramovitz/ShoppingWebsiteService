package com.soppingWebsite.service;

import com.soppingWebsite.model.*;
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

    @Autowired
    ItemService itemService;


    @Override
    public Long createOrder(Long userId, Address shippingAddress) {
        if(userService.getUserById(userId) == null){
            throw new IllegalArgumentException("CustomUser does not exist.");
        }
        return orderRepository.createOrder(userId, shippingAddress);
    }

    @Override
    public void updateShippingAddress(ShippingAddress shippingAddress) {
        if(orderRepository.getOrderById(shippingAddress.getOrderId()) == null) {
            throw new IllegalArgumentException("Order does not exist.");
        }
        orderRepository.updateShippingAddress(shippingAddress);
    }

    @Override
    public void closeOrder(Long orderId) {
        List<OrderItemResponse> orderItemList = orderItemService.getOrderItemsByOrderId(orderId);
        if(orderRepository.getOrderById(orderId) == null) {
            throw new IllegalArgumentException("Order does not exist.");
        }
        if(orderRepository.getTempOrderByOrderId(orderId) == null){
            throw new IllegalArgumentException("The order is not a temp order.");
        }
        for (OrderItemResponse orderItem : orderItemList) {
            if (orderItem.getQuantity() > itemService.getItemById(orderItem.getItemId()).getStock()) {
                throw new IllegalArgumentException("Order item with id " + orderItem.getOrderItemId() + " is out of stock.");
            } else {
                Item item = itemService.getItemById(orderItem.getItemId());
                Long updateStock = item.getStock() - orderItem.getQuantity();
                itemService.updateStock(item.getItemId(), updateStock);
            }
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
    public OrderResponse getOrderById(Long orderId) {
        if(orderRepository.getOrderById(orderId) == null){
            throw new IllegalArgumentException("Order does not exist.");
        }
        return orderRepository.getOrderById(orderId);
    }

    @Override
    public List<OrderResponse> getOrdersByUserId(Long userId) {
        if (userService.getUserById(userId) == null) {
            throw new IllegalArgumentException("CustomUser does not exist.");
        }
        return orderRepository.getOrdersByUserId(userId);
    }

    @Override
    public OrderResponse getTempOrderByUserId(Long userId) {
        if(userService.getUserById(userId) == null){
            throw new IllegalArgumentException("CustomUser does not exist.");
        }
        return orderRepository.getTempOrderByUserId(userId);
    }
}
