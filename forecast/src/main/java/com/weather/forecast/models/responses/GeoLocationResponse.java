package com.weather.forecast.models.responses;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

// This class represents the geo location response for one call 3.0 API.
public class GeoLocationResponse {
    // name of the city in geo response.
    private String name;
    // List of local names of the city in geo response.
    @JsonProperty("local_names")
    private Map<String, String> localNames;
    // Latitude of the city in geo response.
    private Double lat; 
    // Longitude of the city in geo response.
    private Double lon;
    // Countr of the city in geo response.
    private String country;

    // Region Getters and Setters
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getLocalNames() {
        return localNames;
    }

    public void setLocalNames(Map<String, String> localNames) {
        this.localNames = localNames;
    }    
    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
    // Endregion
}
