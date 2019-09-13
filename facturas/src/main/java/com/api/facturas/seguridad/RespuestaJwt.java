package com.api.facturas.seguridad;

import java.io.Serializable;

/**
 * RespuestaJwt para implementar JSON Web Tokens en la aplicación de Spring.
 */
public class RespuestaJwt implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String tokenJwt;

    /**
     * Constructor de la respuesta del token.
     * 
     * @param tokenJwt
     */
    public RespuestaJwt(String tokenJwt) {
        this.tokenJwt = tokenJwt;
    }

    /**
     * Método para obtener el token.
     * @return {String} tokenJwt
     */
    public String getTokenJwt() {
        return tokenJwt;
    }
}