package com.gabriel.beini.contaai_app.data.mapper

import com.gabriel.beini.contaai_app.data.local.entity.ExpenseEntity
import com.gabriel.beini.contaai_app.domain.model.Expense
import java.time.LocalDate

fun ExpenseEntity.toDomain(): Expense {
    return Expense(
        id = this.id,
        description = this.description,
        amountInCents = this.amountInCents,
        date = LocalDate.ofEpochDay(this.date),
        categoryId = this.categoryId,
        userId = this.userId
    )
}

fun Expense.toEntity(): ExpenseEntity {
    return ExpenseEntity(
        id = this.id,
        description = this.description,
        amountInCents = this.amountInCents,
        date = this.date.toEpochDay(),
        categoryId = this.categoryId,
        userId = this.userId
    )
}