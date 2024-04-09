package io.shapito.tasks.task.model.request

data class TaskCreateRequest(
    val title: String
)

data class TaskUpdateRequest(
    val title: String,
    val isCompleted: Boolean,
)
