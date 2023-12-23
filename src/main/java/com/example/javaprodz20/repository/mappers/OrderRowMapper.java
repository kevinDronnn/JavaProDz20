package com.example.javaprodz20.repository.mappers;


import com.example.javaprodz20.model.Order;
import com.example.javaprodz20.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId(rs.getInt("id"));
        order.setCost(rs.getDouble("cost"));
        order.setDate(rs.getDate("date"));
        order.setProducts((List<Product>) rs.getArray("products"));
        return order;
    }
}
