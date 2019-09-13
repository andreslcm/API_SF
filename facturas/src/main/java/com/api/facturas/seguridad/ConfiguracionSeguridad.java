package com.api.facturas.seguridad;

import com.api.facturas.servicios.ServicioUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

/**
 * ConfiguracionSeguridad
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ConfiguracionSeguridad {

    @Autowired
    private ServicioUsuario servicio;
    @Autowired
    private PuntoEntradaAutenticacion entrada;
    @Autowired
    FiltroSolicitud filtro;
    
    /**
     * Método para hacer la configuración global,
     * @param autenticador
     * @throws Exception
     */
    @Autowired
    public void configuracionGlobal (AuthenticationManagerBuilder autenticador) throws Exception {
        //Configurar el AuthManager para que sepa dónde cargar el usuario para comparar las credenciales. Usar BCryptPasswordEncoder
        autenticador.userDetailsService(servicio).passwordEncoder(passwordEncoder());
    }
    
}