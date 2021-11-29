package com.epam.contest.stockgrpcservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StockGrpcServiceApplication

fun main(args: Array<String>) {
    runApplication<StockGrpcServiceApplication>(*args)
}
