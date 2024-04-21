package ru.rosk3r.goalgetterapi.auth.service

import ru.rosk3r.goalgetterapi.auth.model.entity.User
import ru.rosk3r.goalgetterapi.auth.model.request.SignUpRequest
import ru.rosk3r.goalgetterapi.auth.repository.UserRepository
import org.springframework.stereotype.Service
import ru.rosk3r.goalgetterapi.auth.util.encoder.BCryptPasswordEncoder

@Service
class UserService(
    private val userRepository: UserRepository,
    private val bCryptPasswordEncoder: BCryptPasswordEncoder,
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

}