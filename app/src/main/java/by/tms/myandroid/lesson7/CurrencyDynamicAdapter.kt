package by.tms.myandroid.lesson7

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import by.tms.myandroid.R
import kotlinx.android.synthetic.main.item_lesson7_currency_dynamic.view.*
import java.text.DecimalFormat
import java.text.SimpleDateFormat

class CurrencyDynamicAdapter :
    RecyclerView.Adapter<CurrencyDynamicAdapter.CurrencyDynamicViewHolder>() { // val list: ArrayList<CurrencyRateItem> {

    class CurrencyDynamicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyDynamicViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lesson7_currency_dynamic, parent, false)
        return CurrencyDynamicViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return CurrencyRateCollection.instance.collection.size
    }

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    override fun onBindViewHolder(holder: CurrencyDynamicViewHolder, position: Int) {
        val itemView = holder.itemView
        val instance = CurrencyRateCollection.instance

        with(instance.collectionDynamics[position]) {
            itemView.codeCurrencyDynamicLesson7.text =
                "${instance.collection[instance.position].Cur_Scale} $Cur_OfficialRate = $Cur_OfficialRate BYN"
            itemView.dateCurrencyDynamicLesson7.text =
                SimpleDateFormat("dd.mm.yyyy").format(
                    SimpleDateFormat("yyyy-mm-dd").parse(Date)!!
                )

            with(CurrencyRateCollection.instance.collectionDynamics) {
                if (size > position + 1)
                    updateRateView(
                        itemView.rateLastDayCurrencyDynamicLesson7,
                        "1d",
                        Cur_OfficialRate - get(position + 1).Cur_OfficialRate
                    )
                else
                    itemView.rateLastDayCurrencyDynamicLesson7.text = ""
            }
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