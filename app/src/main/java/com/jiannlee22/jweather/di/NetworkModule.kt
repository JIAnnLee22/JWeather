package com.jiannlee22.jweather.di

import com.jiannlee22.jweather.network.WEATHER_URL
import com.jiannlee22.jweather.network.WeatherService
import com.jiannlee22.jweather.repository.WeatherNowRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideWeatherService(): WeatherService {
        return Retrofit.Builder()
            .baseUrl(WEATHER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherService::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherNowRepository(weatherService: WeatherService): WeatherNowRepository {
        return WeatherNowRepository(weatherService)
    }

}