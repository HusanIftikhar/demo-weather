package com.demo.assesment.demo.controller;

import com.demo.assesment.demo.dto.WeatherDTO;
import com.demo.assesment.demo.services.WeatherService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.hamcrest.Matchers.*;

import java.util.Optional;
import java.util.concurrent.TimeoutException;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WeatherControllerTest {
    @MockBean
    private WeatherService weatherService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should return success when correct city name provided")
    public void testWeatherByLocationSuccess() throws Exception {
        WeatherDTO weatherDTO = new WeatherDTO(100,1005,false);
        doReturn(Optional.of(weatherDTO)).when(weatherService).getWeatherByLocation("Berlin,DE");
         mockMvc.perform(get("/weather/current?location=Berlin,DE"))
               .andExpect(status().isOk())
                 .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                 .andExpect(jsonPath("$.pressure",is(1005)))
                 .andExpect( jsonPath("$.temperature",is(100)))
                 .andExpect(jsonPath("$.umbrella",is(false)));
    }

    @Test
    @DisplayName("Should return fail when incorrect city name provided")
    public void testWeatherByLocationFailure() throws Exception {
        doThrow(new RuntimeException("Invalid request")).when(weatherService).getWeatherByLocation("FgBwer,PK");
        mockMvc.perform(get("/weather/current?location=FgBwer,PK"))
                .andExpect(status().isNotFound()).andExpect(jsonPath("$.message",is("Invalid request")))
                .andExpect(jsonPath("$.statusCode",is(400)));
    }

    @Test
    @DisplayName("Should return fail when city name is empty")
    public void testShouldFailWhenLocationIsEmpty() throws Exception {
        doThrow(new RuntimeException("Invalid request")).when(weatherService).getWeatherByLocation("");
        mockMvc.perform(get("/weather/current?location="))
                .andExpect(status().isNotFound()).andExpect(jsonPath("$.message",is("Invalid request")))
                .andExpect(jsonPath("$.statusCode",is(400)));


    }



}
