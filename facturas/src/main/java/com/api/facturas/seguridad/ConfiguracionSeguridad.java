package com.api.facturas.seguridad;

import com.api.facturas.servicios.ServicioUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

/**
 * ConfiguracionSeguridad
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {

    @Autowired
    private ServicioUsuario servicio;
    @Autowired
    private PuntoEntradaAutenticacion entrada;
    @Autowired
    FiltroSolicitud filtro;

    /**
     * Método para hacer la configuración global,
     * 
     * @param autenticador
     * @throws Exception
     */
    @Autowired
    public void configuracionGlobal(AuthenticationManagerBuilder autenticador) throws Exception {
        // Configurar el AuthManager para que sepa dónde cargar el usuario para comparar
        // las credenciales. Usar BCryptPasswordEncoder
        autenticador.userDetailsService(servicio).passwordEncoder(passwordEncoder());
    }

    /**
     * Codificador de contraseñas.
     * 
     * @return PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Método para gestionar las autenticaciones.
     * 
     * @return AuthenticationManager
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * Método sobrescrito de configuración.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers("/autenticar", "/registrar_usuario").permitAll()
                .anyRequest().authenticated().and().exceptionHandling().authenticationEntryPoint(entrada).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Filtro para validar los tokens con cada solicitud
        http.addFilterBefore(filtro, UsernamePasswordAuthenticationFilter.class);
    }

}