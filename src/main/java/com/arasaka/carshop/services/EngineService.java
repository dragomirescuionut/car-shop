package com.arasaka.carshop.services;

import com.arasaka.carshop.exceptions.EngineNotFoundException;
import com.arasaka.carshop.models.dtos.EngineDTO;
import com.arasaka.carshop.models.entities.Engine;

import java.util.List;
import java.util.Map;

public interface EngineService {

    EngineDTO createEngine(EngineDTO engineDTO);

    List<EngineDTO> getAllEngines();

    EngineDTO getEngine(Long id) throws EngineNotFoundException;

    void deleteEngine(Long id) throws EngineNotFoundException;

    EngineDTO updateEngine(Long id, EngineDTO engineDTO) throws EngineNotFoundException;

    List<EngineDTO> getEnginesByHorsePowerGreaterThanEqual(int horsePower);

    List<EngineDTO> getEnginesByEngineType(String engineType);

    List<EngineDTO> getEnginesByMake(String make);

    List<EngineDTO> getCommonEngines(Map<String, String> params);
}