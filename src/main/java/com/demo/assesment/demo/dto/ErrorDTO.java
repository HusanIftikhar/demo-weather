package com.demo.assesment.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorDTO {
    private String message;
    private int statusCode;
}
