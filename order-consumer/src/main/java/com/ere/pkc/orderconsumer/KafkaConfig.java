package com.ere.pkc.orderconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;

@Configuration
public class KafkaConfig {

    private final Logger logger = LoggerFactory.getLogger(OrderConsumerService.class);

    @Bean
    public KafkaListenerErrorHandler validationErrorHandler() {
        return (m, e) -> {
            logger.info("problem with kafka message:"+m);
            return "problem:" + e.getMessage();
        };
    }
}
