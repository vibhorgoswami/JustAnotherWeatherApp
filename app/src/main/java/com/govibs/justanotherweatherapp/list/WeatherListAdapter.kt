package com.govibs.justanotherweatherapp.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.govibs.core.data.model.WeatherModel
import com.govibs.justanotherweatherapp.R
import kotlinx.android.synthetic.main.layout_item_weather.view.*
import java.util.*

/**
 * Weather List Adapter
 * Created by Vibhor on 1/4/18.
 */
class WeatherListAdapter(private var weatherModeList: List<WeatherModel>,
                         private val itemClick: (WeatherModel) -> Unit) : RecyclerView.Adapter<WeatherListAdapter.WeatherListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): WeatherListViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.layout_item_weather, parent, false)
        return WeatherListViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: WeatherListViewHolder?, position: Int) {
        holder?.bindWeather(weatherModeList.get(position))
    }

    override fun getItemCount(): Int {
        return weatherModeList.size
    }

    fun swapAdapter(weatherModeList: List<WeatherModel>) {
        this.weatherModeList = weatherModeList
        notifyDataSetChanged()
    }

    class WeatherListViewHolder(view: View,
                                private val itemClick: (WeatherModel) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bindWeather(weatherModel: WeatherModel) {
            with(weatherModel) {
                itemView.tvWeatherCurrentTemp.text = String.format(Locale.getDefault(), "%.2f", weatherModel.weatherTemp?.day)
                itemView.tvWeatherMax.text = String.format(Locale.getDefault(), "%.2f", weatherModel.weatherTemp?.max)
                itemView.tvWeatherMin.text = String.format(Locale.getDefault(), "%.2f", weatherModel.weatherTemp?.min)
                itemView.tvWeatherDescription.text = weatherModel.weatherDescriptionList?.get(0)?.description
            }
        }
    }


}