package com.gabriel.beini.contaai_app.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "expenses",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = CategoryEntity::class,
            parentColumns = ["id", "user_id"],
            childColumns = ["category_id", "user_id"],
            onDelete = ForeignKey.NO_ACTION
        )
    ],
    indices = [
        Index(value = ["user_id"]),
        Index(value = ["category_id", "user_id"])
    ]
)
data class ExpenseEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "amount_in_cents")
    val amountInCents: Long,

    @ColumnInfo(name = "date")
    val date: Long,

    @ColumnInfo(name = "category_id")
    val categoryId: Long,

    @ColumnInfo(name = "user_id")
    val userId: Long
)
