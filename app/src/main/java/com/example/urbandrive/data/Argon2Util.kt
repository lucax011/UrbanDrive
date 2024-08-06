package com.example.urbandrive.data
import de.mkammerer.argon2.Argon2
import de.mkammerer.argon2.Argon2Factory

object Argon2Util {
    private val argon2: Argon2 = Argon2Factory.create()

    fun hashPassword(password: String): String {
        return argon2.hash(2, 65536, 1, password.toCharArray())
    }

    fun checkPassword(password: String, hashedPassword: String): Boolean {
        return argon2.verify(hashedPassword, password.toCharArray())
    }
}
