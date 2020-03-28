package by.tms.myandroid.lesson6

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Lesson6Book::class), version = 1)
abstract class Lesson6BookDatabase : RoomDatabase() {
    abstract fun getBookDao(): Lesson6BookDao
}