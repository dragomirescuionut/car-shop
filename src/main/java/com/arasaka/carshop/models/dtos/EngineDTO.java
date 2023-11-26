package com.arasaka.carshop.models.dtos;

import lombok.Data;

@Data
public class EngineDTO {

    private Long engineId;
    private String engineType;
    private Integer horsePower;
}