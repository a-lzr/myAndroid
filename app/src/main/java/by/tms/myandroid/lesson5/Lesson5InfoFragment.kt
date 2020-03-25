package by.tms.myandroid.lesson5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import by.tms.myandroid.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_lesson5_info.*

class Lesson5InfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lesson5_info, container, false)
    }

    @Override
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val instance = Lesson5ProductCollection.instance
        val item = instance.collection[instance.position]

        this.nameInfoLesson5.text = item.name
        this.priceInfoLesson5.text = item.price.toString()
        Picasso.get()
            .load(item.url)
            .placeholder(R.mipmap.ic_launcher)
            .into(this.imageInfoLesson5)
    }
}
