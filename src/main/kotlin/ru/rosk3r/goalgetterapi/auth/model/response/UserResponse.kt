package ru.rosk3r.goalgetterapi.auth.model.response

import java.time.LocalDateTime

data class UserResponse(
    val id: Long,
    val username: String,
    val email: String,
    val isAdmin: Boolean,
    val createdAt: LocalDateTime,
)