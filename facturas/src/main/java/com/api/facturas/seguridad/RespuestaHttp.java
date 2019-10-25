package com.api.facturas.seguridad;

/**
 * RespuestaHttp
 */
public class RespuestaHttp {

    private RespuestaJwt token;
    private int id;

    public RespuestaHttp(RespuestaJwt token, int id) {
        this.token = token;
        this.id = id;
    }

    public RespuestaJwt getToken() {
        return token;
    }

    public void setToken(RespuestaJwt token) {
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}