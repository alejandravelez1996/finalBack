package com.example.finalBack.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalBack.modelos.Comercio;
import com.example.finalBack.modelos.utils.Estados;

@Repository
public interface IComercioRepositorio extends JpaRepository<Comercio, Integer>{

    // buscar por nombre
    List<Comercio> findByNombre(String nombre);

    // buscar por nombre que contenga texto
    List<Comercio> findByNombreContaining(String nombre);

    // buscar por estado
    List<Comercio> findByEstado(Estados estado);
}