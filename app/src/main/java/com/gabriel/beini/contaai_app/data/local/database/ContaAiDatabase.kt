package com.gabriel.beini.contaai_app.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gabriel.beini.contaai_app.data.local.dao.CategoryDao
import com.gabriel.beini.contaai_app.data.local.dao.ExpenseDao
import com.gabriel.beini.contaai_app.data.local.dao.UserDao
import com.gabriel.beini.contaai_app.data.local.entity.CategoryEntity
import com.gabriel.beini.contaai_app.data.local.entity.ExpenseEntity
import com.gabriel.beini.contaai_app.data.local.entity.UserEntity

@Database(
    entities = [
        UserEntity::class,
        CategoryEntity::class,
        ExpenseEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class ContaAiDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun categoryDao(): CategoryDao

    abstract fun expenseDao(): ExpenseDao
}