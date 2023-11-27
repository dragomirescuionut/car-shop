package com.arasaka.carshop.controllers;

import com.arasaka.carshop.exceptions.EngineNotFoundException;
import com.arasaka.carshop.models.dtos.EngineDTO;
import com.arasaka.carshop.services.EngineService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/filter")
    public ResponseEntity<List<EngineDTO>> getEnginesByHorsePowerGreaterThanEqual(@RequestParam Map<String, String> params) {
        List<EngineDTO> resultList = engineService.getCommonEngines(params);
        return ResponseEntity.ok(resultList);
    }

//    @GetMapping("/filter")
//    public ResponseEntity<List<EngineDTO>> getEnginesByHorsePowerGreaterThanEqual(@RequestParam int horsePower, @RequestParam String make) {
//        List<EngineDTO> horseList = engineService.getEnginesByHorsePowerGreaterThanEqual(horsePower);
//        List<EngineDTO> makeList = engineService.getEnginesByMake(make);
//        List<EngineDTO> resultList = engineService.getCommonEngines(horseList, makeList);
//        return ResponseEntity.ok(resultList);
//    }
}