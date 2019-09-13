package com.api.facturas.seguridad;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * HerramientaToken
 */
public class HerramientaToken implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final long JWT_TOKEN_VALIDACION = 5 * 60 * 60;
    @Value("$jwt.secret")
    private String secreta;

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

    /**
     * Método para recuperar cualquier información del token a partir de la clave
     * secreta.
     * 
     * @param token
     * @return {Claims}
     */
    private Claims obtenerTodasClaimsToken(String token) {
        return Jwts.parser().setSigningKey(secreta).parseClaimsJws(token).getBody();
    }

    // Revisar si el token está vencido
    /**
     * Método para revisar si el token está vencido.
     * 
     * @param token
     * @return {Boolean} vencimiento
     */
    private Boolean tokenVencido(String token) {
        final Date vencimiento = obtenerFechaVencimientoToken(token);
        return vencimiento.before(new Date());
    }

    /**
     * Método para generar un token para un usuario específico.
     * 
     * @param detallesUsuario
     * @return {String} generacionToken
     */
    public String generarToken(UserDetails detallesUsuario) {
        Map<String, Object> claims = new HashMap<>();
        return generacionToken(claims, detallesUsuario.getUsername());
    }

    /**
     * Método que implementa la generación del token. Aplica algoritmo de hasheo y
     * asigna tiempo de validez.
     * 
     * @param claims
     * @param sujeto
     * @return {String}
     */
    private String generacionToken(Map<String, Object> claims, String sujeto) {
        return Jwts.builder().setClaims(claims).setSubject(sujeto).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDACION * 1000))
                .signWith(SignatureAlgorithm.HS512, secreta).compact();
    }

}