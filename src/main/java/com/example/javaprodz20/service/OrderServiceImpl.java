package com.example.javaprodz20.service;

import com.example.javaprodz20.model.Order;
import com.example.javaprodz20.repository.data.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void updateOrder(Integer id, Order newOrder) {
        Order order = orderRepository.findById(id).orElseThrow();
        order.setDate(newOrder.getDate());
        order.setCost(newOrder.getCost());
        order.setProducts(newOrder.getProducts());
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}
