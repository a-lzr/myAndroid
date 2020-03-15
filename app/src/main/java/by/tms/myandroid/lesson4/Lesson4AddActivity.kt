package by.tms.myandroid.lesson4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import by.tms.myandroid.R
import kotlinx.android.synthetic.main.activity_lesson4_add.*

class Lesson4AddActivity : AppCompatActivity(), View.OnClickListener {

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson4_add)

        addFlowerToListLesson4.setOnClickListener(this)
    }

    @Override
    override fun onClick(view: View?) {
        when (view?.id) {
            addFlowerToListLesson4.id -> {
                if (editFlowerNameLesson4.text.isNotEmpty() && editFlowerPrice.text.isNotEmpty()) {
                    Lesson4Collection.instance.apply {
                        addFlower(
                            editFlowerNameLesson4.text.toString(),
                            editFlowerPrice.text.toString().toDouble(),
                            editFlowerUrlLesson4.text.toString()
                        )
                    }
                    Toast.makeText(this, R.string.lesson4_add_complete, Toast.LENGTH_SHORT).show()
                    onBackPressed()
                } else
                    Toast.makeText(this, R.string.lesson4_add_failed, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
