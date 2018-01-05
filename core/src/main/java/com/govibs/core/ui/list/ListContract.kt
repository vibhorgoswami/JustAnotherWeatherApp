package com.govibs.core.ui.list

import com.govibs.core.data.model.WeatherModel
import com.govibs.core.ui.base.RemoteView

interface ListContract {

    interface ViewActions {
        fun onInitialRequest()
        fun onSearchWithPostalCode()
    }

    interface ListView : RemoteView {
        fun showWeatherList(weatherModelList: List<WeatherModel>)
        fun showWeatherDetail(weatherModel: WeatherModel)
    }

}