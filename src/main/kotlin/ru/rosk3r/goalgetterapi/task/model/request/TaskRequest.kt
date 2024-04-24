package ru.rosk3r.goalgetterapi.task.model.request

data class TaskCreateRequest(
    val title: String
)

data class TaskEditRequest(
    val title: String,
)
