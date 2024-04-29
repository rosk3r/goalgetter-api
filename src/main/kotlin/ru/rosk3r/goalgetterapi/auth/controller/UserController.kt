package ru.rosk3r.goalgetterapi.auth.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.rosk3r.goalgetterapi.auth.model.entity.User
import ru.rosk3r.goalgetterapi.auth.model.request.PasswordChangeRequest
import ru.rosk3r.goalgetterapi.auth.model.request.UsernameChangeRequest
import ru.rosk3r.goalgetterapi.auth.model.response.UserStatsResponse
import ru.rosk3r.goalgetterapi.auth.service.UserService

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService,
) {
    @GetMapping
    fun getAll(): ResponseEntity<List<User>> {
        return userService.getAll().let { ResponseEntity.ok(it) }
    }

    @GetMapping("/stats")
    fun getAllStats(): ResponseEntity<List<UserStatsResponse>> {
        return userService.getUsersStats().let { ResponseEntity.ok(it) }
    }

    @PutMapping("/username-change")
    fun passwordChange(
        @RequestHeader("token") headerValue: String,
        @RequestBody request: UsernameChangeRequest
    ): Int {
        return userService.updateUsernameById(request, headerValue)
    }

    @PutMapping("/password-change")
    fun usernameChange(
        @RequestHeader("token") headerValue: String,
        @RequestBody request: PasswordChangeRequest
    ): Int {
        return userService.updatePasswordById(request, headerValue)
    }

}