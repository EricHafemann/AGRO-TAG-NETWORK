package com.agrotag.network.infrastructure.persistence.impl;

import com.agrotag.network.domain.entities.Usuario;
import com.agrotag.network.domain.repositories.UsuarioRepository;
import com.agrotag.network.infrastructure.persistence.jpa.SpringDataUsuarioRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private final SpringDataUsuarioRepository springDataRepository;

    public UsuarioRepositoryImpl(SpringDataUsuarioRepository springDataRepository) {
        this.springDataRepository = springDataRepository;
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return springDataRepository.findById(id);
    }

    @Override
    public Optional<Usuario> save(Usuario user) {
        return Optional.of(springDataRepository.save(user));
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
    public List<Usuario> findAll() {
        return springDataRepository.findAll();
    }

    @Override
    public Optional<Usuario> findByUsername(String username) {
        return springDataRepository.findByNome(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return springDataRepository.existsByNome(username);
    }

    @Override
    public List<Usuario> findAllWithTaskCount() {
        return springDataRepository.findAll();
    }
}