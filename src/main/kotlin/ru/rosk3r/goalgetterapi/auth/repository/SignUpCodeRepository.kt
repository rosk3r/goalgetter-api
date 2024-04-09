package ru.rosk3r.goalgetterapi.auth.repository

import ru.rosk3r.goalgetterapi.auth.model.entity.SignUpCode
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SignUpCodeRepository : JpaRepository<SignUpCode, Long> {

    fun existsByCodeAndEmail(code: String, email: String): Boolean

}