package com.jiannlee22.jweather.utils

import android.content.Context
import android.widget.Toast
import javax.inject.Inject

class ToastUtil @Inject constructor(private val context: Context) {
    fun toast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }
}