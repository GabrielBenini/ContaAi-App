package com.gabriel.beini.contaai_app.domain.model

import java.time.LocalDate

data class Expense(
    val id: Long,
    val description: String,
    val amountInCents: Long,
    val date: LocalDate,
    val categoryId: Long,
    val userId: Long
)
