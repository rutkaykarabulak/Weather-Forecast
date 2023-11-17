package com.weather.forecast.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
class ForecastController {
    private final String weatherForecastBaseURL = "https://api.openweathermap.org/data/3.0/onecall?";
    private final String geoLocationBaseURL = "http://api.openweathermap.org/geo/1.0/direct?";
    public ForecastController(){};
}
