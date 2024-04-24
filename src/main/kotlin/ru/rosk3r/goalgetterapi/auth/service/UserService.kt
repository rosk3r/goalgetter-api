package ru.rosk3r.goalgetterapi.auth.service

import ru.rosk3r.goalgetterapi.auth.model.entity.User
import ru.rosk3r.goalgetterapi.auth.model.request.SignUpRequest
import ru.rosk3r.goalgetterapi.auth.repository.UserRepository
import org.springframework.stereotype.Service
import ru.rosk3r.goalgetterapi.auth.model.response.UserStatsResponse
import ru.rosk3r.goalgetterapi.auth.util.encoder.BCryptPasswordEncoder
import ru.rosk3r.goalgetterapi.task.repository.TaskRepository

@Service
class UserService(
    private val userRepository: UserRepository,
    private val bCryptPasswordEncoder: BCryptPasswordEncoder,
    private val taskRepository: TaskRepository,
) {

    fun getAll(): List<User> {
        return userRepository.findAll()
    }

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
                completedTasksCount = completedTasksCount
            )
        }

        return userStatsList.filter { it.completedTasksCount > 0 }
    }
}