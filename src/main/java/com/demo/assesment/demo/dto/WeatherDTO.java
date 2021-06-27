package com.demo.assesment.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class WeatherDTO {

    private int temperature;
    private int pressure;
    private boolean umbrella;
}
