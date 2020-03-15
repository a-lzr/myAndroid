package by.tms.myandroid.lesson4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.tms.myandroid.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_lesson4_info.*

class Lesson4InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson4_info)

        val name = intent.getStringExtra(REQUEST_FIELD_FLOWER_NAME)
        val price = intent.getDoubleExtra(REQUEST_FIELD_FLOWER_PRICE, 0.0)
        val url = intent.getStringExtra(REQUEST_FIELD_FLOWER_URL)

        nameInfoLesson4.text = name
        priceInfoLesson4.text = price.toString()
        if (url.isNullOrEmpty())
            Picasso.get()
                .load(R.mipmap.ic_launcher)
                .into(this.imageInfoLesson4)
        else
            Picasso.get()
                .load(url.toString())
                .placeholder(R.mipmap.ic_launcher)
                .into(this.imageInfoLesson4)
    }
}
