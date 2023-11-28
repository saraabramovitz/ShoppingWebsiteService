package com.soppingWebsite.service;

import com.soppingWebsite.model.OrderItem;

import java.util.List;

public interface OrderItamService {
    void createOrderProduct (OrderItem orderItem);
    void updateOrderProduct (OrderItem orderItem);
    void deleteOrderProductById (Long orderProductId);
    void deleteOrderProductByUserId (Long userId);
    OrderItem getOrderProductById (Long orderProductId);
    List<OrderItem> getOrderProductsByUserId (Long userId);
    List<OrderItem> getOrderProductsByOrderId (Long orderId);
}
