package com.api.facturas.dtos;

import com.api.facturas.modelos.DetalleFactura;

/**
 * DtoDetalleFactura
 */
public class DtoDetalleFactura {

    private Long idDetalleFactura;
    private String descripcionProyecto;
    private double monto;

    /**
     * Constructor vacío
     */
    public DtoDetalleFactura() {
    }

    /**
     * Contructor que toma como parámetro un detalle de factura para generar un DTO
     * a partir de este.
     * 
     * @param factura
     */
    public DtoDetalleFactura(DetalleFactura detalleFactura) {
        this.monto = detalleFactura.getMonto();
        this.descripcionProyecto = detalleFactura.getDescripcionProyecto();
        this.idDetalleFactura = detalleFactura.getIdDetalleFactura();
    }

    /**
     * Método para obtener el monto del detalle.
     * 
     * @return monto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Método para asignar el monto del detalle.
     * 
     * @param monto
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * Método para obtener el id del detalle.
     * 
     * @return idDetalleFactura
     */
    public Long getIdDetalleFactura() {
        return idDetalleFactura;
    }

    /**
     * Método para asignar id al DTO de DetalleFactura.
     * 
     * @param idDetalleFactura
     */
    public void setIdDetalleFactura(Long idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    /**
     * Método para obtener la descripción del proyecto realizado.
     * 
     * @return descripcionProyecto
     */
    public String getDescripcionProyecto() {
        return descripcionProyecto;
    }

    /**
     * Método para asignar la descripción del proyecto realizado.
     * 
     * @param descripcionProyecto
     */
    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto = descripcionProyecto;
    }

}