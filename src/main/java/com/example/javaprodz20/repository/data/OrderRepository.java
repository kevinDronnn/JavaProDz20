package com.example.javaprodz20.repository.data;

import com.example.javaprodz20.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends CrudRepository<Order,Integer> {

}
