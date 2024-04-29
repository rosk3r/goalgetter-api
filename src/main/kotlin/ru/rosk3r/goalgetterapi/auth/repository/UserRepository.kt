package ru.rosk3r.goalgetterapi.auth.repository

import ru.rosk3r.goalgetterapi.auth.model.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.Optional

@Repository
interface UserRepository : JpaRepository<User, Long> {

    fun findUserByEmail(email: String): Optional<User>

    fun findUserById(id: Long): User

    fun existsUserByEmail(email: String): Boolean

    fun existsUserByUsername(username: String): Boolean

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.username = :username WHERE u.id = :id")
    fun updateUsernameById(id: Long, username: String): Int

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.password = :password WHERE u.id = :id")
    fun updatePasswordById(id: Long, password: String): Int
}