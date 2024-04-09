package ru.rosk3r.goalgetterapi.auth.controller

import ru.rosk3r.goalgetterapi.auth.model.entity.Session
import ru.rosk3r.goalgetterapi.auth.model.request.SignUpRequest
import ru.rosk3r.goalgetterapi.auth.service.SignUpService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sign-up")
class SignUpController(private val signUpService: SignUpService) {

    @PostMapping
    fun create(@RequestBody request: SignUpRequest): ResponseEntity<Session> {
        return signUpService.signUp(request).let { ResponseEntity.ok(it) }
    }

}