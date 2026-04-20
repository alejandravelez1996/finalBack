package com.example.finalBack.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalBack.modelos.Gasto;

@Repository
public interface IGastoRepositorio extends JpaRepository<Gasto, Integer> {

    // buscar por valor
    List<Gasto> findByMonto(double monto);
}
