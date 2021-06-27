package com.demo.assesment.demo.services;

import com.demo.assesment.demo.dao.IServiceCall;
import com.demo.assesment.demo.dao.RestServiceCall;
import com.demo.assesment.demo.dto.WeatherDTO;
import com.demo.assesment.demo.validators.RequestValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class WeatherServiceTest {
    @Autowired
    private WeatherService weatherService;
    @MockBean
    private RestServiceCall restServiceCall;
    @MockBean
    private RequestValidator requestValidator;
    @Test
    @DisplayName("Should return valid response if valid request")
    public void testCurrentWeatherShouldReturnValidResponseIfValidRequest(){


        doReturn(true).when(requestValidator).validateLocation("Berlin");
        doReturn("[{'temp':'100','pressure':'1005','weather':'name':'cloud'}]")
                .when(restServiceCall).getCurrentWeatherData("Berlin");
        WeatherDTO weatherDTO =weatherService.getWeatherByLocation("Berlin").orElseGet(()->new WeatherDTO());
        Assertions.assertAll(()->{
            Assertions.assertEquals(100,weatherDTO.getTemperature());
            Assertions.assertEquals(1005,weatherDTO.getPressure());
            Assertions.assertEquals(false, weatherDTO.isUmbrella());
        });
    }



}
