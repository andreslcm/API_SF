package com.api.facturas.controladores;

import com.api.facturas.dtos.DtoUsuario;
import com.api.facturas.excepciones.CorreoExistente;
import com.api.facturas.excepciones.UsuarioExistente;
import com.api.facturas.servicios.ServicioUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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
     * @param usuario
     * @return {ResponseEntity<>}
     */
    @PostMapping("/prueba_registro")
    public ResponseEntity<?> registrarUsuario(@RequestBody DtoUsuario usuario) {

        if (servicio.verificacionCorreo(usuario.getCorreo())) {
            throw new CorreoExistente("El correo electrónico ya existe: " + usuario.getCorreo());
        } else if (servicio.verificacionNombreUsuario(usuario.getNombreUsuario())) {
            throw new UsuarioExistente("El usuario ya existe: " + usuario.getNombreUsuario());
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}