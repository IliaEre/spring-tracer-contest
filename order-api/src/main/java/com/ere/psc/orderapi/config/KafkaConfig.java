package com.ere.psc.orderapi.config;

import com.ere.psc.orderapi.model.Order;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Bean
    public ProducerFactory<String, Order> producerFactory(KafkaProperties kafkaProperties) {
        var producer = kafkaProperties.getProducer();
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                producer.getBootstrapServers());
        configProps.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                producer.getKeySerializer());
        configProps.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                producer.getValueSerializer());
        configProps.put(
                ProducerConfig.ACKS_CONFIG,
                producer.getAcks());
        configProps.put(
                ProducerConfig.CLIENT_ID_CONFIG,
                producer.getClientId());
        configProps.put(
                ProducerConfig.RETRIES_CONFIG,
                producer.getRetries());
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, Order> kafkaTemplate(KafkaProperties kafkaProperties) {
        return new KafkaTemplate<>(producerFactory(kafkaProperties));
    }

}
