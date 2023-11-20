package com.weather.forecast.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.weather.forecast.models.responses.GeoLocationResponse;
import com.weather.forecast.models.responses.WeatherForecastResponse;
import com.weather.forecast.utils.Constants;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
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

        try {
            ResponseEntity<GeoLocationResponse[]> responseEntity = restTemplate.getForEntity(apiUrl, GeoLocationResponse[].class);
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                GeoLocationResponse[] body = responseEntity.getBody();
                if (body.length == 0) {
                    return null;
                }
                geoResponse = body[0];
            }
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            System.out.println("HTTP error occured");
        }
        
        return geoResponse;
    }
    public WeatherForecastResponse Get48HoursForecastByLatAndLon(double lat, double lon, String city) {
        String apiUrl = "";
        
        WeatherForecastResponse result = null;
        
        try {   
        ResponseEntity<WeatherForecastResponse> responseEntity = restTemplate.getForEntity(apiUrl, WeatherForecastResponse.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            result = responseEntity.getBody();
        }
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            System.out.println("HTTP error occured");
        }
        return result;
    }

}