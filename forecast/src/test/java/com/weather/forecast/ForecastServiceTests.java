package com.weather.forecast;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.weather.forecast.models.responses.GeoLocationResponse;
import com.weather.forecast.models.responses.WeatherForecastResponse;
import com.weather.forecast.services.ForecastService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class ForecastServiceTests {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ForecastService forecastService;

    @Test
    public void testGetLonAndLatForCity_NoResults() {
        // Mocking
        when(restTemplate.getForEntity(anyString(), eq(GeoLocationResponse[].class)))
                .thenReturn(new ResponseEntity<>(new GeoLocationResponse[0], HttpStatus.OK));

        // Test
        GeoLocationResponse response = forecastService.GetLonAndLatForCity("nonExistingCity");

        // Assertions
        assertNull(response);
    }

    @Test
    public void testGet48HoursForecastByLatAndLon_Success() {
        // Mocking
        when(restTemplate.getForEntity(anyString(), eq(WeatherForecastResponse.class)))
                .thenReturn(new ResponseEntity<>(new WeatherForecastResponse(), HttpStatus.OK));

        // Test
        WeatherForecastResponse response = forecastService.Get48HoursForecastByLatAndLon(10.0, 20.0, "Istanbul");

        // Assertions
        // Add more assertions based on your specific requirements
    }

    @Test
    public void testGet48HoursForecastByLatAndLon_Error() {
        // Mocking
        when(restTemplate.getForEntity(anyString(), eq(WeatherForecastResponse.class)))
                .thenThrow(new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR));

        // Test
        WeatherForecastResponse response = forecastService.Get48HoursForecastByLatAndLon(10.0, 20.0, "Istanbul");

        // Assertions
        assertNull(response);
    }
}

