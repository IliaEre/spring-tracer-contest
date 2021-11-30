package com.epam.contest.stockservice.dto

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal

data class Stock(
    val name: String,
    val price: BigDecimal?,
    val total: Int?
)

@Table("Stocks")
data class StockEntity(
    @field:Id var id: Long?,
    val name: String,
    val price: BigDecimal?,
    val total: Int?
)

fun Stock.toEntity() = StockEntity(null, name, price, total)
fun StockEntity.toDto() = Stock(name, price, total)
