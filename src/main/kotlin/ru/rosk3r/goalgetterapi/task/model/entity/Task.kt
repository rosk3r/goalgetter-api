package ru.rosk3r.goalgetterapi.task.model.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "t_tasks")
data class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val userId: Long = 0,
    val title: String,
    val isCompleted: Boolean = false,
    val createdAt: String = LocalDateTime.now().toString(),
)
