package com.jiannlee22.jweather.repository

import com.jiannlee22.jweather.model.WeatherNow
import com.jiannlee22.jweather.network.WeatherService
import javax.inject.Inject

class WeatherNowRepository @Inject constructor(private val weatherService: WeatherService) {

    suspend fun weatherNow(key: String, location: String): WeatherNow {
        return weatherService.getNow(key, location)
    }

}