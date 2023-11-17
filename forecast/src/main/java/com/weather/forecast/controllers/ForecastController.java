package com.weather.forecast.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.weather.forecast.services.ForecastService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
class ForecastController {
    private final ForecastService forecastService;
    @Autowired
    public ForecastController(ForecastService forecastService) {
        this.forecastService = forecastService;
    };
}
