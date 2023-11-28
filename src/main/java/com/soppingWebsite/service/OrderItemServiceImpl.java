package com.soppingWebsite.service;

import com.soppingWebsite.model.Order;
import com.soppingWebsite.model.OrderItem;
import com.soppingWebsite.model.OrderRequest;
import com.soppingWebsite.model.User;
import com.soppingWebsite.model.modelEnum.OrderStatus;
import com.soppingWebsite.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItamServiceImpl implements OrderItamService {

    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;

    @Override
    public void createOrderProduct(OrderItem orderItem) {

        User user = userService.getUserById(orderItem.getUserId());
        List<Order> userOrders = orderService.getOrdersByUserId(orderItem.getUserId());
        OrderRequest newOrder = new OrderRequest(orderItem.getUserId(), user.getAddress(), orderItem.getProductPrice());

        if(orderItem.getOrderProductId() != null){
            throw new IllegalArgumentException("Invalid id.");
        }
        if(user == null){
            throw new IllegalArgumentException("User does nor exist.");
        }

        for (Order userOrder : userOrders) {
            if (userOrder.getOrderStatus() == OrderStatus.TEMP) {
                orderItemRepository.createOrderProduct(orderItem);
                return;
            }
        }

        orderService.createOrder(newOrder);
        orderItemRepository.createOrderProduct(orderItem);
    }


    @Override
    public void updateOrderProduct(OrderItem orderItem) {
        orderItemRepository.updateOrderProduct(orderItem);
    }

    @Override
    public void deleteOrderProductById(Long orderProductId) {
        orderItemRepository.deleteOrderProductById(orderProductId);
    }

    @Override
    public void deleteOrderProductByUserId(Long userId) {
        orderItemRepository.deleteOrderProductByUserId(userId);
    }

    @Override
    public OrderItem getOrderProductById(Long orderProductId) {
        return orderItemRepository.getOrderProductById(orderProductId);
    }

    @Override
    public List<OrderItem> getOrderProductsByUserId(Long userId) {
        return orderItemRepository.getOrderProductsByUserId(userId);
    }

    @Override
    public List<OrderItem> getOrderProductsByOrderId(Long orderId) {
        return orderItemRepository.getOrderProductsByOrderId(orderId);
    }
}
