package com.gabriel.beini.contaai_app.data.repository

import com.gabriel.beini.contaai_app.data.local.dao.UserDao
import com.gabriel.beini.contaai_app.data.mapper.toDomain
import com.gabriel.beini.contaai_app.domain.model.User
import com.gabriel.beini.contaai_app.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : UserRepository {

    override suspend fun getUserById(userId: Long): User?{
        return userDao.getUserById(userId)?.toDomain()
    }

    override suspend fun getUserByEmail(email: String): User? {
        return userDao.getUserByEmail(email)?.toDomain()
    }

    override suspend fun registerUser(
        name: String,
        email: String,
        password: String
    ): User {
        TODO("Not yet implemented")
    }

    override suspend fun authenticateUser(
        email: String,
        password: String
    ): User? {
        TODO("Not yet implemented")
    }

}