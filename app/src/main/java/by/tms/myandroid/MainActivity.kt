package by.tms.myandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import by.tms.myandroid.lesson1.Lesson1Activity
import by.tms.myandroid.lesson2.Lesson2Activity
import by.tms.myandroid.lesson3.Lesson3Activity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startLesson1.setOnClickListener(this)
        startLesson2.setOnClickListener(this)
        startLesson3.setOnClickListener(this)
        startLesson4.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            startLesson1.id -> {
                val intent = Intent(this, Lesson1Activity::class.java)
                startActivity(intent)
            }
            startLesson2.id -> {
                val intent = Intent(this, Lesson2Activity::class.java)
                startActivity(intent)
            }
            startLesson3.id -> {
                val intent = Intent(this, Lesson2Activity::class.java)
                startActivity(intent)
            }
            startLesson4.id -> {
                val intent = Intent(this, Lesson3Activity::class.java)
                startActivity(intent)
            }
        }
    }
}
