package com.arasaka.carshop.models.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class GearboxDTO {

    private Long gearboxId;
    @Size(min = 3, max = 20, message = "Must be between 3 and 20 characters!")
    private String gearboxType;
}