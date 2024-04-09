package ru.rosk3r.goalgetterapi.auth.controller

import ru.rosk3r.goalgetterapi.auth.service.SingOutService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sign-out")
class SignOutController(private val singOutService: SingOutService) {

    @DeleteMapping
    fun signOut(@RequestHeader("token") headerValue: String): ResponseEntity<Boolean> {
        return singOutService.signOut(headerValue).let { ResponseEntity.ok(it) }
    }

}