package com.arasaka.carshop.controllers;

import com.arasaka.carshop.models.dtos.EngineDTO;
import com.arasaka.carshop.services.EngineService;
import com.arasaka.carshop.services.EngineServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/engines")
public class EngineController {

    private final EngineService engineService;

    public EngineController(EngineService engineService) {
        this.engineService = engineService;
    }

    @PostMapping
    public ResponseEntity<EngineDTO> createEngine(@RequestBody EngineDTO engineDTO) {
        return ResponseEntity.ok(engineService.createEngine(engineDTO));
    }

    @GetMapping
    public ResponseEntity<List<EngineDTO>> getAllEngines(){
        return ResponseEntity.ok(engineService.getAllEngines());
    }
}
