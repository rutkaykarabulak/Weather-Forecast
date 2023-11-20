package com.weather.forecast.services;

import com.weather.forecast.models.responses.GeoLocationResponse;
import com.weather.forecast.models.responses.WeatherForecastResponse;

public interface IForecastService {
    // Gets the longitude and latitude for the given city.
    public GeoLocationResponse GetLonAndLatForCity(String city);
    // Gets 48 hours forecast for the given city(city means the city in these latitude and longitude)
    public WeatherForecastResponse Get48HoursForecastByLatAndLon(double lat, double lon, String city);
}
