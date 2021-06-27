package com.demo.assesment.demo.services.impl;

import com.demo.assesment.demo.dao.RestServiceCall;
import com.demo.assesment.demo.dto.WeatherDTO;
import com.demo.assesment.demo.mapper.ApiResponseMapper;
import com.demo.assesment.demo.services.IWeatherService;
import com.demo.assesment.demo.services.WeatherService;
import com.demo.assesment.demo.validators.RequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private RestServiceCall restServiceCall;
    @Autowired
    private ApiResponseMapper apiResponseMapper;
    @Override
    public Optional<WeatherDTO> getWeatherByLocation(String location) {
       String jsonData =restServiceCall.getCurrentWeatherData(location);
     return Optional.of(apiResponseMapper.mapJsonToCurrentWeatherDTO(jsonData));

    }
}
