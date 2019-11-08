package com.api.facturas.servicios;

import java.util.ArrayList;
import com.api.facturas.dtos.DtoUsuario;
import com.api.facturas.excepciones.RecursoNoEncontrado;
import com.api.facturas.modelos.Usuario;
import com.api.facturas.repositorios.RepositorioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class ServicioUsuario implements UserDetailsService {

    @Autowired
    private RepositorioUsuarios repoUsuarios;

    @Autowired
    private PasswordEncoder codificador;

    /**
     * Método para guardar un usuario en la base de datos a partir de un DTO.
     * Utiliza un codificador para encriptar la clave del usuario antes de guardarla
     * en la BD.
     * 
     * @param usuarioDto
     * @return
     */
    public Usuario crearUsuario(DtoUsuario usuarioDto) {
        Usuario usuario = new Usuario(usuarioDto);
        usuario.setContrasena(codificador.encode(usuarioDto.getContrasena()));
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

    /**
     * Método para actualizar los datos de un usuario.
     * 
     * @param usuarioDto
     * @param idUsuario
     */
    public void actualizarDatos(DtoUsuario usuarioDto, Long idUsuario) {
        Usuario usuario = repoUsuarios.findById(idUsuario)
                .orElseThrow(() -> new RecursoNoEncontrado("No existe un usuario con el ID " + idUsuario));

        // usuarioDto.setContrasena(codificador.encode(usuarioDto.getContrasena()));
        usuario.actualizarDatos(usuarioDto);
        repoUsuarios.save(usuario);
    }

    public void actualizarContrasena(Long idUsuario, String contrasena){
        Usuario usuario = repoUsuarios.findById(idUsuario)
                .orElseThrow(() -> new RecursoNoEncontrado("No existe un usuario con el ID " + idUsuario));
        usuario.actualizarContrasena(codificador.encode(contrasena));
        repoUsuarios.save(usuario);
    }

    /**
     * Método para consultar los datos de un usuario.
     * 
     * @param idUsuario
     * @return {DtoUsuario} usuario
     */
    public DtoUsuario consultarDatos(Long idUsuario) {
        DtoUsuario usuario = new DtoUsuario(repoUsuarios.findById(idUsuario)
                .orElseThrow(() -> new RecursoNoEncontrado("No existe un usuario con el ID " + idUsuario)));
        return usuario;
    }

    /**
     * Método sobrescrito de la interfaz implementada UserDetailsService, que
     * verifica que exista el nombre de usuario y que la contraseña provista sea
     * correcta.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repoUsuarios.encontrarPorNombreUsuario(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("No existe ningún usuario con el nombre " + username);
        }
        return new org.springframework.security.core.userdetails.User(usuario.getNombreUsuario(),
                usuario.getContrasena(), new ArrayList<>());
    }

    public int obtenerIdUsuario(String nombre){
        int id = repoUsuarios.obtenerId(nombre);
        
        return id;
    }
}