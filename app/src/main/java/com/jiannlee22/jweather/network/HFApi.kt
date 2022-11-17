package com.jiannlee22.jweather.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val WEATHER_URL = "https://devapi.qweather.com/v7/weather/"
const val KEY = ""

object HFApi {
    private val weatherRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl(WEATHER_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
    val weatherService by lazy {
        weatherRetrofit.create(WeatherService::class.java)
    }
}
