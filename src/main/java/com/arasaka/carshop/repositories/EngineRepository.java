package com.arasaka.carshop.repositories;

import com.arasaka.carshop.models.entities.Engine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EngineRepository extends JpaRepository<Engine, Long> {
    Engine findByEngineId(Long id);
    List<Engine> findByHorsePowerGreaterThanEqual(int horsePower);
    List<Engine> findByMake(String make);
    List<Engine> findByEngineType(String engineType);
}