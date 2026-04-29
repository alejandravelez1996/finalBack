package com.example.finalBack.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalBack.modelos.Categoria;

@Repository
public interface ICategoriaRepositorio extends JpaRepository<Categoria, Integer> {

    // buscar por nombre
    List<Categoria> findByNombre(String nombre);

    // buscar por tipo
    List<Categoria> findByTipo(String tipo);

    // buscar por nombre que contenga algo
    List<Categoria> findByNombreContaining(String nombre);
}