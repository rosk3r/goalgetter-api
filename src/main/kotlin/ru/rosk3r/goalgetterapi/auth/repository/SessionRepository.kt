package ru.rosk3r.goalgetterapi.auth.repository

import ru.rosk3r.goalgetterapi.auth.model.entity.Session
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SessionRepository : JpaRepository<Session, Long> {

    fun deleteByToken(token: String): Int

    fun getByToken(token: String): Session

    fun findByToken(token: String): Boolean

}