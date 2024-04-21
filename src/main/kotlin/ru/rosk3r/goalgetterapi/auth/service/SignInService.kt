package ru.rosk3r.goalgetterapi.auth.service

import ru.rosk3r.goalgetterapi.auth.model.entity.Session
import ru.rosk3r.goalgetterapi.auth.model.request.SignInRequest
import ru.rosk3r.goalgetterapi.auth.repository.UserRepository
import org.springframework.stereotype.Service
import ru.rosk3r.goalgetterapi.auth.util.encoder.BCryptPasswordEncoder

@Service
class SignInService(
    private val userRepository: UserRepository,
    private val sessionService: SessionService,
    private val bCryptPasswordEncoder: BCryptPasswordEncoder,
) {

    fun signIn(request: SignInRequest): Session {
        val userByEmail = userRepository.findUserByEmail(request.email).orElseThrow()
        val check = bCryptPasswordEncoder.check(request.password, userByEmail.password)
        if (!check) throw IllegalArgumentException("Wrong email or password.")

        return sessionService.create(userByEmail.id)
    }

}
