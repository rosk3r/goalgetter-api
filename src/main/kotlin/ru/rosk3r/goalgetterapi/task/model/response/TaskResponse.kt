package ru.rosk3r.goalgetterapi.task.model.response

data class TaskResponse(
    val id: Long,
    val title: String,
    val isCompleted: Boolean,
    val createdAt: String,
)