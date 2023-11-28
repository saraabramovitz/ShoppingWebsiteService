package com.soppingWebsite.repository;

import com.soppingWebsite.model.Item;
import com.soppingWebsite.model.OrderItem;
import com.soppingWebsite.model.OrderItemRequest;
import com.soppingWebsite.model.OrderItemResponse;

import java.util.List;

public interface OrderItemRepository {
    void createOrderItem (OrderItemRequest orderItemRequest, Long orderId);
    void updateOrderItemQuantity (Long orderItemId, Integer quantity);
    void deleteOrderItemById (Long orderItemId);
    void deleteOrderItemByOrderId (Long order);
    void deleteOrderItemByUserId(Long userId);
    OrderItem getOrderItemById (Long orderItemId);
    List<OrderItemResponse> getOrderItemsByOrderId (Long orderId);
    Item getItemIdByOrderItemId (Long orderItemId);
    OrderItem getOrderItemByOrderIdAndItemId(Long orderId, Long itemId);
    List<OrderItem> getOrderItemsByUserId(Long userId);
    List<OrderItemResponse> getOrderItemsByTempOrder(Long userId);

}
