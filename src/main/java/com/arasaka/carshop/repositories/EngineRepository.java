package com.arasaka.carshop.repositories;

import com.arasaka.carshop.models.entities.Engine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineRepository extends JpaRepository<Engine, Long> {
    Engine findByEngineId(Long id);
}
