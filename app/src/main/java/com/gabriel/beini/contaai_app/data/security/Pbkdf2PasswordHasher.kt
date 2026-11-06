
package com.gabriel.beini.contaai_app.data.security

import android.util.Base64
import com.gabriel.beini.contaai_app.domain.security.PasswordHashResult
import com.gabriel.beini.contaai_app.domain.security.PasswordHasher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.security.SecureRandom
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec
import javax.inject.Inject

class Pbkdf2PasswordHasher @Inject constructor() : PasswordHasher {

    override suspend fun hashPassword(
        password: String
    ): PasswordHashResult = withContext(Dispatchers.Default) {

        val salt = ByteArray(16)
        SecureRandom().nextBytes(salt)

        val passwordChars = password.toCharArray()

        try {
            val spec = PBEKeySpec(
                passwordChars,
                salt,
                600_000,
                256
            )

            try {
                val factory = SecretKeyFactory.getInstance(
                    "PBKDF2WithHmacSHA256"
                )

                val hash = factory.generateSecret(spec).encoded

                val hashBase64 = Base64.encodeToString(
                    hash,
                    Base64.NO_WRAP
                )

                val saltBase64 = Base64.encodeToString(
                    salt,
                    Base64.NO_WRAP
                )

                PasswordHashResult(
                    hash = hashBase64,
                    salt = saltBase64
                )
            } finally {
                spec.clearPassword()
            }
        } finally {
            passwordChars.fill('\u0000')
        }
    }

    override suspend fun verifyPassword(
        password: String,
        storedHash: String,
        storedSalt: String
    ): Boolean {
        TODO("Not yet implemented")
    }
}
