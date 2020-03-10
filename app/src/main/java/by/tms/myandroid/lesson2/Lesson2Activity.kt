package by.tms.myandroid.lesson2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.tms.myandroid.R
import kotlinx.android.synthetic.main.activity_lesson2.*

class Lesson2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson2)

        showFlags.setOnClickListener {
            val intent = Intent(this, Lesson2FlagsActivity::class.java)
            startActivity(intent)
        }

        showAnimation.setOnClickListener {
            val intent = Intent(this, Lesson2AnimationActivity::class.java)
            startActivity(intent)
        }
    }
}
