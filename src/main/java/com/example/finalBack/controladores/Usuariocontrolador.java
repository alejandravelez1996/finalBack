package com.example.finalBack.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.finalBack.modelos.Usuario;
import com.example.finalBack.servicios.UsuarioServicio;

@RestController
@RequestMapping("api/v1/usuarios")
public class Usuariocontrolador {

    @Autowired
    UsuarioServicio servicio;

    // guardar
    @PostMapping
    public ResponseEntity<?> controladorGuardar(
            @RequestBody Usuario usuario){

        return ResponseEntity.status(HttpStatus.OK)
                .body(servicio.guardarUsuario(usuario));
    }

    // listar todos
    @GetMapping
    public ResponseEntity<?> controladorListar(){

        return ResponseEntity.status(HttpStatus.OK)   
                .body(servicio.listarUsuarios());
    }

    // buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<?> controladorBuscarPorId(
            @PathVariable Integer id){

        return ResponseEntity.status(HttpStatus.OK)
                .body(servicio.buscarPorId(id));
    }

    // actualizar
    @PutMapping("/{id}")
    public ResponseEntity<?> controladorActualizar(
            @PathVariable Integer id,
            @RequestBody Usuario usuario){

        return ResponseEntity.status(HttpStatus.OK)
                .body(servicio.actualizarUsuario(id, usuario));
    }

    // eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> controladorEliminar(
            @PathVariable Integer id){

        servicio.eliminarUsuario(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body("Usuario eliminado correctamente");
    }
}