package com.api.facturas.servicios;

import com.api.facturas.dtos.DtoUsuario;
import com.api.facturas.excepciones.RecursoNoEncontrado;
import com.api.facturas.modelos.Usuario;
import com.api.facturas.repositorios.RepositorioClientes;
import com.api.facturas.repositorios.RepositorioFacturas;
import com.api.facturas.repositorios.RepositorioUsuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ServicioUsuario
 */
@Service
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
     * @param Objeto usuarioDto
     * @return Objeto usuario
     */
    public Usuario crearUsuario(DtoUsuario usuarioDto) {
        Usuario usuario = new Usuario(usuarioDto);
        return repoUsuarios.save(usuario);
    }

    /**
     * Método para saber si un nombre de usuario ya existe.
     * 
     * @param String nombreUsuario
     * @return {Boolean}
     */
    public boolean verificacionNombreUsuario(String nombreUsuario) {
        return (repoUsuarios.nombreUsuario(nombreUsuario).isPresent());
    }

    /**
     * Método para saber si un correo ya existe.
     * 
     * @param String correo
     * @return {Boolean}
     */
    public boolean verificacionCorreo(String correo) {
        return (repoUsuarios.correo(correo).isPresent());
    }

    /**
     * Método para actualizar los datos de un usuario.
     * 
     * @param Objeto usuarioDto
     * @param Long idUsuario
     */
    public void actualizarDatos(DtoUsuario usuarioDto, Long idUsuario) {
        Usuario usuario = repoUsuarios.findById(idUsuario)
                .orElseThrow(() -> new RecursoNoEncontrado("No existe un usuario con el ID " + idUsuario));
        usuario.actualizarDatos(usuarioDto);
        repoUsuarios.save(usuario);
    }

    /**
     * Método para consultar los datos de un usuario.
     * @param Long idUsuario
     * @return Objeto {DtoUsuario} usuario
     */
    public DtoUsuario consultarDatos(Long idUsuario) {
        DtoUsuario usuario = new DtoUsuario(repoUsuarios.findById(idUsuario)
                .orElseThrow(() -> new RecursoNoEncontrado("No existe un usuario con el ID " + idUsuario)));
        return usuario;
    }

}