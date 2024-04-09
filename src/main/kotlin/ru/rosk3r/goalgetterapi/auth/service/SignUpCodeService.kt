package ru.rosk3r.goalgetterapi.auth.service

import ru.rosk3r.goalgetterapi.auth.model.entity.SignUpCode
import ru.rosk3r.goalgetterapi.auth.model.request.SignUpRequest
import ru.rosk3r.goalgetterapi.auth.repository.SignUpCodeRepository
import org.springframework.stereotype.Service

@Service
class SignUpCodeService(private val signUpCodeRepository: SignUpCodeRepository) {

    fun getAll(): List<SignUpCode> {
        return signUpCodeRepository.findAll()
    }

    fun validate(request: SignUpRequest): Boolean {
        if (!signUpCodeRepository.existsByCodeAndEmail(request.code, request.email)) {
            throw IllegalArgumentException("Wrong validation code.")
        }
        return true
    }

}