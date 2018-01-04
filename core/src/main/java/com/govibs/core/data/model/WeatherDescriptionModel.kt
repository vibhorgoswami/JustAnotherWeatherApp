package com.govibs.core.data.model

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class WeatherDescriptionModel : Serializable {

    var id: Int? = 0
    var main: String? = ""
    var description: String? = ""
    var icon: String? = ""

}