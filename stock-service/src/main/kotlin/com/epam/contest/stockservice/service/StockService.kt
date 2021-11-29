package com.epam.contest.stockservice.service

import com.epam.contest.stockservice.dto.Stock
import com.epam.contest.stockservice.dto.toDto
import com.epam.contest.stockservice.dto.toEntity
import com.epam.contest.stockservice.repository.StockRepository
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
    private val stockRepository: StockRepository
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
            .map {
                // TODO: add kafka
                true // TODO
            }

}
