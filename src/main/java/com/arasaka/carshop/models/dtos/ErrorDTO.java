package com.arasaka.carshop.models.dtos;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ErrorDTO {

    private Map<String, String> message;
//    private String name;

    public ErrorDTO() {
        message = new HashMap<>();
    }
}
