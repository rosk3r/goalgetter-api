package ru.rosk3r.goalgetterapi.auth.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.rosk3r.goalgetterapi.auth.model.entity.User
import ru.rosk3r.goalgetterapi.auth.model.request.PasswordChangeRequest
import ru.rosk3r.goalgetterapi.auth.model.request.SignUpRequest
import ru.rosk3r.goalgetterapi.auth.model.request.UsernameChangeRequest
import ru.rosk3r.goalgetterapi.auth.model.response.UserStatsResponse
import ru.rosk3r.goalgetterapi.auth.repository.SessionRepository
import ru.rosk3r.goalgetterapi.auth.repository.UserRepository
import ru.rosk3r.goalgetterapi.auth.util.encoder.BCryptPasswordEncoder
import ru.rosk3r.goalgetterapi.task.repository.TaskRepository

@Service
class UserService(
    private val userRepository: UserRepository,
    private val bCryptPasswordEncoder: BCryptPasswordEncoder,
    private val taskRepository: TaskRepository,
    private val sessionRepository: SessionRepository,
) {

    fun getAll(): List<User> {
        return userRepository.findAll()
    }

    @Transactional
    fun create(request: SignUpRequest): User {
        return User(
            username = request.username,
            email = request.email,
            password = bCryptPasswordEncoder.hash(request.password)
        ).let(userRepository::save)
    }

    fun getUsersStats(): List<UserStatsResponse> {
        val users = userRepository.findAll()

        val userStatsList = users.map { user ->
            val completedTasksCount = taskRepository.countByUserIdAndIsCompleted(user.id, true)

            UserStatsResponse(
                username = user.username,
                completedTasksCount = completedTasksCount,
            )
        }

        return userStatsList
            .filter { it.completedTasksCount > 0 }
            .sortedByDescending { it.completedTasksCount }
            .mapIndexed { index, userStatsResponse ->
                userStatsResponse.copy(rank = (index + 1).toLong())
            }
    }

    @Transactional
    fun updateUsernameById(request: UsernameChangeRequest, token: String): Int {
        if (userRepository.existsUserByUsername(request.username)) {
            throw RuntimeException("Username already existed.")
        }

        return userRepository.updateUsernameById(sessionRepository.getByToken(token).userId, request.username)
    }

    @Transactional
    fun updatePasswordById(request: PasswordChangeRequest, token: String): Int {
        return userRepository.updatePasswordById(
            sessionRepository.getByToken(token).userId,
            bCryptPasswordEncoder.hash(request.password)
        )
    }
}