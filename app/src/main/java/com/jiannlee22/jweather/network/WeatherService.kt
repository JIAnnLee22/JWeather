package com.jiannlee22.jweather.network

import com.jiannlee22.jweather.model.WeatherDaily
import com.jiannlee22.jweather.model.WeatherHourly
import com.jiannlee22.jweather.model.WeatherNow
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("now")
    suspend fun getNow(
        @Query("key") key: String,
        @Query("location") location: String
    ): WeatherNow

    suspend fun getHourly(): WeatherHourly

    suspend fun getDaily(): WeatherDaily
}