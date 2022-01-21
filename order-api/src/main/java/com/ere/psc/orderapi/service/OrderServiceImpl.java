package com.ere.psc.orderapi.service;

import com.ere.psc.orderapi.model.Order;
import com.ere.psc.orderapi.model.enums.EventType;
import com.ere.psc.orderapi.repository.OrderRepository;
import com.ere.psc.orderapi.utils.OrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderSender orderSender;
    private final Logger logger;

    public OrderServiceImpl(OrderRepository orderRepository, OrderSender orderSender) {
        this.orderRepository = orderRepository;
        this.orderSender = orderSender;
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    @Transactional
    public String create(Order order) {
        logger.info("Create new order from user:" + order.userInfo());
        var mappedOrder = OrderMapper.convertTo(order);
        var savedResult = orderRepository.save(mappedOrder);
        orderSender.send(EventType.CREATED, order);
        return savedResult.orderId();
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(OrderMapper::convertTo)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Order> findOne(String orderId) {
        return orderRepository.findById(orderId)
                .map(OrderMapper::convertTo);
    }
}
