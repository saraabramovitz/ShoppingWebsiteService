package com.soppingWebsite.service;

import com.soppingWebsite.model.Item;
import com.soppingWebsite.model.OrderItem;
import com.soppingWebsite.model.OrderItemRequest;
import com.soppingWebsite.model.OrderItemResponse;

import java.util.List;

public interface OrderItemService {
    void createOrderItem(OrderItemRequest orderItemRequest);
    void updateOrderItemQuantity (Long orderItemId, Integer quantity);
    void deleteOrderItemById (Long orderProductId);
    void deleteOrderItemByOrderId (Long orderId);
    void deleteOrderItemByUserId(Long userId);
    OrderItem getOrderItemById (Long orderProductId);
    List<OrderItemResponse> getOrderItemsByOrderId(Long orderId);
    List<OrderItem> getOrderItemsByUserId(Long userId);
    List<OrderItemResponse> getOrderItemsByTempOrder(Long userId);


}
