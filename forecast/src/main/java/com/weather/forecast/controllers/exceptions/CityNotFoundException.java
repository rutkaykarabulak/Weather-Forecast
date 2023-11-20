package com.weather.forecast.controllers.exceptions;

public class CityNotFoundException extends RuntimeException{
    public CityNotFoundException(String city) {
        super("Couldn't find any longitude and lantitude data for the given city: " + city);
    }
}
