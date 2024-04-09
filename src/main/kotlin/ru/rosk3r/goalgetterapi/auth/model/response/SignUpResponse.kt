package ru.rosk3r.goalgetterapi.auth.model.response

data class SignUpResponse(
    val id: Long,
    val username: String,
    val email: String,
    val isAdmin: Boolean,
)
