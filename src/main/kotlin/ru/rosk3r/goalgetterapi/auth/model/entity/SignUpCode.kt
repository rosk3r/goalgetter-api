package ru.rosk3r.goalgetterapi.auth.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "t_sign_up_codes")
data class SignUpCode(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val code: String,
    val email: String,
)
