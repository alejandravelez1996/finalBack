package com.example.finalBack.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.finalBack.modelos.Categoria;
import com.example.finalBack.repositorios.ICategoriaRepositorio;

@Service
public class CategoriaServicio {

    @Autowired
    private ICategoriaRepositorio repositorio;

    // guardar
    public Categoria guardarCategoria(Categoria categoria){

        // VALIDACION DE NOMBRE
        if(categoria.getNombre() == null || categoria.getNombre().isBlank()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre de la categoría es obligatorio"
            );
        }

        // VALIDACION DE PRESUPUESTO
        if(categoria.getPresupuestoLimite() <= 0){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El presupuesto debe ser mayor a 0"
            );
        }

        // VALIDACION DE RESPONSABLE
        if(categoria.getResponsable() == null || categoria.getResponsable().isBlank()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El responsable es obligatorio"
            );
        }

        return repositorio.save(categoria);
    }

    // listar todos
    public List<Categoria> listarCategorias(){
        return repositorio.findAll();
    }

    // buscar por id
    public Optional<Categoria> buscarPorId(Integer id){
        return repositorio.findById(id);
    }

    // eliminar
    public void eliminarCategoria(Integer id){
        repositorio.deleteById(id);
    }

    // actualizar
    public Categoria actualizarCategoria(Integer id, Categoria categoria){
        categoria.setId(id);
        return repositorio.save(categoria);
    }
}