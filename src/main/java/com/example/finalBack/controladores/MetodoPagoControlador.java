package com.example.finalBack.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.finalBack.modelos.MetodoPago;
import com.example.finalBack.servicios.MetodoPagoServicio;

@RestController
@RequestMapping("api/v1/metodos-pago")
public class MetodoPagoControlador {

    @Autowired
    MetodoPagoServicio servicio;

    // guardar
    @PostMapping
    public ResponseEntity<?> controladorGuardar(@RequestBody MetodoPago datos){

        return ResponseEntity.status(HttpStatus.OK)
                .body(servicio.guardar(datos));
    }

    // listar
    @GetMapping
    public ResponseEntity<?> controladorListar(){

        return ResponseEntity.status(HttpStatus.OK)
                .body(servicio.buscarTodos());
    }

    // buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<?> controladorBuscarPorId(
            @PathVariable Integer id){

        return ResponseEntity.status(HttpStatus.OK)
                .body(servicio.buscarPorId(id));
    }

    // modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> controladorModificar(
            @PathVariable Integer id,
            @RequestBody MetodoPago datos){

        return ResponseEntity.status(HttpStatus.OK)
                .body(servicio.editar(id, datos));
    }

    // eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> controladorEliminar(
            @PathVariable Integer id){

        servicio.eliminar(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body("Método de pago eliminado correctamente");
    }
}