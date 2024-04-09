package ru.rosk3r.goalgetterapi.auth.model.entity

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "t_sessions")
data class Session(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val userId: Long,
    val token: String = UUID.randomUUID().toString(),
    val expiredDate: LocalDateTime = LocalDateTime.now().plusDays(7),
)
