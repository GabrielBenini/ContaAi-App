package com.gabriel.beini.contaai_app.domain.repository

import com.gabriel.beini.contaai_app.domain.model.Expense
import kotlinx.coroutines.flow.Flow

interface ExpenseRepository {

    suspend fun insertExpense(expense: Expense): Long

    suspend fun getExpenseById(expenseId: Long, userId: Long): Expense?

    fun getExpensesByUser(userId: Long): Flow<List<Expense>>

    suspend fun updateExpense(expense: Expense, userId: Long): Int

    suspend fun deleteExpense(expenseId: Long, userId: Long): Int
}