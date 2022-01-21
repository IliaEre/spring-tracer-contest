package com.ere.psc.orderapi.service;

import com.ere.psc.orderapi.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    String create(Order order);
    List<Order> findAll();
    Optional<Order> findOne(String orderId);
}
