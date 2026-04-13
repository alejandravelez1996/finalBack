package com.example.finalBack.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.finalBack.modelos.Usuario;
import com.example.finalBack.repositorios.IUsuarioRepositorio;

@Service
public class UsuarioServicio {

    @Autowired
    private IUsuarioRepositorio repositorio;

    // guardar
    public Usuario guardarUsuario(Usuario usuario){

        // VALIDAR NOMBRE
        if(usuario.getNombre() == null || usuario.getNombre().isBlank()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre del usuario es obligatorio"
            );
        }

        // VALIDAR DOCUMENTO
        if(usuario.getDocumento() == null || usuario.getDocumento().length() < 5){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El documento es inválido"
            );
        }

        return repositorio.save(usuario);
    }

    // listar todos
    public List<Usuario> listarUsuarios(){
        return repositorio.findAll();
    }

    // buscar por id
    public Optional<Usuario> buscarPorId(Integer id){
        return repositorio.findById(id);
    }

    // eliminar
    public void eliminarUsuario(Integer id){
        repositorio.deleteById(id);
    }

    // actualizar
    public Usuario actualizarUsuario(Integer id, Usuario usuario){
        usuario.setId(id);
        return repositorio.save(usuario);
    }
}