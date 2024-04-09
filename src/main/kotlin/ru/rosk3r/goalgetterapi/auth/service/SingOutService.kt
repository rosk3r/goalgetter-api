package ru.rosk3r.goalgetterapi.auth.service

import org.springframework.stereotype.Service
import ru.rosk3r.goalgetterapi.auth.service.SessionService

@Service
class SingOutService(
    private val sessionService: SessionService,
) {

    fun signOut(token: String): Boolean {
        return sessionService.deleteByToken(token)
    }

}