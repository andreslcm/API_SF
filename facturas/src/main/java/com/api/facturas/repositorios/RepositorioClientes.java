package com.api.facturas.repositorios;

import java.util.List;
import java.util.Optional;

import com.api.facturas.modelos.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Interfaz RepositorioClientes
 */
public interface RepositorioClientes extends JpaRepository<Cliente, Long> {

    /**
     * Método que recibe como parámetro el id de un usuario para hacer una consulta
     * SQL y buscar a todos los clientes relacionados con ese id de usuario.
     * @param Long idUsuario
     * @return Lista {List<Cliente>}Lista de clientes
     */
    @Query(value = "SELECT * FROM clientes C WHERE C.usuario_id_usuario = :idUsuario", nativeQuery = true)
    List<Cliente> listarClientes(Long idUsuario);

    /**
     * Método que recibe como parámetro el nombre de un cliente para hacer una
     * consulta SQL y buscar a un cliente por su nombre.
     * @param String nombreCliente
     * @return Objeto {Cliente} cliente
     */
    @Query(value = "SELECT * FROM clientes C WHERE C.nombre_cliente = :nombreCliente", nativeQuery = true)
    Optional<Cliente> encontrarPorNombreCliente(String nombreCliente);

    /**
     * Método que recibe como parámetro el id de un cliente para hacer una
     * consulta SQL y buscar a un cliente por su id.
     * @param Long idCliente
     * @return Objeto {Cliente} cliente
     */
    @Query(value = "SELECT * FROM clientes C WHERE C.id_cliente = :idCliente", nativeQuery = true)
    Optional<Cliente> encontrarPorId(Long idCliente);
}