package com.epam.contest.stockservice.web

import com.epam.contest.stockservice.dto.Stock
import com.epam.contest.stockservice.service.StockService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/stock")
class StockController(
    private val stockService: StockService
) {

    @GetMapping
    fun getAll() = stockService.findAll()

    @GetMapping("/{name}")
    fun findOne(@PathVariable name: String) = stockService.findOne(name)

    @PostMapping
    fun create(@RequestBody stock: Stock) =
        stockService.create(stock)

}
