package com.weather.forecast.models.responses;
import java.util.List;
import com.weather.forecast.models.entities.HourlyData;

public class WeatherForecastResponse {
    // Latitude of the given city.
    private double lat;
    // Longitude of the given city.
    private double lon;
    // Time zone of the given city
    private String timezone;
    // Time zone offset of te given city
    private int timezone_offset;
    // Hourly data for the given city.
    private List<HourlyData> hourly;

    // Region Getters and Setters

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getTimezone_offset() {
        return timezone_offset;
    }

    public void setTimezone_offset(int timezone_offset) {
        this.timezone_offset = timezone_offset;
    }

    public List<HourlyData> getHourly() {
        return hourly;
    }

    public void setHourly(List<HourlyData> hourly) {
        this.hourly = hourly;
    }

    //#endregion
}
