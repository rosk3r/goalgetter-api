package ru.rosk3r.goalgetterapi.auth.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SingOutService(
    private val sessionService: SessionService,
) {

    @Transactional
    fun signOut(token: String): Boolean {
        return sessionService.deleteByToken(token)
    }

}