package com.weather.forecast.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ForecastNotFoundExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(ForecastNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String ForecastNotFoundHandler(ForecastNotFoundException e) {
        return e.getMessage();
    }
}
