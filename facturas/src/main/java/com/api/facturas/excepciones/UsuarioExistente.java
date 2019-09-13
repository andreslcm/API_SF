package com.api.facturas.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * UsuarioExistente
 */
@ResponseStatus(value = HttpStatus.CONFLICT)
public class UsuarioExistente extends RuntimeException {

    private static final long serialVersionUID = -6862945501201879865L;

    /**
     * Constructor que recibe mensaje como parámetro.
     * 
     * @param mensaje
     */
    public UsuarioExistente(String mensaje) {
        super(mensaje);
    }
}