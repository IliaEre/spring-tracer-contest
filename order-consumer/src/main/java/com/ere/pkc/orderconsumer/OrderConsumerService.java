package com.ere.pkc.orderconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumerService {

    private final Logger logger = LoggerFactory.getLogger(OrderConsumerService.class);

    @KafkaListener(topics = "${spring.kafka.default-topic}")
    public void listen(@Payload String message, @Header(KafkaHeaders.GROUP_ID) String groupId) {
        logger.info("receive message:" + message + " and group:" + groupId);
    }

}
