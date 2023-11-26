package com.arasaka.carshop.services;

import com.arasaka.carshop.exceptions.EngineNotFoundException;
import com.arasaka.carshop.models.dtos.EngineDTO;

import java.util.List;

public interface EngineService {

    EngineDTO createEngine(EngineDTO engineDTO);

    List<EngineDTO> getAllEngines();

    EngineDTO getEngine(Long id) throws EngineNotFoundException;

    void deleteEngine(Long id) throws EngineNotFoundException;
}