package com.example.javaprodz20.service;


import com.example.javaprodz20.model.Order;

import java.util.Optional;

public interface OrderService {
    public Iterable<Order> getAllOrders();
    public Optional<Order> getOrderById(Integer id);
    public void saveOrder(Order order);
    public void updateOrder(Integer id, Order newOrder);
    public void deleteOrder(Integer id);
}
