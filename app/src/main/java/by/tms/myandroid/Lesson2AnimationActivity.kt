package by.tms.myandroid

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lesson2_animation.*

class Lesson2AnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson2_animation)

        lateinit var timer: CountDownTimer
        timer = object : CountDownTimer(4000, 1000) {

            var step = 0

            override fun onFinish() {
                step = 0
                timer.start()
            }

            override fun onTick(millisUntilFinished: Long) {
                val resId = when (step) {
                    0 -> R.drawable.animation_0
                    1 -> R.drawable.animation_1
                    2 -> R.drawable.animation_2
                    else -> R.drawable.animation_3
                }
                imageView.setImageResource(resId)
                ++step
            }
        }.start()
    }
}
