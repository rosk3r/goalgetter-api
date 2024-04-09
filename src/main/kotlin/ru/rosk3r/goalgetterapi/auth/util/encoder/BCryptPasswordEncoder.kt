package io.shapito.tasks.auth.util.encoder

import org.mindrot.jbcrypt.BCrypt

class BCryptPasswordEncoder(private val saltRounds: Int) {

    fun hash(password: String): String {
        return BCrypt.hashpw(password, BCrypt.gensalt(saltRounds))
    }

    fun check(password: String, hash: String): Boolean {
        return BCrypt.checkpw(password, hash)
    }

}