package by.tms.myandroid.lesson4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.tms.myandroid.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_lesson4.*

class Lesson4Fragment : Fragment() {

    var name: String? = null
    var price: Double? = null
    var url: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lesson4, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        this.nameFragmentLesson4.text = name.toString()
        this.priceFragmentLesson4.text = price.toString()
        if (url.isNullOrEmpty())
            Picasso.get()
                .load(R.mipmap.ic_launcher)
                .into(this.imageFragmentLesson4)
        else
            Picasso.get()
                .load(url.toString())
                .placeholder(R.mipmap.ic_launcher)
                .into(this.imageFragmentLesson4)
    }

    fun updateData(flower: Flower) {
        this.name = flower.name
        this.price = flower.price
        this.url = flower.url
    }
}