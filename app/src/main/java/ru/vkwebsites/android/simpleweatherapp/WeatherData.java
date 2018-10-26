package ru.vkwebsites.android.simpleweatherapp;

import java.util.ArrayList;
import java.util.HashMap;

class WeatherData {
    private HashMap<String, String[]> data = new HashMap<>();

    WeatherData() {
        data.put("санкт-петербург", new String[] {"Санкт-Петербург, +16.4", "Ясно", "63%"});
        data.put("москва", new String[] {"Москва, +18.4", "Ясно", "54%"});
        data.put("екатеринбург", new String[] {"Екатеринбург, +1.2", "Пасмурно", "67%"});
    }

    String getWeatherByCity(String city, ArrayList<String> options) {
        String info = "";
        city = city.toLowerCase();

        if (!data.containsKey(city)) {
            return info;
        }

        if (options.isEmpty()) return data.get(city)[0];

        if (options.indexOf(MainActivity.swWeatherText) > -1) info += ", " + data.get(city)[1];

        if (options.indexOf(MainActivity.swHumidity) > -1) info += ", " + data.get(city)[2];

        return data.get(city)[0] + info;

    }
}
