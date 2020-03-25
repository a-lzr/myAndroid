package by.tms.myandroid.lesson5

import android.content.Intent
import android.content.res.Configuration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.tms.myandroid.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_lesson5_item.view.*

class Lesson5ProductAdapter(val list: ArrayList<Lesson5Product>) :
    RecyclerView.Adapter<Lesson5ProductAdapter.BeerViewHolder>() {

    class BeerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_lesson5_item, parent, false)
        return BeerViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        val itemView = holder.itemView
        itemView.nameProduct.text = list.get(position).name
        itemView.priceProduct.text = list.get(position).price.toString()
        Picasso.get().load(list.get(position).url).into(itemView.imageProduct)

        itemView.setOnClickListener() {
            Lesson5ProductCollection.instance.position = position

            if (it.context.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                val fragment = Lesson5InfoFragment()
                (it.context as Lesson5Activity).supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.detailFragmentLesson5, fragment)
                    .commit()
            }
            else {
                val intent = Intent(it.context, Lesson5InfoActivity::class.java)
                it.context.startActivity(intent)
            }
        }
    }
}