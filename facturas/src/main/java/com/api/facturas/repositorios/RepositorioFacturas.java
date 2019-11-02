package com.api.facturas.repositorios;

import java.util.List;
import java.util.Optional;

import com.api.facturas.modelos.Factura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Interfaz RepositorioFacturas
 */
public interface RepositorioFacturas extends JpaRepository<Factura, Long> {

    /**
     * Método que recibe el id de un usuario y hace una consulta SQL para encotrar
     * todas las facturas relacionadas con el usuario.
     * 
     * @param Long idUsuario
     * @return Lista {List<Factura>} Lista de facturas
     */
    @Query(value = "SELECT * FROM  facturas F WHERE F.usuario_id_usuario = :idUsuario", nativeQuery = true)
    List<Factura> listarFacturasPorIdUsuario(Long idUsuario);

    /**
     * Método que recibe el id de un cliente y hace una consulta SQL para listar
     * todas las facturas relacionadas con ese cliente.
     * 
     * @param Long idCliente
     * @return Lista {List<Factura>} Lista de facturas
     */
    @Query(value = "SELECT * FROM  facturas F WHERE F.cliente_id_cliente = :idCliente", nativeQuery = true)
    List<Factura> listarFacturasPorIdCliente(Long idCliente);

    /**
     * Método que recibe un id y hace una consulta SQL para buscar una factura por
     * su id.
     * 
     * @param Long idFactura
     * @return Objeto {Factura} Factura
     */
    @Query(value = "SELECT * FROM  facturas F WHERE F.id_factura = :idFactura", nativeQuery = true)
    Optional<Factura> encontrarFacturaPorId(Long idFactura);

    /**
     * Método que recibe un id y hace una consulta SQL para obtener el monto
     * promedio por factura de un usuario.
     * 
     * @param Long idUsuario
     * @return {Double} promedio
     */
    @Query(value = "SELECT AVG(total) FROM  facturas F WHERE F.usuario_id_usuario = :idUsuario ", nativeQuery = true)
    Double promedio(Long idUsuario);

    /**
     * Método que recibe el id de un usuario y hace una consulta SQL para mostrar
     * todas las facturas que aún no se han cobrado.
     * 
     * @param Long idUsuario
     * @return {Double} totalPorCobrar
     */
    @Query(value = "SELECT SUM(total) FROM  facturas F WHERE F.esta_pagada = 0 and F.usuario_id_usuario = :idUsuario", nativeQuery = true)
    Double totalPorCobrar(Long idUsuario);

    /**
     * Método que recibe el id de un usuario y hace una consulta SQL para mostrar el
     * monto total de todas las facturas.
     * 
     * @param Long idUsuario
     * @return {Double} sumaTotal
     */
    @Query(value = "SELECT SUM(total) FROM  facturas F WHERE F.usuario_id_usuario =:idUsuario", nativeQuery = true)
    Double sumaTotal(Long idUsuario);

    /**
     * Método que recibe el id de un usuario y hace una consulta SQL para mostrar
     * todas las facturas no pagadas de ese usuario.
     * 
     * @param Long idUsuario
     * @return Objeto {Factura}
     */
    @Query(value = "SELECT * from facturas F WHERE F.esta_pagada = 0 and F.usuario_id_usuario = :idUsuario", nativeQuery = true)
    List<Factura> facturasNoPagas(Long idUsuario);

    /**
     * Muestra las facturas de los últimos 7 días.
     * 
     * @param Long idUsuario
     * @return Lista {List<Factura>} ultimos7Dias
     */
    @Query(value = "SELECT * from facturas F WHERE DATEDIFF(day, F.fecha_factura, GETDATE()) between 0 and 7 and F.usuario_id_usuario = :idUsuario", nativeQuery = true)
    List<Factura> ultimos7Dias(Long idUsuario);

    /**
     * Muestra las facturas de los últimos 30 días.
     * 
     * @param Long idUsuario
     * @return Lista {List<Factura>} ultimos30Dias
     */
    @Query(value = "SELECT * from facturas F WHERE DATEDIFF(day, F.fecha_factura, GETDATE()) between 0 and 30 and F.usuario_id_usuario = :idUsuario", nativeQuery = true)
    List<Factura> ultimos30Dias(Long idUsuario);

    /**
     * Muestra las facturas de los últimos 90 días.
     * 
     * @param Long idUsuario
     * @return {List<Factura>} ultimos90Dias
     */
    @Query(value = "SELECT * from facturas F WHERE DATEDIFF(day, F.fecha_factura, GETDATE()) between 0 and 90 and F.usuario_id_usuario = :idUsuario", nativeQuery = true)
    List<Factura> ultimos90Dias(Long idUsuario);

    /**
     * Muestra las facturas de los últimos 180 días.
     * 
     * @param Long idUsuario
     * @return Lista {List<Factura>} ultimos180Dias
     */
    @Query(value = "SELECT * from facturas F WHERE DATEDIFF(day, F.fecha_factura, GETDATE()) between 0 and 182 and F.usuario_id_usuario = :idUsuario", nativeQuery = true)
    List<Factura> ultimos180Dias(Long idUsuario);

    /**
     * Muestra las facturas de los últimos 365 días.
     * 
     * @param Long idUsuario
     * @return Lista {List<Factura>} ultimos365Dias
     */
    @Query(value = "SELECT * from facturas F WHERE DATEDIFF(day, F.fecha_factura, GETDATE()) between 0 and 365 and F.usuario_id_usuario = :idUsuario", nativeQuery = true)
    List<Factura> ultimos365Dias(Long idUsuario);

    /**
     * Muestra una lista de facturas pertenecientes a un cliente en particular.
     * 
     * @param Long idCliente
     * @return Lista {List<Factura> porCliente}
     */
    @Query(value = "SELECT * from facturas F WHERE F.cliente_id_cliente = :idCliente", nativeQuery = true)
    List<Factura> porCliente(Long idCliente);

    /**
     * Muestra el nombre de los primeros 5 clientes a los que más se facturó.
     * 
     * @param Long idUsuario
     * @return Lista {List<String> mejoresClientes}
     */
    @Query(value = "SELECT TOP 5 C.nombre_cliente FROM clientes C, facturas F WHERE (C.id_cliente = F.cliente_id_cliente and DATEDIFF(day, F.fecha_factura, GETDATE()) between 0 and 30) and F.usuario_id_usuario = :idUsuario GROUP BY C.nombre_cliente ORDER BY SUM(F.total) DESC", nativeQuery = true)
    List<String> mejoresClientes(Long idUsuario);

    /**
     * Muestra el monto total facturado a los primeros 5 de acuerdo por orden de
     * importancia.
     * 
     * @param Long idUsuario
     * @return Lista {List<Double> mejoresClientes}
     */
    @Query(value = "SELECT TOP 5 SUM(F.total) FROM clientes C, facturas F WHERE (C.id_cliente = F.cliente_id_cliente and DATEDIFF(day, F.fecha_factura, GETDATE()) between 0 and 30) and F.usuario_id_usuario = :idUsuario GROUP BY C.nombre_cliente ORDER BY SUM(F.total) DESC", nativeQuery = true)
    List<Double> totalMejoresClientes(Long idUsuario);
}
