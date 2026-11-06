package com.gabriel.beini.contaai_app.domain.security

interface PasswordHasher {

    suspend fun hashPassword(password: String): PasswordHashResult

    suspend fun verifyPassword(password: String, storedHash: String, storedSalt: String): Boolean


}