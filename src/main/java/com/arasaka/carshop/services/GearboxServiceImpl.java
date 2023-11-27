package com.arasaka.carshop.services;

import com.arasaka.carshop.models.dtos.GearboxDTO;
import com.arasaka.carshop.models.entities.Gearbox;
import com.arasaka.carshop.repositories.GearboxRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GearboxServiceImpl implements GearboxService {
    private final GearboxRepository gearboxRepository;
    private final ModelMapper modelMapper;

    public GearboxServiceImpl(GearboxRepository gearboxRepository, ModelMapper modelMapper) {
        this.gearboxRepository = gearboxRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public GearboxDTO createGearbox(GearboxDTO gearboxDTO) {
        Gearbox gearboxEntity = new Gearbox();
        gearboxEntity.setGearboxType(gearboxDTO.getGearboxType());

        Gearbox savedGearbox = gearboxRepository.save(gearboxEntity);

        GearboxDTO responseDTO = new GearboxDTO();
        responseDTO.setGearboxType(savedGearbox.getGearboxType());

        return responseDTO;
    }

    @Override
    public List<GearboxDTO> getAllGearboxes() {
        List<Gearbox> gearboxList = gearboxRepository.findAll();
        List<GearboxDTO> gearboxDTOList = new ArrayList<>();
        gearboxList.stream()
                .forEach(element -> gearboxDTOList.add(modelMapper.map(element, GearboxDTO.class)));
        return gearboxDTOList;
    }
}
