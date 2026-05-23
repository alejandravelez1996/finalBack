package com.example.finalBack.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.finalBack.modelos.Categoria;
import com.example.finalBack.servicios.CategoriaServicio;

@RestController
@RequestMapping("api/v1/categorias")
public class CategoriaControlador {

    @Autowired
    CategoriaServicio servicio;

    // guardar
    @PostMapping
    public ResponseEntity<?> controladorGuardar(@RequestBody Categoria datos){

        return ResponseEntity.status(HttpStatus.OK)
                .body(servicio.guardarCategoria(datos));
    }

    // listar
    @GetMapping
    public ResponseEntity<?> controladorListar(){

        return ResponseEntity.status(HttpStatus.OK)
                .body(servicio.listarCategorias());
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
            @RequestBody Categoria datos){

        return ResponseEntity.status(HttpStatus.OK)
                .body(servicio.actualizarCategoria(id, datos));
    }



    //Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> controladorEliminar(
            @PathVariable Integer id){

        servicio.eliminarCategoria(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body("Categoría eliminada correctamente");
    }
}