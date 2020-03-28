package by.tms.myandroid.lesson6

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Lesson6Book (
    @PrimaryKey val id: Int,
    val name: String,
    val author: String,
    val year: Int
)