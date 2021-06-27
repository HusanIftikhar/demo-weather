package com.demo.assesment.demo.dao.impl;

import com.demo.assesment.demo.dao.RestServiceCall;
import org.springframework.stereotype.Service;

@Service
public class OpenWeatherApiCall implements RestServiceCall {
    @Override
    public String getCurrentWeatherData(String location) {
        return null;
    }
}
