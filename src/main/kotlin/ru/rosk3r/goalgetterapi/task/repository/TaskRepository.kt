package ru.rosk3r.goalgetterapi.task.repository

import ru.rosk3r.goalgetterapi.task.model.response.TaskResponse
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.rosk3r.goalgetterapi.task.model.entity.Task

@Repository
interface TaskRepository : JpaRepository<Task, Long> {

    fun getTaskByIdAndUserId(id: Long, userId: Long): Task

    fun getTaskByUserId(id: Long): Task

    fun getAllByUserId(id: Long): List<TaskResponse>

}