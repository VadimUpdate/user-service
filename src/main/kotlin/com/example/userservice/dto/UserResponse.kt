package com.example.userservice.dto

import java.time.Instant
import java.util.*

data class UserResponse(
    val id: UUID,
    val email: String,
    val fullName: String,
    val createdAt: Instant
)
