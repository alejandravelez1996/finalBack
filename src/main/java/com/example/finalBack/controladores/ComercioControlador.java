package com.example.finalBack.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.finalBack.modelos.Comercio;
import com.example.finalBack.servicios.ComercioServicio;

@RestController
@RequestMapping("/api/comercio")
public class ComercioControlador {

    @Autowired
    private ComercioServicio servicio;

    // GUARDAR
    @PostMapping
    public Comercio guardar(@RequestBody Comercio comercio){
        return servicio.guardarComercio(comercio);
    }

    // LISTAR TODOS
    @GetMapping
    public List<Comercio> listar(){
        return servicio.listarComercios();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Optional<Comercio> buscarPorId(@PathVariable Integer id){
        return servicio.buscarPorId(id);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public Comercio actualizar(
            @PathVariable Integer id,
            @RequestBody Comercio comercio){

        return servicio.actualizarComercio(id, comercio);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
        servicio.eliminarComercio(id);
    }
}