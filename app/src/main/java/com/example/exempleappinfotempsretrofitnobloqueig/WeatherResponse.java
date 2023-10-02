package com.example.exempleappinfotempsretrofitnobloqueig;

import com.google.gson.annotations.SerializedName;

public class WeatherResponse {
    @SerializedName("main")
    private WeatherMainInfo main;

    public WeatherMainInfo getMain() {
        return main;
    }

    public class WeatherMainInfo {
        @SerializedName("temp")
        private double temperature;

        public double getTemperature() {
            return temperature;
        }
    }

}
