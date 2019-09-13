package com.api.facturas.controladores;

import com.api.facturas.dtos.DtoUsuario;
import com.api.facturas.excepciones.CorreoExistente;
import com.api.facturas.excepciones.UsuarioExistente;
import com.api.facturas.servicios.ServicioUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ControladorUsuario
 */
@RestController
@CrossOrigin
public class ControladorUsuario {

    @Autowired
    private ServicioUsuario servicio;

    /**
     * Método para registrar a un usuario en la BD.
     * 
     * @param usuario
     * @return {ResponseEntity<>}
     */
    @PostMapping("/registro")
    public ResponseEntity<?> registrarUsuario(@RequestBody DtoUsuario usuario) {

        if (servicio.verificacionCorreo(usuario.getCorreo())) {
            throw new CorreoExistente("El correo electrónico ya existe: " + usuario.getCorreo());
        } else if (servicio.verificacionNombreUsuario(usuario.getNombreUsuario())) {
            throw new UsuarioExistente("El usuario ya existe: " + usuario.getNombreUsuario());
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Método para actualizar los datos del usuario.
     * 
     * @param usuarioDto
     * @param idUsuario
     * @return {ResponseEntity<>}
     */
    @PutMapping("/actualizar-datos/{idUsuario}")
    public ResponseEntity<?> actualizarDatos(@RequestBody DtoUsuario usuarioDto,
            @PathVariable(value = "idUsuario") Long idUsuario) {

        servicio.actualizarDatos(usuarioDto, idUsuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Método para consultar los datos del usuario.
     * 
     * @param idUsuario
     * @return {ResponseEntity<>}
     */
    @GetMapping("datos-usuario/{idUsuario}")
    public ResponseEntity<?> obtenerDatosUsuario(@PathVariable(value = "idUsuario") Long idUsuario) {

        DtoUsuario usuario = servicio.consultarDatos(idUsuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

}