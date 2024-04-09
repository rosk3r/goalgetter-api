package ru.rosk3r.goalgetterapi.auth.model.request

data class UserCreateRequest(
    val username: String,
    val password: String,
    val email: String,
)