package com.weather.forecast.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.weather.forecast.models.responses.GeoLocationResponse;
import com.weather.forecast.models.responses.WeatherForecastResponse;
import com.weather.forecast.services.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ForecastController {
    private final ForecastService forecastService;
    @Autowired
    public ForecastController(ForecastService forecastService) {
        this.forecastService = forecastService;
    };

    @GetMapping("/forecast/{city}")
    public WeatherForecastResponse Get48HoursForecast(@PathVariable String city) {
        GeoLocationResponse response = forecastService.GetLonAndLatForCity(city);

        WeatherForecastResponse weather = forecastService.Get48HoursForecastByLatAndLon(response.getLat(), response.getLon());

        return weather;
    }
}
