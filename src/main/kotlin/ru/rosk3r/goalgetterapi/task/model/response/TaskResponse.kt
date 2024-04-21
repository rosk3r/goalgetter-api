package ru.rosk3r.goalgetterapi.task.model.response

import java.time.LocalDateTime

data class TaskResponse(
    val id: Long,
    val title: String,
    val isCompleted: Boolean,
    val createdAt: LocalDateTime,
)