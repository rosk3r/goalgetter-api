package ru.rosk3r.goalgetterapi.auth.model.response

data class UserStatsResponse (
    val username: String,
    val completedTasksCount: Long,
    val rank: Long = 0,
)