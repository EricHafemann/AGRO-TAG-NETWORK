package com.agrotag.network.infrastructure.persistence.jpa;

import com.agrotag.network.domain.entities.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataSensorRepository extends JpaRepository<Sensor, Long> {
    List<Sensor> findByUsuarioId(Long id);
}

