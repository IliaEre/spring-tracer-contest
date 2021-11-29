package com.epam.contest.stockservice.repository

import com.epam.contest.stockservice.dto.StockEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface StockRepository: ReactiveCrudRepository<StockEntity, Long> {
    fun findByName(name: String): Mono<StockEntity>
}
