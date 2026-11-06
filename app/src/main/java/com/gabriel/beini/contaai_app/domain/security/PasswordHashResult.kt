package com.gabriel.beini.contaai_app.domain.security

data class PasswordHashResult (
    val hash: String,
    val salt: String
)