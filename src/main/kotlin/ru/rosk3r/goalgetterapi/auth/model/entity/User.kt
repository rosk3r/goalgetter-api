package ru.rosk3r.goalgetterapi.auth.model.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "t_users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val username: String,
    val email: String,
    val password: String,
    val isAdmin: Boolean = false,
    val createdAt: LocalDateTime = LocalDateTime.now(),
)
