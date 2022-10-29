package com.jiannlee22.jweather.location

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.core.app.ActivityCompat
import com.jiannlee22.jweather.utils.ToastUtil
import javax.inject.Inject

class LocationInfoWithSystem @Inject constructor(
    private val context: Context
) : ILocation {

    @Inject
    lateinit var toastUtil: ToastUtil

    private val manager: LocationManager =
        context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    private var provider: String? = null

    // priority use gps
    private val providers: Unit
        get() {
            val providers = manager.getProviders(true)
            if (providers.isEmpty()) {
                return
            }
            // priority use gps
            if (providers.contains(LocationManager.GPS_PROVIDER)) {
                provider = LocationManager.GPS_PROVIDER
            } else if (providers.contains(LocationManager.NETWORK_PROVIDER)) {
                provider = LocationManager.NETWORK_PROVIDER
            } else {
                toastUtil.toast("no location provider")
            }
        }


    override fun getLocationInfo(): LocationInfo? {
        if (ActivityCompat.checkSelfPermission(
                context, Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context, Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            toastUtil.toast(
                "can not get location service",
            )
            return null
        }
        val location = manager.getLastKnownLocation(provider!!)
        val info = location.toString()
        val lat = location!!.latitude
        val lng = location.longitude
        return LocationInfo(info, lat, lng)
    }
}