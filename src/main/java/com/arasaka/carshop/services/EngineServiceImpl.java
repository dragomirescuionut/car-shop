package com.arasaka.carshop.services;

import com.arasaka.carshop.exceptions.EngineNotFoundException;
import com.arasaka.carshop.models.dtos.EngineDTO;
import com.arasaka.carshop.models.entities.Engine;
import com.arasaka.carshop.repositories.EngineRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EngineServiceImpl implements EngineService {

    private final ModelMapper modelMapper;
    private final EngineRepository engineRepository;

    public EngineServiceImpl(ModelMapper modelMapper, EngineRepository engineRepository) {
        this.modelMapper = modelMapper;
        this.engineRepository = engineRepository;
    }

    @Override
    public void deleteEngine(Long id) throws EngineNotFoundException {
        Engine engineEntity = engineRepository.findByEngineId(id);
        if (engineEntity == null) {
            log.error("Invalid engine id " + id);
            throw new EngineNotFoundException("Engine with id " + id + " not found!");
        }
        engineRepository.delete(engineEntity);
        log.info("Engine with id " + id + " deleted!");
    }

    @Override
    public EngineDTO getEngine(Long id) throws EngineNotFoundException {
        Engine engineEntity = engineRepository.findByEngineId(id);
        if (engineEntity == null) {
            log.error("Invalid engine id " + id);
            throw new EngineNotFoundException("Engine with id " + id + " not found!");
        }
        EngineDTO engineDTO = modelMapper.map(engineEntity, EngineDTO.class);

        return engineDTO;
    }

    @Override
    public EngineDTO createEngine(EngineDTO engineDTO) {
        Engine engineEntity = new Engine();
        engineEntity.setEngineType(engineDTO.getEngineType());
        engineEntity.setHorsePower(engineDTO.getHorsePower());

        Engine savedEngine = engineRepository.save(engineEntity);

        EngineDTO responseDTO = new EngineDTO();
        responseDTO.setEngineType(savedEngine.getEngineType());
        responseDTO.setHorsePower(savedEngine.getHorsePower());

        return responseDTO;
    }

    @Override
    public List<EngineDTO> getAllEngines() {
        List<Engine> engineList = engineRepository.findAll();
        List<EngineDTO> engineDTOList = new ArrayList<>();
        for (Engine engine : engineList) {
            engineDTOList.add(modelMapper.map(engine, EngineDTO.class));
        }
        return engineDTOList;
    }
}