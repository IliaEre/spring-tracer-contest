package com.epam.contest.integrationservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class IntegrationServiceApplication

fun main(args: Array<String>) {
    runApplication<IntegrationServiceApplication>(*args)
}
