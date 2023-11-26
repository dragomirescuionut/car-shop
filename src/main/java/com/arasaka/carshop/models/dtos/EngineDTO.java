package com.arasaka.carshop.models.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EngineDTO {

    private Long engineId;
    @Size(min = 3, max = 20, message = "Must be between 3 and 20 characters!")
    private String engineType;
    @Min(value = 1, message = "At least 1 horse power!")
    @Max(value = 1000, message = "Too many horses!")
    private Integer horsePower;
}