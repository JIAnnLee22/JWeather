package com.jiannlee22.jweather

import android.app.Application
import com.jiannlee22.jweather.utils.ToastUtil
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class JWeatherApp : Application() {
    @Inject
    lateinit var toastUtil: ToastUtil
}