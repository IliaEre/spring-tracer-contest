package com.ere.psc.orderapi.service.external;

import com.ere.psc.orderapi.config.ClassLogger;
import com.ere.psc.orderapi.model.Order;
import com.ere.psc.orderapi.model.enums.EventType;
import com.ere.psc.orderapi.service.OrderSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderSenderImpl extends ClassLogger implements OrderSender {

    @Value(value = "${spring.kafka.template.default-topic}")
    private String destination;

    private final KafkaTemplate<String, Order> kafkaTemplate;

    public OrderSenderImpl(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(EventType event, Order order) {
        logger.info("Send message to kafka topic:" + destination);
        var key = order.userInfo().userUuid();
        kafkaTemplate.send(destination, key, order);
        logger.info("Message was send.");
    }

}
