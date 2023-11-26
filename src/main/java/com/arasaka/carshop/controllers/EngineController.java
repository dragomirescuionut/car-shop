package com.arasaka.carshop.controllers;

import com.arasaka.carshop.exceptions.EngineNotFoundException;
import com.arasaka.carshop.models.dtos.EngineDTO;
import com.arasaka.carshop.services.EngineService;
import com.arasaka.carshop.services.EngineServiceImpl;
import jakarta.validation.Valid;
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
    public ResponseEntity<EngineDTO> createEngine(@Valid @RequestBody EngineDTO engineDTO) {
        return ResponseEntity.ok(engineService.createEngine(engineDTO));
    }

    @GetMapping
    public ResponseEntity<List<EngineDTO>> getAllEngines() {
        return ResponseEntity.ok(engineService.getAllEngines());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EngineDTO> getEngine(@PathVariable Long id) throws EngineNotFoundException {
        return ResponseEntity.ok(engineService.getEngine(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEngine(@PathVariable Long id) throws EngineNotFoundException {
        engineService.deleteEngine(id);
        return ResponseEntity.ok("User with id " + id + " deleted! ");
    }

    @PutMapping("/{id}")
    public ResponseEntity<EngineDTO> updateEngine(@PathVariable Long id, @Valid @RequestBody EngineDTO engineDTO) throws EngineNotFoundException {
        return ResponseEntity.ok(engineService.updateEngine(id, engineDTO));
    }
}