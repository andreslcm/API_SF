package com.api.facturas.seguridad;

import java.io.Serializable;

/**
 * SolicitudJwt
 */
public class SolicitudJwt implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nombreUsuario;
    private String contrasena;

    /**
     * Constructor vacío necesario para generar el JSON.
     */
    public SolicitudJwt() {
    }

    /**
     * Contructor que recibe el nombre de usuario y la contraseña para armar la
     * solcitud.
     * 
     * @param nombreUsuario
     * @param contrasena
     */
    public SolicitudJwt(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    /**
     * Método para obtener el nombre de usuario.
     * 
     * @return {String} nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Método para asginar nombre de usuario.
     * 
     * @param nombreUsuario
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Método para obtener la contraseña.
     * 
     * @return {String} contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Método para asignar la contraseña.
     * 
     * @param contrasena
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}