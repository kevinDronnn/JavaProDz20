package com.example.javaprodz20.controllers;

import com.example.javaprodz20.model.Order;
import com.example.javaprodz20.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "/api/order")
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;

    @GetMapping(name = "/{id}")
    public Optional<Order> getOrderById(@PathVariable(name = "id") Integer id){
        return orderService.getOrderById(id);
    }
    @GetMapping()
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
    @PostMapping()
    public void saveOrder(@RequestBody Order order){
        orderService.saveOrder(order);
    }
    @DeleteMapping (name = "/{id}")
    public void deleteOrder(@PathVariable(name = "id") Integer id){
        orderService.deleteOrder(id);
    }

    @PutMapping(name = "/{id}")
    public void updateOrder(@PathVariable(name = "id") Integer id, @RequestBody Order order){
        orderService.updateOrder(id,order);
    }

}
