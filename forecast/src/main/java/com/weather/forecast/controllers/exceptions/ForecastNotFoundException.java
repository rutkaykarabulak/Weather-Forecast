package com.weather.forecast.controllers.exceptions;

public class ForecastNotFoundException extends RuntimeException {
    public ForecastNotFoundException(String city) {
        super("Couldn'get any forecast for the given city: " + city);
    }
}
