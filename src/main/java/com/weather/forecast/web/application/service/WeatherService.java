package com.weather.forecast.web.application.service;

import com.weather.forecast.web.application.Dto.WeatherData;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {
    private static final String API_KEY = "23b32dfa2f1040a345b53eb797075bfc";
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather";
    private static final String API_URL1="https://api.openweathermap.org/data/2.5/forecast";
    private static final String unit="&units=metric";
    private final OkHttpClient client;

    public WeatherService() {
        this.client = new OkHttpClient();
    }

    public WeatherData getWeather(String city) throws IOException {
        //String url = API_URL + "?q=" + city + "&appid=" + API_KEY;
        String url=  API_URL1 + "?q=" + city + "&appid=" + API_KEY +"&units=metric";
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            JSONObject json = new JSONObject(response.body().string());
            return new WeatherData(json);
        }
    }

}
