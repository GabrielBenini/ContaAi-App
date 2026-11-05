package com.gabriel.beini.contaai_app.data.mapper

import com.gabriel.beini.contaai_app.data.local.entity.UserEntity
import com.gabriel.beini.contaai_app.domain.model.User

fun UserEntity.toDomain(): User {
    return User(
        id = this.id,
        name = this.name,
        email = this.email
    )
}
