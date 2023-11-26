package com.arasaka.carshop.services;

import com.arasaka.carshop.models.dtos.EngineDTO;

import java.util.List;

public interface EngineService {

    EngineDTO createEngine(EngineDTO engineDTO);
    List<EngineDTO> getAllEngines();
}