package by.tms.myandroid.lesson7

data class CurrencyRateItem(
    val Cur_Abbreviation: String,
    val Cur_ID: Int,
    val Cur_Name: String,
    val Cur_OfficialRate: Double,
    val Cur_Scale: Int,
    val Date: String
)

data class CurrencyDynamicItem(
    val Cur_ID: Int,
    val Cur_OfficialRate: Double,
    val Date: String
)