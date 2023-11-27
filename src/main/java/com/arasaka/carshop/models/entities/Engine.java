package com.arasaka.carshop.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "engines")
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long engineId;
    private String engineType;
    private Integer horsePower;
    private String make;
}