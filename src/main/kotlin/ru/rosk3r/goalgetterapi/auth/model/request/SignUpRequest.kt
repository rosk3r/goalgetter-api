package ru.rosk3r.goalgetterapi.auth.model.request

data class SignUpRequest(
    val username: String,
    val password: String,
    val email: String,
    val code: String,
)
