package by.tms.myandroid.lesson5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.tms.myandroid.R

class Lesson5InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson5_info)

        val fragment = Lesson5InfoFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.infoFragmentLesson5, fragment)
            .commit()
    }
}
