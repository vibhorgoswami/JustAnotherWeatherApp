package com.govibs.core.data.model

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class WeatherModel : Serializable {

    @JsonProperty("temp")
    var weatherTemp: WeatherTempModel? = null
    @JsonProperty("weather")
    var weatherDescriptionList: List<WeatherDescriptionModel>? = null

    var humidity: Int? = 0

    var pressure: Double? = 0.0

    var speed: Double? = 0.0

    @JsonProperty("deg")
    var direction: Int? = 0
    var clouds: Int? = 0

}