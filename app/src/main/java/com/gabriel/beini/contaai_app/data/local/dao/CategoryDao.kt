package com.gabriel.beini.contaai_app.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.gabriel.beini.contaai_app.data.local.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertCategory(category: CategoryEntity): Long

    @Query("SELECT * FROM categories WHERE id = :categoryId AND user_id = :userId")
    suspend fun getCategoryById(categoryId: Long, userId: Long): CategoryEntity?

    @Query("SELECT * FROM categories WHERE user_id = :userId ORDER BY name ASC")
    fun getCategoriesByUser(userId: Long): Flow<List<CategoryEntity>>

    @Update
    suspend fun updateCategory(category: CategoryEntity): Int

    @Delete
    suspend fun deleteCategory(category: CategoryEntity): Int
}