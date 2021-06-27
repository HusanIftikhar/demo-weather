package com.demo.assesment.demo.mapper.impl;

import com.demo.assesment.demo.dto.WeatherDTO;
import com.demo.assesment.demo.mapper.ApiResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class OpenWeatherApiResponseMapper implements ApiResponseMapper {
    @Override
    public WeatherDTO mapJsonToCurrentWeatherDTO(String jsonResponse) {
        return null;
    }
}
