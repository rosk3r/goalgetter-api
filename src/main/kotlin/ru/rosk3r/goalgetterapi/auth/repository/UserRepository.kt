package ru.rosk3r.goalgetterapi.auth.repository

import ru.rosk3r.goalgetterapi.auth.model.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserRepository : JpaRepository<User, Long> {

    fun findUserByEmail(email: String): Optional<User>

    fun existsUserByEmail(email: String): Boolean

    fun existsUserByUsername(username: String): Boolean

}