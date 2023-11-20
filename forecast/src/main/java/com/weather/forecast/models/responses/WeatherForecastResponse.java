package com.weather.forecast.models.responses;
import java.util.List;

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

    // Endregion

    public static class HourlyData {
        private long dt;
        private double temp;
        private double feels_like;
        private int pressure;
        private int humidity;
        private double dew_point;
        private double uvi;
        private int clouds;
        private int visibility;
        private double wind_speed;
        private int wind_deg;
        private double wind_gust;
        private List<Weather> weather;
        private double pop;

        // Region Getters and Setters

        public long getDt() {
            return dt;
        }

        public void setDt(long dt) {
            this.dt = dt;
        }

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public double getFeels_like() {
            return feels_like;
        }

        public void setFeels_like(double feels_like) {
            this.feels_like = feels_like;
        }

        public int getPressure() {
            return pressure;
        }

        public void setPressure(int pressure) {
            this.pressure = pressure;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public double getDew_point() {
            return dew_point;
        }

        public void setDew_point(double dew_point) {
            this.dew_point = dew_point;
        }

        public double getUvi() {
            return uvi;
        }

        public void setUvi(double uvi) {
            this.uvi = uvi;
        }

        public int getClouds() {
            return clouds;
        }

        public void setClouds(int clouds) {
            this.clouds = clouds;
        }

        public int getVisibility() {
            return visibility;
        }

        public void setVisibility(int visibility) {
            this.visibility = visibility;
        }

        public double getWind_speed() {
            return wind_speed;
        }

        public void setWind_speed(double wind_speed) {
            this.wind_speed = wind_speed;
        }

        public int getWind_deg() {
            return wind_deg;
        }

        public void setWind_deg(int wind_deg) {
            this.wind_deg = wind_deg;
        }

        public double getWind_gust() {
            return wind_gust;
        }

        public void setWind_gust(double wind_gust) {
            this.wind_gust = wind_gust;
        }

        public List<Weather> getWeather() {
            return weather;
        }

        public void setWeather(List<Weather> weather) {
            this.weather = weather;
        }

        public double getPop() {
            return pop;
        }

        public void setPop(double pop) {
            this.pop = pop;
        }
        // #endregion
    }

    public static class Weather {
        private int id;
        private String main;
        private String description;
        private String icon;

        // Region getters, and setters

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}
