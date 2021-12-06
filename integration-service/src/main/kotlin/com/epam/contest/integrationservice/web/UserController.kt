package com.epam.contest.integrationservice.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/user")
class UserController {

    @GetMapping
    fun getAll() {}

    @PostMapping
    fun create() {}

    @GetMapping("/{id}")
    fun findOne() {}
}
