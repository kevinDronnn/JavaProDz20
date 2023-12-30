package com.example.javaprodz20.service;

import com.example.javaprodz20.model.Order;
import com.example.javaprodz20.repository.data.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {

    public static final int ORDER_ID = 111;
    @InjectMocks
    private OrderServiceImpl testInstance;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private Order order;


    @Test
    void shouldReturnOrderById(){
        when(orderRepository.findById(anyInt())).thenReturn(Optional.of(order));

        Optional<Order> result = testInstance.getOrderById(ORDER_ID);

        verify(orderRepository).findById(ORDER_ID);
        assertEquals(ORDER_ID,result.get().getId());
    }

    @Test
    void shouldReturnAllOrders(){
        List<Order> orderList = new ArrayList<>();
        when(orderRepository.findAll()).thenReturn(orderList);

        List<Order> result = testInstance.getAllOrders();

        verify(orderRepository).findAll();
        assertEquals(orderList,result);
    }

    @Test
    void shouldSaveOrder(){
        when(orderRepository.save(order)).thenReturn(order);

        testInstance.saveOrder(order);

        verify(orderRepository).save(order);
    }

    @Test
    void shouldDeleteOrder(){
        doNothing().when(orderRepository).deleteById(ORDER_ID);

        testInstance.deleteOrder(ORDER_ID);

        verify(orderRepository).deleteById(ORDER_ID);
    }

    @Test
    void shouldUpdateOrder(){
        when(orderRepository.findById(111)).thenReturn(Optional.of(order));

        testInstance.updateOrder(111, order);

        verify(orderRepository).save(order);
    }
}