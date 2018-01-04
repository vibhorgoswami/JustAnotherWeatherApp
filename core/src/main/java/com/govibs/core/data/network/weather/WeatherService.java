package com.govibs.core.data.network.weather;

import com.govibs.core.data.model.WeatherBaseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {

    @GET("forecast/daily")
    Call<WeatherBaseModel> getDailyWeatherForLocationByPostalCode(@Query("q") String q,
                                                                  @Query("cnt") int cnt,
                                                                  @Query("units") String units,
                                                                  @Query("mode") String mode,
                                                                  @Query("APPID") String APPID);
}
