package com.api.facturas.servicios;

import com.api.facturas.dtos.DtoUsuario;
import com.api.facturas.modelos.Usuario;
import com.api.facturas.repositorios.RepositorioClientes;
import com.api.facturas.repositorios.RepositorioFacturas;
import com.api.facturas.repositorios.RepositorioUsuarios;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * ServicioUsuario
 */
public class ServicioUsuario {

    @Autowired
    RepositorioFacturas repoFacturas;

    @Autowired
    RepositorioClientes repoClientes;

    @Autowired
    RepositorioUsuarios repoUsuarios;

    /**
     * Método para guardar un usuario en la base de datos a partir de un DTO.
     * 
     * @param usuarioDto
     * @return
     */
    public Usuario crearusUario(DtoUsuario usuarioDto) {
        Usuario usuario = new Usuario(usuarioDto);
        return repoUsuarios.save(usuario);
    }

    /**
     * Método para saber si un nombre de usuario ya existe.
     * 
     * @param nombreUsuario
     * @return {boolean}
     */
    public boolean verificacionNombreUsuario(String nombreUsuario) {
        return (repoUsuarios.nombreUsuario(nombreUsuario).isPresent());
    }

    /**
     * Método para saber si un correo ya existe.
     * 
     * @param correo
     * @return {boolean}
     */
    public boolean verificacionCorreo(String correo) {
        return (repoUsuarios.correo(correo).isPresent());
    }

}