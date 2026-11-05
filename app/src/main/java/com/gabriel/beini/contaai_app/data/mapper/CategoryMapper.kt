package com.gabriel.beini.contaai_app.data.mapper

import com.gabriel.beini.contaai_app.data.local.entity.CategoryEntity
import com.gabriel.beini.contaai_app.domain.model.Category

fun CategoryEntity.toDomain(): Category {
    return Category(
        id = this.id,
        name = this.name,
        icon = this.icon,
        color = this.color,
        userId = this.userId
    )
}

fun Category.toEntity(): CategoryEntity {
    return CategoryEntity(
        id = this.id,
        name = this.name,
        icon = this.icon,
        color = this.color,
        userId = this.userId
    )
}