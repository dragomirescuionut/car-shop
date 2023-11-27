package com.arasaka.carshop.services;

import com.arasaka.carshop.models.dtos.GearboxDTO;

import java.util.List;

public interface GearboxService {

    GearboxDTO createGearbox(GearboxDTO gearboxDTO);
    List<GearboxDTO> getAllGearboxes();
}
