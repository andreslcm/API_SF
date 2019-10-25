package com.api.facturas.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.api.facturas.modelos.Factura;

/**
 * DetoFactura
 */
public class DtoFactura {

    private Long idFactura;
    private Long numeroFactura;
    private String ordenCompra;
    private Date fechaFactura;
    private Date fechaVencimiento;
    private double subtotal;
    private double impuestos;
    private double total;
    private String notas;
    private boolean estaPagada;
    private String nombreCliente;
    private List<DtoDetalleFactura> detalles;
    private Long idCliente;

    /**
     * Constructor vacío
     */
    public DtoFactura() {
    }

    /**
     * Constructor que recibe un objeto Factura para crear un DTO a partir de este.
     * 
     * @param factura
     */
    public DtoFactura(Factura factura) {
        this.numeroFactura = factura.getNumeroFactura();
        this.ordenCompra = factura.getOrdenCompra();
        this.fechaFactura = factura.getFechaFactura();
        this.fechaVencimiento = factura.getFechaVencimiento();
        this.subtotal = factura.getSubtotal();
        this.impuestos = factura.getImpuestos();
        this.total = factura.getTotal();
        this.notas = factura.getNotas();
        this.estaPagada = factura.getEstaPagada();
        this.idFactura = factura.getIdFactura();
        this.nombreCliente = factura.getCliente().getNombreCliente();
        this.detalles = agregarDetalles(factura);
        this.idCliente = factura.getCliente().getIdCliente();
    }

    /**
     * Método para enviar una lista de detalles junto con la factura que se vaya a consultar.
     * @param f (Objeto Factura)
     * @return listaDto (devuelve un ArrayList de DtoDetalles)
     */
    private List<DtoDetalleFactura> agregarDetalles(Factura f){
        List<DtoDetalleFactura>listaDto = new ArrayList<>();
        f.getDetalleFactura().forEach(detalle -> listaDto.add(new DtoDetalleFactura (detalle)));
        return listaDto;
    }

    /**
     * Método para obtener el número de la factura.
     * 
     * @return numeroFactura
     */
    public Long getNumeroFactura() {
        return numeroFactura;
    }

    /**
     * Método para asginar un número de factura.
     * 
     * @param numeroFactura
     */
    public void setNumeroFactura(Long numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    /**
     * Método para obtener el subtotal de la factura.
     * 
     * @return subtotal
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * Método para asignar un subtotal a la factura.
     * 
     * @param subtotal
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * Método para obtener los impuestos de la factura.
     * 
     * @return impuestos
     */
    public double getImpuestos() {
        return impuestos;
    }

    /**
     * Método para asignar los impuestos a una factura.
     * 
     * @param impuestos
     */
    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    /**
     * Método para obtener el total de la factura.
     * 
     * @return total
     */
    public double getTotal() {
        return total;
    }

    /**
     * Método para asignar el total a una factura.
     * 
     * @param total
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Método para obtener la fecha de emisión de la factura.
     * 
     * @return fechaFactura
     */
    public Date getFechaFactura() {
        return fechaFactura;
    }

    /**
     * Método para asignar una fecha de emisión a la factura.
     * 
     * @param fechaFactura
     */
    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    /**
     * Método para obtener la fecha de vencimiento de la factura.
     * 
     * @return fechaVencimiento
     */
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * Método para asignar una fecha de vencimiento a una factura.
     * 
     * @param fechaVencimiento
     */
    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * Método para obtener las notas o los comentarios que haga el usuario en la
     * factura.
     * 
     * @return
     */
    public String getNotas() {
        return notas;
    }

    /**
     * Método para asignar las notas de una factura.
     * 
     * @param notas
     */
    public void setNotas(String notas) {
        this.notas = notas;
    }

    /**
     * Método para obtener el número de orden de compra de una factura.
     * 
     * @return ordenCompra
     */
    public String getOrdenCompra() {
        return ordenCompra;
    }

    /**
     * Método para asignar un número de orden de compra a una factura.
     * 
     * @param ordenCompra
     */
    public void setOrdenCompra(String ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    /**
     * Método para obtener el estado de la factura (paga o no paga).
     * 
     * @return estaPagada
     */
    public boolean getEstaPagada() {
        return estaPagada;
    }

    /**
     * Método para cambiar el estado de pago de una factura.
     * 
     * @param pagada
     */
    public void setEstaPagada(boolean pagada) {
        this.estaPagada = pagada;
    }

    /**
     * Método para obtener id de la factura.
     * 
     * @return idFactura
     */
    public Long getIdFactura() {
        return idFactura;
    }

    /**
     * Método para aginar un id al DTO de la factura.
     * 
     * @param idFactura
     */
    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public List<DtoDetalleFactura> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DtoDetalleFactura> detalles) {
        this.detalles = detalles;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

}
