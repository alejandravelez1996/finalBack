package com.example.finalBack.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalBack.modelos.MetodoPago;
import com.example.finalBack.modelos.utils.MetodoPagoEnum;
import com.example.finalBack.modelos.utils.Estados;

@Repository
public interface IMetodoPagoRepositorio extends JpaRepository<MetodoPago, Integer> {

    // buscar por tipo (enum)
    List<MetodoPago> findByTipo(MetodoPagoEnum tipo);

    // buscar por estado
    List<MetodoPago> findByEstado(Estados estado);

    // buscar por descripcion (contenga texto)
    List<MetodoPago> findByDescripcionContaining(String descripcion);

    // buscar por usuario (por id)
    List<MetodoPago> findByUsuarioId(Integer usuarioId);
}
