package com.agrotag.network.domain.repositories;

import com.agrotag.network.domain.entities.Sensor;

import java.util.List;
import java.util.Optional;

public interface SensorRepository {

    Optional<Sensor> findById (Long id);
    Optional<Sensor> save(Sensor sensor);
    void update(Sensor sensor);
    void deleteById(Long id);
    boolean existsById(Long id);
    List<Sensor> findAll ();
    List<Sensor> findByUsuarioId (Long id);

}
