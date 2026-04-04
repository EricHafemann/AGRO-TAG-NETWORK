package com.agrotag.network.infrastructure.persistence.impl;

import com.agrotag.network.domain.entities.Sensor;
import com.agrotag.network.domain.repositories.SensorRepository;
import com.agrotag.network.infrastructure.persistence.jpa.SpringDataSensorRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SensorRepositoryImpl implements SensorRepository {

    private final SpringDataSensorRepository springDataRepository;

    public SensorRepositoryImpl(SpringDataSensorRepository springDataRepository) {
        this.springDataRepository = springDataRepository;
    }

    @Override
    public Optional<Sensor> findById(Long id) {
        return springDataRepository.findById(id);
    }

    @Override
    public Optional<Sensor> save(Sensor sensor) {
        return Optional.of(springDataRepository.save(sensor));
    }

    @Override
    public void update(Sensor sensor) {
        springDataRepository.save(sensor);
    }

    @Override
    public void deleteById(Long id) {
        springDataRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return springDataRepository.existsById(id);
    }

    @Override
    public List<Sensor> findAll() {
        return springDataRepository.findAll();
    }

    @Override
    public List<Sensor> findByUsuarioId(Long id) {
        return springDataRepository.findByUsuarioId(id);
    }
}