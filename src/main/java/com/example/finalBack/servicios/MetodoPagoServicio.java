package com.example.finalBack.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalBack.modelos.MetodoPago;
import com.example.finalBack.modelos.utils.MetodoPagoEnum;
import com.example.finalBack.repositorios.IMetodoPagoRepositorio;

@Service
public class MetodoPagoServicio {

    @Autowired
    private IMetodoPagoRepositorio repositorio;

    // 1. guardar
    public MetodoPago guardar(MetodoPago metodoPago){
        return repositorio.save(metodoPago);
    }

    // 2. buscar todos
    public List<MetodoPago> buscarTodos(){
        return repositorio.findAll();
    }

    // 3. buscar por id
    public Optional<MetodoPago> buscarPorId(Integer id){
        return repositorio.findById(id);
    }

    // 4. buscr por atributo 
    public List<MetodoPago> buscarPorTipo(MetodoPagoEnum tipo){
        return repositorio.findByTipo(tipo);
    }

    // 5. editar
    public MetodoPago editar(Integer id, MetodoPago metodoPago){
        metodoPago.setId(id);
        return repositorio.save(metodoPago);
    }

    // 6. elimiinar 
    public void eliminar(Integer id){
        repositorio.deleteById(id);
    }
}