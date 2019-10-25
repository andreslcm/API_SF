package com.api.facturas.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * RecursoNoEncontrado
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecursoNoEncontrado extends RuntimeException {

    private static final long serialVersionUID = 6242482823488217664L;

    /**
     * Contructor que recibe el mensaje que se va a mostrar cuando se llame la
     * excepción.
     * 
     * @param mensaje
     */
    public RecursoNoEncontrado(String mensaje) {
        super(mensaje);
    }
}
