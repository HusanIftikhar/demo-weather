package com.demo.assesment.demo.integeration;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WeatherServiceClientTest {


    public WeatherServiceClient weatherServiceClient;
    @Test
    @DisplayName("Success when valid city and country id is provided ")
    public void shouldReturnValidResponseWithValidLocation(){

      String result =  weatherServiceClient.getCurrentWeatherByLocation("Berlin,DE");

        Assertions.assertAll(()-> {
            Assertions.assertNotNull(result);

        });

    }
}
