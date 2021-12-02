package com.epam.contest.stockservice.config

import com.epam.contest.stockservice.dto.Stock
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import reactor.kafka.sender.SenderOptions

@Configuration
class ReactorKafkaConfig {

    @Bean
    fun reactiveKafkaProducerTemplate(properties: KafkaProperties): ReactiveKafkaProducerTemplate<String, Stock> =
        ReactiveKafkaProducerTemplate<String, Stock>(SenderOptions.create(properties.buildProducerProperties()))
}
