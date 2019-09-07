package com.api.facturas.modelos;

import java.util.List;

import com.api.facturas.dtos.DtoDetalleFactura;
import com.api.facturas.dtos.DtoFactura;
/**
 * Clase que funciona como 'Wrapper' para poder 
 * solicitar a través de un solo RequestBody parámetros 
 * correspondientes tanto a la clase Factura como a DetalleFactura.
 */
public class EnvoltorioFactura {

    private DtoFactura factura;
    private List<DtoDetalleFactura> detalles;

    /**
     * Constructor
     */
    public DtoFactura getFactura() {
        return factura;
    }
    /**
     * Método para asignar uan factura a través de su DTO.
     * @param factura
     */
    public void setFactura(DtoFactura factura) {
        this.factura = factura;
    }
    /**
     * Método para obtener la lista de detalles correspondientes a la factura.
     * @return detalles
     */
    public List<DtoDetalleFactura> getDetalles() {
        return detalles;
    }
    /**
     * Método para asignar detalles los detalles de una factura.
     * @param detalles
     */
    public void setDetalles(List<DtoDetalleFactura> detalles) {
        this.detalles = detalles;
    }
    
}