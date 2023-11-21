package com.weather.forecast;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.weather.forecast.controllers.ForecastController;
import com.weather.forecast.controllers.exceptions.CityNotFoundException;
import com.weather.forecast.controllers.exceptions.ForecastNotFoundException;
import com.weather.forecast.models.entities.ForecastEntity;
import com.weather.forecast.models.responses.WeatherForecastResponse;
import com.weather.forecast.services.ForecastService;

import org.springframework.hateoas.EntityModel;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class ForecastControllerTests {

    @Mock
    private ForecastService forecastService;

    @InjectMocks
    private ForecastController forecastController;

    @Test
    public void testGet48HoursForecast_Success() {
        // Mocking
        when(forecastService.Get48HoursForecastByLatAndLon(anyDouble(), anyDouble(), "Istanbul")).thenReturn(new WeatherForecastResponse());

        // Test
        ResponseEntity<EntityModel<ForecastEntity>> responseEntity = forecastController.get48HoursForecast("Istanbul");

        // Assertions
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        // Add more assertions based on your specific requirements
    }

    @Test
    public void testGet48HoursForecast_CityNotFound() {
        // Mocking
        when(forecastService.GetLonAndLatForCity(anyString())).thenReturn(null);

        // Test
        assertThrows(CityNotFoundException.class, () -> forecastController.get48HoursForecast("nonExistingCity"));
    }

        @Test
    public void testGet48HoursForecast_ForecastNotFound() {
        // Mocking
        when(forecastService.Get48HoursForecastByLatAndLon(anyDouble(), anyDouble(), anyString())).thenReturn(null);

        // Test
        assertThrows(ForecastNotFoundException.class, () -> forecastController.get48HoursForecast("Istanbul"));
    }
}