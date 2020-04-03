package by.tms.myandroid.lesson6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import by.tms.myandroid.R
import kotlinx.android.synthetic.main.activity_lesson6.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Lesson6Activity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson6)

        writeBtnLesson6.setOnClickListener(this)
        readBtnLesson6.setOnClickListener(this)
        clearBtnLesson6.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val database = Lesson6BookObject.getInstance(this).database
        when (v?.id) {
            writeBtnLesson6.id -> {
                CoroutineScope(Dispatchers.IO).launch {
                    database.getBookDao().addBook(
                        Lesson6Book(
                            editTextLesson6.text.toString().toInt(),
                            "Война и мир",
                            "Толстой Л.Н.",
                            1869
                        )
                    )
                }
                editTextLesson6.text.clear()
            }
            readBtnLesson6.id -> {
                CoroutineScope(Dispatchers.IO).launch {
                    val allPinguins = database.getBookDao().getAllBooks()
                    withContext(Dispatchers.Main) {
                        textViewLesson6.text = allPinguins.toString()
                    }
                }
            }
        }
    }
}
