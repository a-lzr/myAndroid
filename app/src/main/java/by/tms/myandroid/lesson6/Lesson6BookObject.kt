package by.tms.myandroid.lesson6

import android.content.Context
import androidx.room.Room

class Lesson6BookObject(context: Context) {
    val database by lazy {
        Room.databaseBuilder(
            context,
            Lesson6BookDatabase::class.java, "lesson6-database"
        ).build()
    }

    companion object {
        fun getInstance(context: Context) = Lesson6BookObject(context)
    }
}