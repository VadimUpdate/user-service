package com.example.userservice.domain

import jakarta.persistence.*
import java.time.Instant
import java.util.*

@Entity
@Table(name = "users")
class User(

    @Id
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    val email: String,

    @Column(nullable = false)
    val fullName: String,

    @Column(nullable = false)
    val createdAt: Instant = Instant.now()
)
