package com.weather.forecast.models.entities;

import java.util.List;
import java.util.Objects;

import com.weather.forecast.models.responses.WeatherForecastResponse;

// Entity that consists of 48 hours weather forecast and following informations such as maximum, feels like temperatures, humidity.
public class ForecastEntity {
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

    // Default constructor
    public ForecastEntity() {}
    // Parameterized constructor
    public ForecastEntity(WeatherForecastResponse weatherForecastResponse) {
        setLat(weatherForecastResponse.getLat());
        setLon(weatherForecastResponse.getLon());
        setHourly(weatherForecastResponse.getHourly());
        setTimezone(weatherForecastResponse.getTimezone());
        setTimezone_offset(weatherForecastResponse.getTimezone_offset());
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ForecastEntity)) {
            return false;
        }
        ForecastEntity forecastEntity = (ForecastEntity) o;
        return Objects.equals(this.lat, forecastEntity.lat) && Objects.equals(this.lon, forecastEntity.lon)
        && Objects.equals(this.hourly, forecastEntity.hourly) && Objects.equals(this.timezone, forecastEntity.timezone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.lat, this.lon, this.hourly, this.timezone, this.timezone_offset);
    }

    @Override
    public String toString() {
        return "ForecastEntity{" + "lat=" + this.lat + ", lon= " +this.lon + ", hourly=" + this.hourly + ", timezone= " + this.timezone
        + ", timezone_offset= " + this.timezone_offset;
    }

}
