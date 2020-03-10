package by.tms.myandroid.lesson3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay

class Lesson3ViewModel: ViewModel() {
    val currenctStats = MutableLiveData<ArrayList<Int>>()

    var confirmed = 0
    var recovered = 0
    var dead = 0

    suspend fun getDataFromInternet() {
        delay(2000)
        val list = java.util.ArrayList<Int>()
        list.add(28000)
        list.add(19000)
        list.add(50)

        currenctStats.postValue(list)
    }
}