package com.example.userservice.service

import com.example.userservice.domain.User
import com.example.userservice.mapper.toResponse
import com.example.userservice.dto.CreateUserRequest
import com.example.userservice.dto.UserResponse
import com.example.userservice.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun createUser(request: CreateUserRequest): UserResponse {
        if (userRepository.existsByEmail(request.email)) {
            throw IllegalArgumentException("User already exists")
        }

        val user = User(
            email = request.email,
            fullName = request.fullName
        )

        val saved = userRepository.save(user)

        return saved.toResponse()
    }

    fun getUser(id: UUID): UserResponse {
        val user = userRepository.findById(id)
            .orElseThrow { NoSuchElementException("User not found") }

        return user.toResponse()
    }
}
