package ru.rosk3r.goalgetterapi.task.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.rosk3r.goalgetterapi.task.model.entity.Task
import ru.rosk3r.goalgetterapi.task.model.request.TaskCreateRequest
import ru.rosk3r.goalgetterapi.task.model.request.TaskEditRequest
import ru.rosk3r.goalgetterapi.task.model.response.TaskResponse
import ru.rosk3r.goalgetterapi.task.service.TaskService

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

    @PutMapping("/status-change/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestHeader("token") headerValue: String
    ): ResponseEntity<Task> {
        return taskService.updateStatus(id, headerValue).let { ResponseEntity.ok(it) }
    }

    @PutMapping("/edit/{id}")
    fun update(
        @RequestBody request: TaskEditRequest,
        @PathVariable id: Long,
        @RequestHeader("token") headerValue: String
    ): ResponseEntity<Task> {
        return taskService.edit(id, request, headerValue).let { ResponseEntity.ok(it) }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long, @RequestHeader("token") headerValue: String): ResponseEntity<Boolean> {
        taskService.delete(id, headerValue)
        return ResponseEntity.ok(true)
    }

}