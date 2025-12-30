package com.example.userservice.controller

import com.example.userservice.dto.CreateUserRequest
import com.example.userservice.dto.UserResponse
import com.example.userservice.service.UserService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {

    @PostMapping
    fun create(@Valid @RequestBody request: CreateUserRequest): UserResponse =
        userService.createUser(request)

    @GetMapping("/{id}")
    fun get(@PathVariable id: UUID): UserResponse =
        userService.getUser(id)
}
