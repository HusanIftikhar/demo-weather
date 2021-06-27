package com.demo.assesment.demo.mapper;

import com.demo.assesment.demo.dto.WeatherDTO;

public interface ApiResponseMapper {

      WeatherDTO mapJsonToCurrentWeatherDTO(String jsonResponse);

}
