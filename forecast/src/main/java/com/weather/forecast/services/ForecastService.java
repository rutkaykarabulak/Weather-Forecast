package com.weather.forecast.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.weather.forecast.models.responses.GeoLocationResponse;
import com.weather.forecast.models.responses.WeatherForecastResponse;
import com.weather.forecast.utils.Constants;
import org.springframework.web.client.RestTemplate;

@Service
public class ForecastService  implements IForecastService{
    private final RestTemplate restTemplate;

    public ForecastService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    // Gets longitude and latitude for given city. 
    public GeoLocationResponse GetLonAndLatForCity(String city) {
        String apiUrl = Constants.geoLocationBaseURL + "&q=%s".formatted(city) + "&%s=%s".formatted(Constants.api, Constants.API_KEY);
        GeoLocationResponse geoResponse = null;
        ResponseEntity<GeoLocationResponse[]> responseEntity = restTemplate.getForEntity(apiUrl, GeoLocationResponse[].class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            GeoLocationResponse[] body = responseEntity.getBody();
            geoResponse = body[0];
        } 
        else {
        System.out.println("Failed to retrieve data.");
        }
        return geoResponse;
    }
    public WeatherForecastResponse Get48HoursForecastByLatAndLon(double lat, double lon) {
        String apiUrl = "";
        
        WeatherForecastResponse result = null;
        
        try {   
        ResponseEntity<WeatherForecastResponse> responseEntity = restTemplate.getForEntity(apiUrl, WeatherForecastResponse.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            result = responseEntity.getBody();
        }
        } catch (Exception e) {
            System.out.println("An error happened during getting 48 hours forecast.");
        }
        return result;
    }

}