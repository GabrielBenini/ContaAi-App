package com.gabriel.beini.contaai_app.domain.repository

import com.gabriel.beini.contaai_app.domain.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    suspend fun insertCategory(category: Category): Long

    suspend fun getCategoryById(categoryId: Long, userId: Long): Category?

    fun getCategoriesByUser(userId: Long): Flow<List<Category>>

    suspend fun updateCategory(category: Category, userId: Long): Int

    suspend fun deleteCategory(categoryId: Long, userId: Long): Int

}