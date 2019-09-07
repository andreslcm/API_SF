package com.api.facturas.modelos;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Factura
 */
@Entity
@Table(name = "facturas")
@EntityListeners(AuditingEntityListener.class)
public class Factura implements Serializable {

    private static final long serialVersionUID = 6598528521436596043L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;
    @Column(name = "numero_factura", nullable = false)
    private Long numeroFactura;
    @ManyToOne
    private Usuario usuario;
    @OneToMany(mappedBy = "factura")
    private List<DetalleFactura> detalleFactura;
    @ManyToOne
    private Cliente cliente;
    @Column(name = "orden_compra")
    private String ordenCompra;
    @Column(name = "fecha_factura")
    @Temporal(TemporalType.DATE)
    private Date fechaFactura;
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Column(name = "subtotal")
    private double subtotal;
    @Column(name = "impuestos")
    private double impuestos;
    @Column(name = "total")
    private double total;
    @Column(name = "notas")
    private String notas;
    @Column(name = "esta_pagada")
    private boolean estaPagada;

    /**
     * Constructor vacío. Necesario para que Hibernate instancie el objeto.
     */
    public Factura() {
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
     * Método para obtener el usuario al cual está relacionado la factura.
     * 
     * @return usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Método para asignar un usuario a la factura.
     * 
     * @param usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Método para obtener la lista de detalles pertenecientes a la factura.
     * 
     * @return detalleFactura
     */
    public List<DetalleFactura> getDetalleFactura() {
        return detalleFactura;
    }

    /**
     * Método para asignar una lista de detalles a la factura.
     * 
     * @param detalleFactura
     */
    public void setDetalleFactura(List<DetalleFactura> detalleFactura) {
        this.detalleFactura = detalleFactura;
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
     * Método para obtener el cliente al cual se emite la factura.
     * 
     * @return cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Método para asignar un cliente a una factura.
     * 
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

}
