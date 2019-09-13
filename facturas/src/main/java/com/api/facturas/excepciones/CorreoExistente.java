package com.api.facturas.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * CorreoExistente
 */
@ResponseStatus(value = HttpStatus.CONFLICT)
public class CorreoExistente extends RuntimeException {

    private static final long serialVersionUID = 5264457827134874127L;

    /**
     * Constructor que recibe mensaje como parámetro.
     * 
     * @param mensaje
     */
    public CorreoExistente(String mensaje) {
        super(mensaje);
    }
}