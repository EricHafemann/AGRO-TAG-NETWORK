package com.agrotag.network.domain.repositories;



import com.agrotag.network.domain.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {

    Optional<Usuario> findById(Long id);
    Optional<Usuario> save(Usuario user);
    void deleteById(Long id);
    boolean existsById(Long id);
    List<Usuario> findAll();
    Optional<Usuario> findByUsername(String username);
    boolean existsByUsername(String username);
    List<Usuario> findAllWithTaskCount();
}