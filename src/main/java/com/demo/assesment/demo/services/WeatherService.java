package com.demo.assesment.demo.services;

import com.demo.assesment.demo.dto.WeatherDTO;

import java.util.Optional;

public interface WeatherService {
    Optional<WeatherDTO> getWeatherByLocation(String location);
}
