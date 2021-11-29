package com.epam.contest.stockservice.dto

import java.math.BigDecimal

data class Stock(
    val name: String,
    val price: BigDecimal,
    val total: Short
)

data class StockEntity(
    val id: Long? = null,
    val name: String,
    val price: BigDecimal,
    val total: Short
)

fun Stock.toEntity() = StockEntity(null, name, price, total)
fun StockEntity.toDto() = Stock(name, price, total)
