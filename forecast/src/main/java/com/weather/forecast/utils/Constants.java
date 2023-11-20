package com.weather.forecast.utils;

import java.util.Map;
import java.util.StringJoiner;

// This class is used to store constants.
public final class Constants {
    private Constants(){};

    public static final String API_KEY = "YOURAPIKEY";
    public static final String weatherForecastBaseURL = "https://api.openweathermap.org/data/3.0/onecall?";
    public static final String geoLocationBaseURL = "http://api.openweathermap.org/geo/1.0/direct?";

    public static final String apiExclude = "current,daily,minutely";
    public static final String exclude = "exclude";
    public static final String lat = "lat";
    public static final String lon = "lon";
    public static final String api = "appid";

    public static String buildApiUrl(String baseUrl, Map<String, String> parameters) {
        StringJoiner joiner = new StringJoiner("&");
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            joiner.add(entry.getKey() + "=" + entry.getValue());
        }
        
        return baseUrl + joiner.toString();
    }
}
