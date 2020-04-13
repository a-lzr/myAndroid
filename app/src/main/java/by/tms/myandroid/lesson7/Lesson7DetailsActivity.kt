package by.tms.myandroid.lesson7

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import by.tms.myandroid.R
import kotlinx.android.synthetic.main.activity_lesson7_details.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class Lesson7DetailsActivity : AppCompatActivity() {

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson7_details)

        val instance = CurrencyRateCollection.instance

        CoroutineScope(Dispatchers.IO).launch {
            val calendar = Calendar.getInstance()
            calendar.time = instance.date!!
            calendar.add(Calendar.DAY_OF_YEAR, -10)

            val response = getCurrencyDetails(
                instance.collection[instance.position].Cur_ID,
                SimpleDateFormat("yyyy-mm-dd").format(calendar.time),
                SimpleDateFormat("yyyy-mm-dd").format(instance.date!!)
            )
            if (response.isSuccessful) {
                instance.collectionDynamics.clear()
                response.body()?.let { it1 -> instance.collectionDynamics.addAll(it1) }
                instance.collectionDynamics.sortByDescending { it.Date }

                withContext(Dispatchers.Main) {
                    dynamicViewLesson7.adapter = CurrencyDynamicAdapter()
                    dynamicViewLesson7.layoutManager =
                        LinearLayoutManager(dynamicViewLesson7.context)
                    dynamicViewLesson7.setHasFixedSize(true)
                }
            } else {
                Log.e("ERROR", response.code().toString())
            }
        }
    }

    private suspend fun getCurrencyDetails(
        currencyId: Int,
        startDate: String,
        endDate: String
    ): Response<List<CurrencyDynamicItem>> {
        return CurrencyAPIFactory
            .getRetrofitRates()
            .getCurrencyDynamics(currencyId, startDate, endDate)
            .await()
    }
}