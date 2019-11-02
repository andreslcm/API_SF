package com.api.facturas.repositorios;

import java.util.List;

import com.api.facturas.modelos.DetalleFactura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Interfaz RepositorioDetalles
 */
public interface RepositorioDetalles extends JpaRepository<DetalleFactura, Long> {

    /**
     * Método que recibe como parámetro el id de una factura y hace una consulta SQL
     * para encontrar todos los detalles relacionados con la factura.
     * 
     * @param Long idFactura
     * @return Lista {List<DetalleFactura>} Lista de detalles
     */
    @Query(value = "SELECT * FROM  detalle_factura D WHERE D.factura_id_factura = :idFactura", nativeQuery = true)
    List<DetalleFactura> listarDetalles(Long idFactura);
}