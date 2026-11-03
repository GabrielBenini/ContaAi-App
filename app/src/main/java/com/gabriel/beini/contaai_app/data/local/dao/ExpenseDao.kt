
package com.gabriel.beini.contaai_app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gabriel.beini.contaai_app.data.local.entity.ExpenseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertExpense(expense: ExpenseEntity): Long

    @Query("""
        SELECT * FROM expenses
        WHERE id = :expenseId AND user_id = :userId
    """)
    suspend fun getExpenseById(
        expenseId: Long,
        userId: Long
    ): ExpenseEntity?

    @Query("""
        SELECT * FROM expenses
        WHERE user_id = :userId
        ORDER BY date DESC, id DESC
    """)
    fun getExpensesByUser(
        userId: Long
    ): Flow<List<ExpenseEntity>>

    @Query("""
        UPDATE expenses
        SET description = :description,
            amount_in_cents = :amountInCents,
            date = :date,
            category_id = :categoryId
        WHERE id = :expenseId AND user_id = :userId
    """)
    suspend fun updateExpense(
        expenseId: Long,
        userId: Long,
        description: String,
        amountInCents: Long,
        date: Long,
        categoryId: Long
    ): Int

    @Query("""
        DELETE FROM expenses
        WHERE id = :expenseId AND user_id = :userId
    """)
    suspend fun deleteExpense(
        expenseId: Long,
        userId: Long
    ): Int
}
