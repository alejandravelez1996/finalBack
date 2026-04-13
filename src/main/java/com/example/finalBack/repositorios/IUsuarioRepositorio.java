package com.example.finalBack.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalBack.modelos.Usuario;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario,Integer> {

    // buscar por nombre
    List<Usuario> findByNombre(String nombre);

    // buscar por documento
    Optional<Usuario> findByDocumento(String documento);

    // buscar por nombre que contenga algo
    List<Usuario> findByNombreContaining(String nombre);
}
