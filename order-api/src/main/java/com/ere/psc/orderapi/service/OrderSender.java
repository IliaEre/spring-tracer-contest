package com.ere.psc.orderapi.service;

import com.ere.psc.orderapi.model.Order;
import com.ere.psc.orderapi.model.enums.EventType;

public interface OrderSender {
    void send(EventType event, Order order);
}
