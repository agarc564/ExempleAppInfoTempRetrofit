package com.example.exempleappinfotempsretrofitnobloqueig;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/"; //URL base de l'app d'OpenWeather
    private static final String API_KEY = "fe0a843a5afb9263e58ee4ca060273f5"; // Reemplaça amb la teva Key de OpenWeather

    private TextView temperatureTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obté l'id del textView on es mostrarà la temperatura
        temperatureTextView = findViewById(R.id.temperatureTextView);

        // Configurar Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Crear una instància de la interfície de l'API
        WeatherApi weatherApi = retrofit.create(WeatherApi.class);

        // Realitza la solicitud a la API
        Call<WeatherResponse> call = weatherApi.getWeather("Barcelona", API_KEY);
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.isSuccessful()) {
                    WeatherResponse weatherResponse = response.body();
                    if (weatherResponse != null) {
                        double temperature = weatherResponse.getMain().getTemperature();
                        temperatureTextView.setText(String.format("%.1f°C", temperature));
                    }
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                // Aquí es gestionen els errors de connexió o errors de Retrofit
                // Pots mostrar un missatge d'error o fer accions apropiades
            }
        });
    }
}