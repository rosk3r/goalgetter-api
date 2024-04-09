package ru.rosk3r.goalgetterapi.auth.controller

import ru.rosk3r.goalgetterapi.auth.model.entity.Session
import ru.rosk3r.goalgetterapi.auth.model.request.SignInRequest
import ru.rosk3r.goalgetterapi.auth.service.SessionService
import ru.rosk3r.goalgetterapi.auth.service.SignInService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/sign-in")
class SignInController(
    private val signInService: SignInService,
    private val sessionService: SessionService,
) {

    @PostMapping
    fun signIn(@RequestBody request: SignInRequest): ResponseEntity<Session> {
        return signInService.signIn(request).let { ResponseEntity.ok(it) }
    }

    @PostMapping("/verification")
    fun verification(@RequestHeader("token") headerValue: String): ResponseEntity<Session> {
        return sessionService.findByToken(headerValue).let { ResponseEntity.ok(it) }
    }

}