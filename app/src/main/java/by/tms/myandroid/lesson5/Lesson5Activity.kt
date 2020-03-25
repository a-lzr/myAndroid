package by.tms.myandroid.lesson5

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import by.tms.myandroid.R
import kotlinx.android.synthetic.main.activity_lesson5.*

class Lesson5Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson5)

        Lesson5ProductCollection.instance.initCollection()

        listView.adapter = Lesson5ProductAdapter(Lesson5ProductCollection.instance.collection)
        listView.layoutManager = LinearLayoutManager(this)
        listView.setHasFixedSize(true)
    }
}
