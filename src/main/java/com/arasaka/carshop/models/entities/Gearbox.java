package com.arasaka.carshop.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "gearboxes")
public class Gearbox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gearboxId;
    private String gearboxType;

}