package com.api.facturas.seguridad;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * PuntoEntradaAutenticacion
 */
@Component
public class PuntoEntradaAutenticacion implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Método sobrescrito que envía una respuesta de autenticación.
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {

        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No autorizado.");
    }

}