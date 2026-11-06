package com.gabriel.beini.contaai_app.domain.repository

import com.gabriel.beini.contaai_app.domain.model.User

interface UserRepository {

    suspend fun getUserById(userId: Long): User?

    suspend fun getUserByEmail(email: String): User?

    suspend fun registerUser(name: String, email: String, password: String): User

    suspend fun authenticateUser(email: String, password: String): User?
}