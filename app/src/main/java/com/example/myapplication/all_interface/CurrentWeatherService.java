package com.example.myapplication.all_interface;

import com.example.myapplication.weather_api_dyanamic.current_weather.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CurrentWeatherService {
    @GET("")
 Call< WeatherResponse > getCurrentWeatherService();
}
