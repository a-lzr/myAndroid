package by.tms.myandroid.lesson7

data class CurrencyRate(
    val Cur_Abbreviation: String,
    val Cur_ID: Int,
    val Cur_Name: String,
    val Cur_OfficialRate: Double,
    val Cur_Scale: Int,
    val Date: String,
    var Last_OfficialRate: Double?
)

class CurrencyRateCollection {
    val collection = ArrayList<CurrencyRateItem>()
    val collectionLastDay = ArrayList<CurrencyRateItem>()
    val collectionLastWeek = ArrayList<CurrencyRateItem>()

    companion object {
        val instance by lazy { CurrencyRateCollection() }
    }
}

fun sort(list: ArrayList<CurrencyRateItem>) {
    list.sortWith(Comparator<CurrencyRateItem> { p1, p2 ->
        when {
            p1.Cur_Abbreviation == "USD" -> -1
            p2.Cur_Abbreviation == "USD" -> 1
            p1.Cur_Abbreviation == "EUR" -> -1
            p2.Cur_Abbreviation == "EUR" -> 1
            p1.Cur_Abbreviation == "RUB" -> -1
            p2.Cur_Abbreviation == "RUB" -> 1
            p1.Cur_Abbreviation == "CNY" -> -1
            p2.Cur_Abbreviation == "CNY" -> 1
            p1.Cur_Abbreviation == "PLN" -> -1
            p2.Cur_Abbreviation == "PLN" -> 1
            p1.Cur_Abbreviation == "UAH" -> -1
            p2.Cur_Abbreviation == "UAH" -> 1
            p1.Cur_Abbreviation > p2.Cur_Abbreviation -> 1
            p1.Cur_Abbreviation == p2.Cur_Abbreviation -> 0
            else -> -1
        }
    })
}