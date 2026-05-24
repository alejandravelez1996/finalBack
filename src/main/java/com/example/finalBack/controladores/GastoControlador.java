package com.example.finalBack.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.finalBack.modelos.Gasto;
import com.example.finalBack.servicios.GastoServicio;

@RestController
@RequestMapping("/api/gasto")
public class GastoControlador {

    @Autowired
    private GastoServicio servicio;

    // GUARDAR
    @PostMapping
    public Gasto guardar(@RequestBody Gasto gasto){
        return servicio.guardarGasto(gasto);
    }

    // LISTAR TODOS
    @GetMapping
    public List<Gasto> listar(){
        return servicio.listarGastos();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Optional<Gasto> buscarPorId(@PathVariable Integer id){
        return servicio.buscarPorId(id);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public Gasto actualizar(
            @PathVariable Integer id,
            @RequestBody Gasto gasto){

        return servicio.actualizarGasto(id, gasto);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
        servicio.eliminarGasto(id);
    }
}