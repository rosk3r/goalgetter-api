package io.shapito.tasks.task.controller

import io.shapito.tasks.task.model.entity.Task
import io.shapito.tasks.task.model.request.TaskCreateRequest
import io.shapito.tasks.task.model.request.TaskUpdateRequest
import io.shapito.tasks.task.model.response.TaskResponse
import io.shapito.tasks.task.service.TaskService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tasks")
class TaskController(private val taskService: TaskService) {

    @GetMapping
    fun getAll(@RequestHeader("token") headerValue: String): ResponseEntity<List<TaskResponse>> {
        return taskService.getAll(headerValue).let { ResponseEntity.ok(it) }
    }

    @PostMapping
    fun create(
        @RequestHeader("token") headerValue: String,
        @RequestBody request: TaskCreateRequest
    ): ResponseEntity<Task> {
        return taskService.create(request, headerValue).let { ResponseEntity.ok(it) }
    }

    @PutMapping("/{id}")
    fun update(
        @RequestBody request: TaskUpdateRequest,
        @PathVariable id: Long,
        @RequestHeader("token") headerValue: String
    ): ResponseEntity<Task> {
        return taskService.update(id, request, headerValue).let { ResponseEntity.ok(it) }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long, @RequestHeader("token") headerValue: String): ResponseEntity<Boolean> {
        taskService.delete(id, headerValue)
        return ResponseEntity.ok(true)
    }

}