package com.api.facturas.seguridad;

import java.io.Serializable;
import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;

import io.jsonwebtoken.Claims;

/**
 * HerramientaToken
 */
public class HerramientaToken implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final long JWT_TOKEN_VALIDACION = 5 * 60 * 60;
    @Value("$jwt.secret")
    private String secreto;

    /**
     * Método para recuperar el nombre de usuario del token.
     * 
     * @param token
     * @return {String} obtenerClaimToken
     */
    public String getNombreUsuarioToken(String token) {
        return obtenerClaimToken(token, Claims::getSubject);
    }

    /**
     * Método para recuperar
     * 
     * @param token
     * @return {Date} obtenerClaimToken
     */
    public Date obtenerFechaVencimientoToken(String token) {
        return obtenerClaimToken(token, Claims::getExpiration);
    }

    /**
     * Método para obtener la 'Claim' del token.
     * 
     * @param <T>
     * @param token
     * @param resolvedorClaims
     * @return T resolvedorClaims
     */
    private <T> T obtenerClaimToken(String token, Function<Claims, T> resolvedorClaims) {
        final Claims claims = obtenerTodasClaimsToken(token);
        return resolvedorClaims.apply(claims);

    }

}