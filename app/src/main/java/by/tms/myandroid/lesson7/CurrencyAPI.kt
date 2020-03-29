package by.tms.myandroid.lesson7

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NbrbAPI {
    @GET("exrates/rates")
    fun getCurrencyRates(
        @Query("onDate")
        onDate: String,
        @Query("periodicity")
        periodicity: Int
    ): Deferred<Response<List<CurrencyRateItem>>>

    @GET("exrates/rates/dynamics/{id}")
    fun getCurrencyDynamics(
        @Path("id")
        currencyId: Int,
        @Query("startDate")
        startDate: String,
        @Query("endDate")
        endDate: String
    ): Deferred<Response<List<CurrencyDynamicItem>>>
}