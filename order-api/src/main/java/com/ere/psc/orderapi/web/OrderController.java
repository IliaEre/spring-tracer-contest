package com.ere.psc.orderapi.web;

import com.ere.psc.orderapi.api.OrderHandler;
import com.ere.psc.orderapi.model.Order;
import com.ere.psc.orderapi.model.response.OrderCreated;
import com.ere.psc.orderapi.service.OrderService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/orders")
public class OrderController implements OrderHandler<Order, OrderCreated> {

    private final OrderService orderService;

    public OrderController(@Qualifier("orderServiceFacade") OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    @PostMapping
    public ResponseEntity<OrderCreated> createOrder(@RequestBody Order order) {
        var orderId = orderService.create(order);
        return ResponseEntity
                .accepted()
                .body(new OrderCreated(orderId));
    }

    @Override
    @GetMapping
    public List<Order> findAllOrders() {
        return orderService.findAll();
    }

    @Override
    @GetMapping("/{orderId}")
    public ResponseEntity<Order> findOrder(@PathVariable String orderId) {
        return orderService.findOne(orderId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
