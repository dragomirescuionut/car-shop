package com.arasaka.carshop.controllers;

import com.arasaka.carshop.models.dtos.GearboxDTO;
import com.arasaka.carshop.services.GearboxService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gearboxes")
public class GearboxController {

    private final GearboxService gearboxService;

    public GearboxController(GearboxService gearboxService) {
        this.gearboxService = gearboxService;
    }

    @GetMapping
    public ResponseEntity<List<GearboxDTO>> getAllGearboxes() {
        return ResponseEntity.ok(gearboxService.getAllGearboxes());
    }

    @PostMapping
    public ResponseEntity<GearboxDTO> createGearbox(@RequestBody GearboxDTO gearboxDTO) {
        return ResponseEntity.ok(gearboxService.createGearbox(gearboxDTO));
    }
}
