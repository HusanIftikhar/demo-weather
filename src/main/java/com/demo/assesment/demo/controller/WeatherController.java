package com.demo.assesment.demo.controller;

import com.demo.assesment.demo.dto.ErrorDTO;
import com.demo.assesment.demo.services.WeatherService;

import com.demo.assesment.demo.util.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.WEATHER_BASE_API)
public class WeatherController {
    private final WeatherService weatherService;
    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping(value = ApiConstants.CURRENT_WEATHER_API)
    public ResponseEntity<?> getCurrentWeatherByLocation(@RequestParam("location") String location){
        try{
        return ResponseEntity.ok().body(weatherService.getWeatherByLocation(location));}
        catch(RuntimeException ex){
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorDTO(ex.getMessage(),400));
        }

    }


}
