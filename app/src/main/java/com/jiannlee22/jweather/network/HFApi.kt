package com.jiannlee22.jweather.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val WEATHER_URL = "https://devapi.qweather.com/v7/weather/"
const val KEY = "9348777783b84972959e0b451bedbc8b"

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