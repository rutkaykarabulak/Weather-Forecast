package com.weather.forecast.utils;

// This class is used to store constants.
public final class Constants {
    private Constants(){};

    public static final String API_KEY = "YOURAPIKEY";
    public static final String weatherForecastBaseURL = "https://api.openweathermap.org/data/3.0/onecall?";
    public static final String geoLocationBaseURL = "http://api.openweathermap.org/geo/1.0/direct?";

    public static final String apiExclude = "exclude=current,hourly,minutely";
    public static final String lat = "lat";
    public static final String lon = "lon";
    public static final String api = "appid";
    
}
