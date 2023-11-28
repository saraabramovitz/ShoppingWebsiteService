package com.soppingWebsite.repository;

import com.soppingWebsite.model.Order;

import java.util.List;

public interface OrderRepository {
    void createOrder (Order order);
    void updateOrder (Order order);
    void deleteOrderById (Long orderId);
    void deleteOrderByUserId (Long userId);
    Order getOrderById (Long orderId);
    List<Order> getOrdersByUserId (Long userId);

}
