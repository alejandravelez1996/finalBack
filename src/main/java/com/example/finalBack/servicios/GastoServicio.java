package com.example.finalBack.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalBack.modelos.Gasto;
import com.example.finalBack.repositorios.IGastoRepositorio;

@Service
public class GastoServicio {
    
    @Autowired
    private IGastoRepositorio repositorio;

    // guardar
    public Gasto guardarGasto(Gasto gasto){
        return repositorio.save(gasto);
    }

    // listar
    public List<Gasto> listarGastos(){
        return repositorio.findAll();
    }

    // buscar por id
    public Optional<Gasto> buscarPorId(Integer id){
        return repositorio.findById(id);
    }

    // eliminar
    public void eliminarGasto(Integer id){
        repositorio.deleteById(id);
    }

    // actualizar
    public Gasto actualizarGasto(Integer id, Gasto gasto){
        gasto.setId(id);
        return repositorio.save(gasto);
    }
}