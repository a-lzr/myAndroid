package by.tms.myandroid.lesson7

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import by.tms.myandroid.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_lesson7_currency_rate.view.*
import java.text.DecimalFormat

class CurrencyRateAdapter :
    RecyclerView.Adapter<CurrencyRateAdapter.CurrencyRateViewHolder>() { // val list: ArrayList<CurrencyRateItem>

    class CurrencyRateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyRateViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lesson7_currency_rate, parent, false)
        return CurrencyRateViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return CurrencyRateCollection.instance.collection.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CurrencyRateViewHolder, position: Int) {
        val itemView = holder.itemView
        with(CurrencyRateCollection.instance.collection[position]) {
            itemView.codeCurrencyLesson7.text =
                "$Cur_Scale $Cur_Abbreviation = $Cur_OfficialRate BYN"
            itemView.nameCurrencyLesson7.text = Cur_ID.toString() // Cur_Name
            with(CurrencyRateCollection.instance.collectionLastDay) {
                if (size > position)
                    updateRateView(
                        itemView.rateLastDayCurrencyLesson7,
                        "1d",
                        Cur_OfficialRate - get(position).Cur_OfficialRate
                    )
                else
                    itemView.rateLastDayCurrencyLesson7.text = ""
            }
            with(CurrencyRateCollection.instance.collectionLastWeek) {
                if (size > position)
                    updateRateView(
                        itemView.rateLastWeekCurrencyLesson7,
                        "7d",
                        Cur_OfficialRate - get(position).Cur_OfficialRate
                    )
                else
                    itemView.rateLastWeekCurrencyLesson7.text = ""
            }
            val resId =
                when (Cur_Abbreviation) {
                    "USD" -> R.drawable.ic_currency_usd
                    "EUR" -> R.drawable.ic_currency_eur
                    "RUB" -> R.drawable.ic_currency_rub
                    "CNY" -> R.drawable.ic_currency_cny
                    "UAH" -> R.drawable.ic_currency_uah
                    "PLN" -> R.drawable.ic_currency_pln
                    else -> R.mipmap.ic_launcher
                }

            Picasso.get().load(resId)
                .placeholder(R.mipmap.ic_launcher)
                .into(itemView.imageCurrencyLesson7)
        }

        itemView.setOnClickListener() {
            CurrencyRateCollection.instance.position = position
            val intent = Intent(it.context, Lesson7DetailsActivity::class.java)
            it.context.startActivity(intent)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun updateRateView(item: TextView, title: String, rate: Double) {
        item.text = "$title: ${DecimalFormat("#.####").format(rate)} BYN"
        when {
            rate > 0 -> item.setTextColor(ContextCompat.getColor(item.context, R.color.colorRed))
            rate < 0 -> item.setTextColor(ContextCompat.getColor(item.context, R.color.colorGreen))
            else -> item.setTextColor(ContextCompat.getColor(item.context, R.color.colorBlack))
        }
    }
}