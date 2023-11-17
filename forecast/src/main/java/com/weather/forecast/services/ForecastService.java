package com.weather.forecast.services;

import org.springframework.stereotype.Service;
import com.weather.forecast.models.GeoLocationResponse;
import com.weather.forecast.utils.Constants;

import org.springframework.web.client.RestTemplate;

@Service
public class ForecastService {
    private final RestTemplate restTemplate;

    public ForecastService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    // Gets longitude and latitude for given city. 
    public GeoLocationResponse GetLonAndLatForCity(String city) {
        String apiUrl = Constants.geoLocationBaseURL + "&q=%s".formatted(city) + "&appid=%s".formatted(Constants.API_KEY);

        GeoLocationResponse response = restTemplate.getForObject(apiUrl, GeoLocationResponse.class);

        return response;
    }
}
