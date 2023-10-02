package com.example.exempleappinfotempsretrofitnobloqueig;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    @GET("weather")
    Call<WeatherResponse> getWeather(
            @Query("q") String location, // Ciudad o coordenadas geográficas
            @Query("appid") String apiKey // Tu clave de API de OpenWeatherMap
    );
}
