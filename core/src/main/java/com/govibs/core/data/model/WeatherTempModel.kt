package com.govibs.core.data.model

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class WeatherTempModel: Serializable {

    var day: Double? = 0.0
    var min: Double? = 0.0
    var max: Double? = 0.0
    var night: Double? = 0.0
    @JsonProperty("eve")
    var evening: Double? = 0.0
    @JsonProperty("morn")
    var morning: Double? = 0.0

}