package com.ere.psc.orderapi.api;

import com.ere.psc.orderapi.model.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Order web api
 * */
public interface OrderHandler<T, U> {
    ResponseEntity<U> createOrder(T order);
    List<Order>findAllOrders();
    ResponseEntity<T> findOrder(String orderId);
}
