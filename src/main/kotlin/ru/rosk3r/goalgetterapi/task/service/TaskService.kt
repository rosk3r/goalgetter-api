package ru.rosk3r.goalgetterapi.task.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.rosk3r.goalgetterapi.auth.repository.SessionRepository
import ru.rosk3r.goalgetterapi.task.model.entity.Task
import ru.rosk3r.goalgetterapi.task.model.request.TaskCreateRequest
import ru.rosk3r.goalgetterapi.task.model.request.TaskEditRequest
import ru.rosk3r.goalgetterapi.task.model.response.TaskResponse
import ru.rosk3r.goalgetterapi.task.repository.TaskRepository

@Service
class TaskService(
    private val taskRepository: TaskRepository,
    private val sessionRepository: SessionRepository,
) {

    fun getAll(headerValue: String): List<TaskResponse> {
        val session = sessionRepository.getByToken(headerValue)

        return taskRepository.getAllByUserId(session.userId)
    }

    @Transactional
    fun create(request: TaskCreateRequest, token: String): Task {
        val session = sessionRepository.getByToken(token)
        val task = Task(title = request.title, userId = session.userId)
        return task.let(taskRepository::save)
    }

    @Transactional
    fun updateStatus(id: Long, token: String): Task {
        val session = sessionRepository.getByToken(token)
        val task = taskRepository.findById(id).orElseThrow()

        if (session.userId != task.userId) {
            throw RuntimeException("User don't match")
        }

        val copy = task.copy(isCompleted = task.isCompleted.not())
        return copy.let(taskRepository::save)
    }

    @Transactional
    fun edit(id: Long, request: TaskEditRequest, token: String): Task {
        val session = sessionRepository.getByToken(token)
        val task = taskRepository.findById(id).orElseThrow()

        if (session.userId != task.userId) {
            throw RuntimeException("User don't match")
        }

        val copy = task.copy(title = request.title)

        return copy.let(taskRepository::save)
    }

    @Transactional
    fun delete(id: Long, token: String) {
        val session = sessionRepository.getByToken(token)
        val task = taskRepository.findById(id).orElseThrow()

        if (session.userId != task.userId) {
            throw RuntimeException("User don't match")
        }

        taskRepository.deleteById(id)
    }

}