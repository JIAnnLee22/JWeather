package com.jiannlee22.jweather.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jiannlee22.jweather.model.WeatherNow
import com.jiannlee22.jweather.network.KEY
import com.jiannlee22.jweather.repository.WeatherNowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val weatherNowRepository: WeatherNowRepository) :
    ViewModel() {

    private val _weatherNow = mutableStateOf<WeatherNow?>(null)
    val weatherNow: WeatherNow? get() = _weatherNow.value

    fun loadLocationInfo() {
//        LocationInfoWithSystem()
    }

    fun weatherNow() {
        viewModelScope.launch(Dispatchers.Default) {
            val now = withContext(Dispatchers.IO) {
                weatherNowRepository.weatherNow(KEY, "113.12,23.00")
            }
            _weatherNow.value = now
        }
    }

}