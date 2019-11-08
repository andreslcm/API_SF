package com.api.facturas.repositorios;

import java.util.Optional;

import com.api.facturas.modelos.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Interfaz RepositorioUsuarios
 */
public interface RepositorioUsuarios extends JpaRepository<Usuario, Long> {

    /**
     * Método que recibe un nombre de usuario y hace una consulta SQL para traer al
     * usuario correspondiente y verificar si el nombre de usuario ya existe en la
     * base de datos.
     * @param String nombreUsuario
     * @return Long {Usuario} usuario
     */
    @Query(value = "SELECT * FROM  usuarios U WHERE U.nombre_usuario = :nombreUsuario", nativeQuery = true)
    Usuario encontrarPorNombreUsuario(String nombreUsuario);

    /**
     * Método que recibe un correo electrónico y hace una consulta SQL para saber si
     * el correo ya existe en la base de datos.
     * @param String correo
     * @return {String} Correo electrónico
     */
    @Query(value = "SELECT U.correo_electronico FROM usuarios U WHERE U.correo_electronico = :correo", nativeQuery = true)
    Optional<String> correo(String correo);

    /**
     * Método para saber si un nombre de usuario ya existe,
     * @param String nombreUsuario
     * @return {String} nombreUsuario
     */
    @Query(value = "SELECT U.nombre_usuario FROM usuarios U WHERE U.nombre_usuario = :nombreUsuario", nativeQuery = true)
    Optional<String> nombreUsuario(String nombreUsuario);
    /**
     * Método que recibe un id y hace una consulta SQL para buscar a un usuario por
     * su id y verificar si existe en la base de datos.
     * 
     * @param idUsuario
     * @return {Usuario} usuario
     */
    @Query(value = "SELECT * FROM usuarios U WHERE U.id_usuario = :idUsuario", nativeQuery = true)
    Usuario encontrarPorId(Long idUsuario);

    @Query(value = "SELECT U.id_usuario FROM usuarios U WHERE U.nombre_usuario = :nombre", nativeQuery = true)
    Integer obtenerId(String nombre);
}