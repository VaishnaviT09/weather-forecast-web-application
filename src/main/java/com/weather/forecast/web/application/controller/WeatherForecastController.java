package com.weather.forecast.web.application.controller;

import com.weather.forecast.web.application.Dto.WeatherData;
import com.weather.forecast.web.application.service.WeatherService;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

@Controller
public class WeatherForecastController {
    @Autowired
    private WeatherService weatherService;

    private Map<String, List<Double>> cityWeatherData = new HashMap<>();

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("cities", cityWeatherData.keySet());
        return "index";
    }

    @PostMapping("/addCity")
    public String addCity(@RequestParam String city, Model model) {
        try {
            WeatherData weatherData = weatherService.getWeather(city);

            List<Double> temp = weatherData.getTempData();
            cityWeatherData.put(city, temp);
        } catch (IOException e) {
            model.addAttribute("error", "Error fetching weather data for " + city);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/";
    }

    @PostMapping("/removeCity")
    public String removeCity(@RequestParam String city) {
        cityWeatherData.remove(city);
        return "redirect:/";
    }

    @GetMapping("/multiData")
    @ResponseBody
    public ResponseEntity<?> getMultipleData() {

        Map<String, List<Double>> result = new HashMap<>();
        JsonArray jsonTemp = new JsonArray();
        JsonArray jsonDate = new JsonArray();
        JsonObject jsonObject = new JsonObject();

        for (Map.Entry<String, List<Double>> entry : cityWeatherData.entrySet()) {

            List<Double> temperature = new ArrayList<>();
            for (Double innerEntry : entry.getValue()) {
                temperature.add(innerEntry);
            }
            result.put(entry.getKey(), temperature);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
