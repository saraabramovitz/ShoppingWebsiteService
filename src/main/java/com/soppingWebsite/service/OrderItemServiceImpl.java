package com.soppingWebsite.service;

import com.soppingWebsite.model.*;
import com.soppingWebsite.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;
    @Autowired
    ItemService itemService;
    @Autowired
    OrderItemService orderItemService;

    @Override
    public void createOrderItem(OrderItemRequest orderItemRequest) {
        CustomUser customUser = userService.getUserById(orderItemRequest.getUserId());
        Item item = itemService.getItemById(orderItemRequest.getItemId());

        if(customUser == null){
            throw new IllegalArgumentException("CustomUser does not exist.");
        }
        if(item == null){
            throw new IllegalArgumentException("Item does not exist.");
        }
        if(item.getStock() == 0){
            throw new IllegalArgumentException("Item is not available in stock.");
        }

        if(orderService.getOrdersByUserId(customUser.getUserId()) == null) {
            Long lastCreatedOrderId = orderService.createOrder(customUser.getUserId(), customUser.getAddress());
            orderItemRepository.createOrderItem(orderItemRequest, lastCreatedOrderId);
        } else if(orderService.getTempOrderByUserId(customUser.getUserId()) == null) {
            Long lastCreatedOrderId = orderService.createOrder(customUser.getUserId(), customUser.getAddress());
            orderItemRepository.createOrderItem(orderItemRequest, lastCreatedOrderId);
        } else {
            Long orderId = orderService.getTempOrderByUserId(customUser.getUserId()).getOrderId();
            if(orderItemRepository.getOrderItemByOrderIdAndItemId(orderId, item.getItemId()) == null){
                orderItemRepository.createOrderItem(orderItemRequest, orderId);
            } else {
                throw new IllegalArgumentException("Order item already exist in the order.");
            }
        }
    }



    @Override
    public void updateOrderItemQuantity (Long orderItemId, Integer quantity) {
        if(getOrderItemById(orderItemId) == null){
            throw new IllegalArgumentException("Order item does not exist.");
        }
        Long ItemId = orderItemRepository.getOrderItemById(orderItemId).getItemId();
        Long itemStock = itemService.getItemById(ItemId).getStock();
        if(itemStock < quantity){
            throw new IllegalArgumentException("Item quantity amount is not available in stock.");
        }
        orderItemRepository.updateOrderItemQuantity (orderItemId, quantity);

    }

    @Override
    public void deleteOrderItemById(Long orderItemId) {
        if(orderItemRepository.getOrderItemById(orderItemId) == null){
            throw new IllegalArgumentException("Order item does not exist.");
        }
        Long orderId = orderItemRepository.getOrderItemById(orderItemId).getOrderId();
        orderItemRepository.deleteOrderItemById(orderItemId);
        if(orderItemRepository.getOrderItemsByOrderId(orderId).size() == 0){
            orderService.deleteOrderById(orderId);
        }

    }

    @Override
    public void deleteOrderItemByOrderId(Long orderId) {
        if(orderService.getOrderById(orderId) == null){
            throw new IllegalArgumentException("Order id does not exist.");
        }
        orderItemRepository.deleteOrderItemByOrderId(orderId);
    }

    @Override
    public void deleteOrderItemByUserId(Long userId) {
        if(userService.getUserById(userId) == null){
            throw new IllegalArgumentException("CustomUser does not exist.");
        }
        orderItemRepository.deleteOrderItemByUserId(userId);
    }

    @Override
    public OrderItem getOrderItemById(Long orderItemId) {
        return orderItemRepository.getOrderItemById(orderItemId);
    }

    @Override
    public List<OrderItemResponse> getOrderItemsByOrderId(Long orderId) {
        return orderItemRepository.getOrderItemsByOrderId(orderId);
    }

    @Override
    public List<OrderItem> getOrderItemsByUserId(Long userId) {
        return orderItemRepository.getOrderItemsByUserId(userId);
    }

    @Override
    public List<OrderItemResponse> getOrderItemsByTempOrder(Long userId) {
        return orderItemRepository.getOrderItemsByTempOrder(userId);
    }

}
