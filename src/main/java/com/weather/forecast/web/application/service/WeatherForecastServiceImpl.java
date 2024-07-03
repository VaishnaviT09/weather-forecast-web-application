//package com.weather.forecast.web.application.service;
//
//import com.weather.forecast.web.application.Dto.WeatherData;
//import com.weather.forecast.web.application.repository.WeatherServiceApi;
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.LinkedHashMap;
//
//@Service
//public class WeatherForecastServiceImpl {
//    @Autowired
//    WeatherServiceApi weatherServiceApi;
//    public LinkedHashMap getInfo(String city){
//       return weatherServiceApi.getWeatherInfo(city,"23b32dfa2f1040a345b53eb797075bfc");
//    }
//
////    public WeatherData getInfo(String city){
////        feign.Response response = weatherServiceApi.getWeatherInfo(city,"23b32dfa2f1040a345b53eb797075bfc");
////        JSONObject json = new JSONObject(response.body().toString());
////        return new WeatherData(json);
////    }
//}
