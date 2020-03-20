package by.tms.myandroid.lesson4

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Flower (var name: String, var price: Double, var url: String) : Parcelable

class Lesson4Collection {
    private val list = ArrayList<Flower>()
    var addTop: Boolean = false
    var addBottom: Boolean = false

    companion object {
        val instance = Lesson4Collection()
    }

    fun addFlower (name: String, price: Double, url: String) {
        instance.list.add(Flower(name, price, url))
    }

    fun getFlower (index: Int) : Flower {
        return instance.list[index]
    }

    fun getCount() : Int {
        return instance.list.size
    }
}