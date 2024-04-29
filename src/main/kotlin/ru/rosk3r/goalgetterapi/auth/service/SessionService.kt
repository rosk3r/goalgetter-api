package ru.rosk3r.goalgetterapi.auth.service

import ru.rosk3r.goalgetterapi.auth.model.entity.Session
import ru.rosk3r.goalgetterapi.auth.repository.SessionRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SessionService(private val sessionRepository: SessionRepository) {

    fun getAll(): List<Session> {
        return sessionRepository.findAll()
    }

    fun findByToken(token: String): Session {
        return sessionRepository.getByToken(token)
    }

    @Transactional
    fun create(userId: Long): Session {
        return Session(userId = userId).let(sessionRepository::save)
    }

    @Transactional
    fun deleteByToken(token: String): Boolean {
        return sessionRepository.deleteByToken(token) > 0
    }

}