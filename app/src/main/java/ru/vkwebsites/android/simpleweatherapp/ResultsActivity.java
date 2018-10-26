package ru.vkwebsites.android.simpleweatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {

    private TextView weatherInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        initViews();
        setWeatherInfo();
    }

    private void setWeatherInfo() {
        weatherInfo.setText(buildWeatherInfo());
    }

    private String buildWeatherInfo() {
        ArrayList<String> options = new ArrayList<>();
        String city = getIntent().getStringExtra(MainActivity.inputCity);

        boolean isWeatherText = getIntent().getBooleanExtra(MainActivity.swWeatherText, false);
        boolean isHumidity = getIntent().getBooleanExtra(MainActivity.swHumidity, false);

        if (isWeatherText) options.add(MainActivity.swWeatherText);
        if (isHumidity) options.add(MainActivity.swHumidity);

        String info = new WeatherData().getWeatherByCity(city, options);
        if (info.isEmpty()) {
            return getResources().getString(R.string.err_no_city);
        }
        return info;
    }

    private void initViews() {
        weatherInfo = findViewById(R.id.weatherInfo);
    }
}
