package com.example.userservice.mapper

import com.example.userservice.domain.User
import com.example.userservice.dto.UserResponse

fun User.toResponse(): UserResponse =
    UserResponse(
        id = id,
        email = email,
        fullName = fullName,
        createdAt = createdAt
    )
