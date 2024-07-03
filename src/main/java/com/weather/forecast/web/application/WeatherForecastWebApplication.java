package com.weather.forecast.web.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.weather.forecast.web.application.controller","com.weather.forecast.web.application.service"})
public class WeatherForecastWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherForecastWebApplication.class, args);
	}

}
