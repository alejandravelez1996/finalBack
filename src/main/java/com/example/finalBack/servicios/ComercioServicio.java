package com.example.finalBack.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.finalBack.modelos.Comercio;
import com.example.finalBack.repositorios.IComercioRepositorio;

@Service
public class ComercioServicio {

    @Autowired
    private IComercioRepositorio repositorio;

    // GUARDAR
    public Comercio guardarComercio(Comercio comercio){

        // VALIDAR NOMBRE
        if(comercio.getNombre() == null || comercio.getNombre().isBlank()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre del comercio es obligatorio"
            );
        }

        // VALIDAR DIRECCION
        if(comercio.getDireccion() == null || comercio.getDireccion().isBlank()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "La dirección es obligatoria"
            );
        }

        // VALIDAR TELEFONO
        if(comercio.getTelefono() == null || comercio.getTelefono().length() < 7){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El teléfono es inválido"
            );
        }

        // VALIDAR ESTADO
        if(comercio.getEstado() == null){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El estado es obligatorio"
            );
        }

        return repositorio.save(comercio);
    }

    // LISTAR TODOS
    public List<Comercio> listarComercios(){
        return repositorio.findAll();
    }

    // BUSCAR POR ID
    public Optional<Comercio> buscarPorId(Integer id){
        return repositorio.findById(id);
    }

    // ELIMINAR
    public void eliminarComercio(Integer id){
        repositorio.deleteById(id);
    }

    // ACTUALIZAR
    public Comercio actualizarComercio(Integer id, Comercio comercio){
        comercio.setId(id);
        return repositorio.save(comercio);
    }
}