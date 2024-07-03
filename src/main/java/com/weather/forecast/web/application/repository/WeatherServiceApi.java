//package com.weather.forecast.web.application.repository;
//
//import feign.Response;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.util.LinkedHashMap;
//
//@FeignClient(value = "weatherApi", url = "https://api.openweathermap.org/data/2.5")
//public interface WeatherServiceApi {
//
//    @GetMapping(value = "/weather?q={q}&appid={appid}")
//    LinkedHashMap getWeatherInfo(@PathVariable("q") String q, @PathVariable("appid") String appid);
//}
