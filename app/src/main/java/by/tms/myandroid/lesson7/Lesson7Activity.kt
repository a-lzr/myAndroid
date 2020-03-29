package by.tms.myandroid.lesson7

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import by.tms.myandroid.R
import kotlinx.android.synthetic.main.activity_lesson7.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class Lesson7Activity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson7)

        val instance = CurrencyRateCollection.instance
        var date: Date? = null

        CoroutineScope(Dispatchers.IO).launch {
            val response = getCurrencyRates("")
            if (response.isSuccessful) {
                response.body()?.let { it1 -> instance.collection.addAll(it1) }
                date = SimpleDateFormat("yyyy-mm-dd").parse(instance.collection[0].Date)
                sort(instance.collection)

                withContext(Dispatchers.Main) {
                    recyclerViewLesson7.adapter = CurrencyRateAdapter()
                    recyclerViewLesson7.layoutManager =
                        LinearLayoutManager(recyclerViewLesson7.context)
                    recyclerViewLesson7.setHasFixedSize(true)
                    dateLesson7.text = SimpleDateFormat("dd.mm.yyyy").format(date!!)
                }
            } else {
                Log.e("ERROR", response.code().toString())
            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            while (date == null) {} // ожидание выполнения первого корутина
            val calendar = Calendar.getInstance()
            calendar.time = date!!
            calendar.add(Calendar.DAY_OF_YEAR, -1)

            val response = getCurrencyRates(SimpleDateFormat("yyyy-mm-dd").format(calendar.time))
            if (response.isSuccessful) {
                response.body()?.let { it1 -> instance.collectionLastDay.addAll(it1) }
                sort(instance.collectionLastDay)

                withContext(Dispatchers.Main) {
                    recyclerViewLesson7.adapter!!.notifyDataSetChanged()
                }
            } else {
                Log.e("ERROR", response.code().toString())
            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            while (date == null) {} // ожидание выполнения первого корутина
            val calendar = Calendar.getInstance()
            calendar.time = date!!
            calendar.add(Calendar.DAY_OF_YEAR, -7)

            val response = getCurrencyRates(SimpleDateFormat("yyyy-mm-dd").format(calendar.time))
            if (response.isSuccessful) {
                response.body()?.let { it1 -> instance.collectionLastWeek.addAll(it1) }
                sort(instance.collectionLastWeek)

                withContext(Dispatchers.Main) {
                    recyclerViewLesson7.adapter!!.notifyDataSetChanged()
                }
            } else {
                Log.e("ERROR", response.code().toString())
            }
        }
    }

    private suspend fun getCurrencyRates(onDate: String): Response<List<CurrencyRateItem>> {
        return CurrencyAPIFactory
            .getRetrofitRates()
            .getCurrencyRates(onDate, 0)
            .await()
    }
}