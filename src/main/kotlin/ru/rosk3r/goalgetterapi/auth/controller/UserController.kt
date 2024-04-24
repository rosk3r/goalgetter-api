package ru.rosk3r.goalgetterapi.auth.controller

import ru.rosk3r.goalgetterapi.auth.model.entity.User
import ru.rosk3r.goalgetterapi.auth.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.rosk3r.goalgetterapi.auth.model.response.UserStatsResponse
import ru.rosk3r.goalgetterapi.task.service.TaskService

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService,
    private val taskService: TaskService,
) {
    @GetMapping
    fun getAll(): ResponseEntity<List<User>> {
        return userService.getAll().let {ResponseEntity.ok(it)}
    }

    @GetMapping("/stats")
    fun getAllStats(): ResponseEntity<List<UserStatsResponse>> {
        return userService.getUsersStats().let { ResponseEntity.ok(it) }
    }

}