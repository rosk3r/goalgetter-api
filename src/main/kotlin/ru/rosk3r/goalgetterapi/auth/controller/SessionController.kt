package ru.rosk3r.goalgetterapi.auth.controller

import ru.rosk3r.goalgetterapi.auth.model.entity.Session
import ru.rosk3r.goalgetterapi.auth.service.SessionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sessions")
class SessionController(
    private val sessionService: SessionService,
) {

    @GetMapping
    fun getAll(): ResponseEntity<List<Session>> {
        val sessions = sessionService.getAll()
        return ResponseEntity.ok(sessions)
    }

}