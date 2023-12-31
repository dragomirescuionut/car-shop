package com.arasaka.carshop.services;

import com.arasaka.carshop.exceptions.EngineNotFoundException;
import com.arasaka.carshop.models.dtos.EngineDTO;
import com.arasaka.carshop.models.entities.Engine;
import com.arasaka.carshop.repositories.EngineRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public EngineDTO updateEngine(Long id, EngineDTO engineDTO) throws EngineNotFoundException {
        Engine engineEntity = engineRepository.findByEngineId(id);
        if (engineEntity == null) {
            log.error("Invalid engine id " + id);
            throw new EngineNotFoundException("Engine with id " + id + " not found!");
        }
        updateEntity(engineEntity, engineDTO);
        Engine updatedEngine = engineRepository.save(engineEntity);
        EngineDTO updatedEngineDTO = modelMapper.map(updatedEngine, EngineDTO.class);

        return updatedEngineDTO;
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
        engineEntity.setMake(engineDTO.getMake());

        Engine savedEngine = engineRepository.save(engineEntity);

        EngineDTO responseDTO = new EngineDTO();
        responseDTO.setEngineType(savedEngine.getEngineType());
        responseDTO.setHorsePower(savedEngine.getHorsePower());
        responseDTO.setMake(savedEngine.getMake());

        return responseDTO;
    }

    @Override
    public List<EngineDTO> getAllEngines() {
        List<Engine> engineList = engineRepository.findAll();
        List<EngineDTO> engineDTOList2 = new ArrayList<>();
        engineList.stream()
                .forEach(element -> engineDTOList2.add(modelMapper.map(element, EngineDTO.class)));

        return engineDTOList2;
    }

    @Override
    public List<EngineDTO> getEnginesByHorsePowerGreaterThanEqual(int horsePower) {
        return engineRepository.findByHorsePowerGreaterThanEqual(horsePower).stream()
                .map(element -> modelMapper.map(element, EngineDTO.class))
                .toList();
    }

    @Override
    public List<EngineDTO> getEnginesByMake(String make) {
        return engineRepository.findByMake(make).stream()
                .map(element -> modelMapper.map(element, EngineDTO.class))
                .toList();
    }

    @Override
    public List<EngineDTO> getEnginesByEngineType(String engineType) {
        return engineRepository.findByEngineType(engineType).stream()
                .map(element -> modelMapper.map(element, EngineDTO.class))
                .toList();
    }

    @Override
    public List<EngineDTO> getCommonEngines(Map<String, String> params) {
        List<List<EngineDTO>> resultList = new ArrayList<>();

        for (String keyParam : params.keySet()) {
            if (keyParam.equals("engineType")) {
                resultList.add(getEnginesByEngineType(params.get(keyParam)));
            }
            if (keyParam.equals("make")) {
                resultList.add(getEnginesByMake(params.get(keyParam)));
            }
            if (keyParam.equals("horsePower")) {
                resultList.add(getEnginesByHorsePowerGreaterThanEqual(Integer.valueOf(params.get(keyParam))));
            }
        }

        List<EngineDTO> result = new ArrayList<>(resultList.get(0));

        for (List<EngineDTO> list : resultList) {
            result.retainAll(list);
        }

        return result;
    }

    private void updateEntity(Engine engine, EngineDTO engineDTO) {
        engine.setHorsePower(engineDTO.getHorsePower());
        engine.setEngineType(engineDTO.getEngineType());
        engine.setMake(engineDTO.getMake());
    }
}