package ru.rosk3r.goalgetterapi.auth.model.request

data class SignInRequest(
    val email: String,
    val password: String,
)
