package com.api.facturas.seguridad;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.api.facturas.servicios.ServicioUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;

/**
 * FiltroSolicitud
 */
@Component
public class FiltroSolicitud extends OncePerRequestFilter {

    @Autowired
    private ServicioUsuario servicio;
    @Autowired
    private HerramientaToken herramienta;

    /**
     * Método para aplicar filtro interno al token.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final String solicitarHeaderToken = request.getHeader("Authorization");

        String nombreUsuario = null;
        String tokenJwt = null;

        /*
         * El token JWT tiene la forma "Bearer Token", hay que quitar la palabra
         * "Bearer" para obtener solo el token.
         */
        if (solicitarHeaderToken != null && solicitarHeaderToken.startsWith("Bearer ")) {
            tokenJwt = solicitarHeaderToken.substring(7);
            try {
                nombreUsuario = herramienta.getNombreUsuarioToken(tokenJwt);
            } catch (IllegalArgumentException e) {
                System.out.println("No se pudo obtener el token");
            } catch (ExpiredJwtException e) {
                System.out.println("El token está vencido");
            }
        } else {
            logger.warn("El token JWT no comienza con el String Bearer");
        }

        // Una vez que se tiene el token, se valida.
        if (nombreUsuario != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails detallesUsuario = this.servicio.loadUserByUsername(nombreUsuario);

            /*
             * Si el token es válido, se configura Spring Security para que establezca
             * manualmente la autenticación.
             */
            if (herramienta.validarToken(tokenJwt, detallesUsuario)) {
                UsernamePasswordAuthenticationToken tokenAutenticacionNombreUsuarioContrasaena = new UsernamePasswordAuthenticationToken(
                        detallesUsuario, null, detallesUsuario.getAuthorities());
                tokenAutenticacionNombreUsuarioContrasaena
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                /*
                 * Después de establecer la autenticación en el contexto, se especifica que el
                 * usuario actual está autenticado de modo que pueda pasar las configuraciones
                 * de Spring Security con éxito.
                 */

                SecurityContextHolder.getContext().setAuthentication(tokenAutenticacionNombreUsuarioContrasaena);
            }

        }

        filterChain.doFilter(request, response);
    }

}