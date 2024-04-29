package ru.rosk3r.goalgetterapi.auth.model.request

data class UsernameChangeRequest(
    val username: String,
)

data class PasswordChangeRequest(
    val password: String,
)
