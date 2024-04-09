package io.shapito.tasks.task.repository

import io.shapito.tasks.task.model.entity.Task
import io.shapito.tasks.task.model.response.TaskResponse
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository : JpaRepository<Task, Long> {

    fun getTaskByIdAndUserId(id: Long, userId: Long): Task

    fun getTaskByUserId(id: Long): Task

    fun getAllByUserId(id: Long): List<TaskResponse>

}