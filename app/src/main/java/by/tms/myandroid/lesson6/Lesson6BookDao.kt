package by.tms.myandroid.lesson6

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Lesson6BookDao {
    @Insert
    suspend fun addBook(book: Lesson6Book)

    @Query("SELECT * FROM Lesson6Book")
    suspend fun getAllBooks(): List<Lesson6Book>

    @Query("SELECT * FROM Lesson6Book WHERE name = :name")
    suspend fun getBooksByName(name: String): List<Lesson6Book>
}