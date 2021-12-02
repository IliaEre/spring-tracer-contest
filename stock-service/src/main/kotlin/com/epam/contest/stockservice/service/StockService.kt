package com.epam.contest.stockservice.service

import com.epam.contest.stockservice.dto.Stock
import com.epam.contest.stockservice.dto.toDto
import com.epam.contest.stockservice.dto.toEntity
import com.epam.contest.stockservice.repository.StockRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface StockService {
    fun findAll(): Flux<Stock>
    fun findOne(name: String): Mono<Stock>
    fun create(stock: Stock): Mono<Boolean>
}

@Service
internal class StockServiceImpl(
    private val stockRepository: StockRepository,
    private val reactiveKafkaProducerTemplate: ReactiveKafkaProducerTemplate<String, Stock>,
    @Value("\${app.topic}") private val topic: String
): StockService {

    override fun findAll(): Flux<Stock> =
        stockRepository.findAll()
            .map { it.toDto() }

    override fun findOne(name: String): Mono<Stock> =
        stockRepository.findByName(name)
            .map { it.toDto() }

    @Transactional
    override fun create(stock: Stock): Mono<Boolean> =
        stockRepository.save(stock.toEntity())
            .flatMap {
                reactiveKafkaProducerTemplate.send(topic, stock)
                    .doOnSuccess { log.info("sent {} offset : {}", stock, it.recordMetadata().offset()) }
                    .hasElement()
            }

    private companion object {
        val log: Logger = LoggerFactory.getLogger(this::class.java)
    }
}
