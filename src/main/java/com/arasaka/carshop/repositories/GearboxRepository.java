package com.arasaka.carshop.repositories;

import com.arasaka.carshop.models.entities.Gearbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GearboxRepository extends JpaRepository<Gearbox, Long> {
}
