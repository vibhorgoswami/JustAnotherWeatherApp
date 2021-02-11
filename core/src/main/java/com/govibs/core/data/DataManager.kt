package com.govibs.core.data

import com.govibs.core.data.model.WeatherBaseModel
import com.govibs.core.data.network.weather.WeatherService
import com.govibs.core.data.network.weather.WeatherServiceFactory
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class DataManager private constructor() {

    private val mWeatherService: WeatherService = WeatherServiceFactory.makeWeatherService()
    private val RESPONSE_MODE: String = "json"
    private val APP_ID = "{INSERT_API_KEY}"

    companion object {
        private var sInstance: DataManager? = null

        fun getInstance(): DataManager {
            if (sInstance == null) {
                sInstance = DataManager()
            }
            return sInstance as DataManager
        }
    }

    fun getWeatherInfo(query: String, unit: String, days: Int): Single<WeatherBaseModel> {
        return mWeatherService.getDailyWeatherForLocationByPostalCode(query, days, unit, RESPONSE_MODE, APP_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
    }

}
