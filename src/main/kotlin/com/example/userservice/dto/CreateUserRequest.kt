package com.example.userservice.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class CreateUserRequest(
    @field:Email
    val email: String,

    @field:NotBlank
    val fullName: String
)