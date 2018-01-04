package com.govibs.core.data

import com.govibs.core.data.model.WeatherBaseModel
import com.govibs.core.data.network.RemoteCallback
import com.govibs.core.data.network.weather.WeatherService
import com.govibs.core.data.network.weather.WeatherServiceFactory

class DataManager private constructor() {

    private val mWeatherService: WeatherService = WeatherServiceFactory.makeWeatherService()
    private val RESPONSE_MODE: String = "json"
    private val APP_ID = "4ae629ed0d7425a9b73110c9b9cd77d7"

    companion object {
        private var sInstance: DataManager? = null

        fun getInstance(): DataManager {
            if (sInstance == null) {
                sInstance = DataManager()
            }
            return sInstance as DataManager
        }
    }

    fun getWeatherInfo(postalCode: String, unit: String, days: Int, listener: RemoteCallback<WeatherBaseModel>) {
        mWeatherService.getDailyWeatherForLocationByPostalCode("19333", 7, unit, RESPONSE_MODE, APP_ID)
                .enqueue(listener)
    }

}