package com.weather.forecast.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.RestController;

import com.weather.forecast.controllers.exceptions.CityNotFoundException;
import com.weather.forecast.controllers.exceptions.ForecastNotFoundException;
import com.weather.forecast.models.entities.ForecastEntity;
import com.weather.forecast.models.responses.GeoLocationResponse;
import com.weather.forecast.models.responses.WeatherForecastResponse;
import com.weather.forecast.services.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

@RestController
public class ForecastController {
    private final ForecastService forecastService;
    @Autowired
    public ForecastController(ForecastService forecastService) {
        this.forecastService = forecastService;
    };

    @GetMapping("/forecast/{city}")
    public ResponseEntity<EntityModel<ForecastEntity>> get48HoursForecast(@PathVariable String city) {
        GeoLocationResponse response = forecastService.GetLonAndLatForCity(city);
        if (response == null) {
            throw new CityNotFoundException(city);
        }
        WeatherForecastResponse weather = forecastService.Get48HoursForecastByLatAndLon(response.getLat(), response.getLon(), city);
        if (weather == null) {
            throw new ForecastNotFoundException(city);
        }
        ForecastEntity entity = new ForecastEntity(weather);

        return ResponseEntity.ok(EntityModel.of(entity, 
        linkTo(methodOn(ForecastController.class).get48HoursForecast(city)).withSelfRel()));
    }
}
