package ru.rosk3r.goalgetterapi.auth.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.rosk3r.goalgetterapi.auth.model.entity.Session
import ru.rosk3r.goalgetterapi.auth.model.request.SignUpRequest
import ru.rosk3r.goalgetterapi.auth.repository.UserRepository

@Service
class SignUpService(
    private val userRepository: UserRepository,
    private val userService: UserService,
    private val sessionService: SessionService,
) {

    @Transactional
    fun signUp(request: SignUpRequest): Session {
        if (userRepository.existsUserByEmail(request.email) || userRepository.existsUserByUsername(request.username)) {
            throw RuntimeException("User already existed.")
        }

        val savedUser = userService.create(request)

        return sessionService.create(savedUser.id)
    }

}