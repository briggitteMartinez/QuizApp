package com.example.quizapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "question")
data class Question (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "question") val question: String,
    @ColumnInfo(name = "image")val image: Int,

    @ColumnInfo(name = "option 1")val optOne: String,
    @ColumnInfo(name = "option 2")val optTwo: String,
    @ColumnInfo(name = "option 3")val optThree: String,
    @ColumnInfo(name = "correct answer")val correctAnswer: Int

)