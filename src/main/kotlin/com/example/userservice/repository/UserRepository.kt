package com.example.userservice.repository

import com.example.userservice.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository: JpaRepository<User, UUID> {
    fun existsByEmail(email: String): Boolean
}