package com.api.facturas.modelos;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

import javax.persistence.*;

import com.api.facturas.dtos.DtoDetalleFactura;

/**
 * DetalleFactura
 */
@Entity
@Table(name = "detalle_factura")
@EntityListeners(AuditingEntityListener.class)
public class DetalleFactura implements Serializable {

    private static final long serialVersionUID = -732583211223219318L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_factura")
    private Long idDetalleFactura;
    @ManyToOne
    private Factura factura;
    @Column(name = "descripcion_proyecto")
    private String descripcionProyecto;
    @Column(name = "monto")
    private double monto;
    @Column(name = "precio")
    private double precio;
    @Column(name = "numero_palabras")
    private Integer numeroPalabras;
    /**
     * Constructor vacío. Necesario para que Hibernate instancie el objeto.
     */
    public DetalleFactura() {
    }

    /**
     * Constructor que recibe un objeto DtoDetalleFactura para generar un
     * DetalleFactura a partir de este.
     * 
     * @param detalleFactura
     */
    public DetalleFactura(DtoDetalleFactura detalleFacturaDto) {
        this.monto = detalleFacturaDto.getMonto();
        this.descripcionProyecto = detalleFacturaDto.getDescripcionProyecto();
        this.precio = detalleFacturaDto.getPrecio();
        this.numeroPalabras = detalleFacturaDto.getNumeroPalabras();
    }

    /**
     * Método para obtener la factura que corresponde al detalle.
     * 
     * @return {Factura} factura
     */
    public Factura getFactura() {
        return factura;
    }

    /**
     * Método para asignar una factura a cada detalle.
     * 
     * @param factura
     */
    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    /**
     * Método para obtener el monto del detalle.
     * 
     * @return {Double} monto
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
     * @return {Long} idDetalleFactura
     */
    public Long getIdDetalleFactura() {
        return idDetalleFactura;
    }

    /**
     * Método para obtener la descripción del proyecto realizado.
     * 
     * @return {String} descripcionProyecto
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

    /**
     * Método para actualizar los datos de un detalle a partir de su DTO.
     * 
     * @param detalletDto
     */
    public void actualizarDetalles(DtoDetalleFactura detalletDto) {
        this.monto = detalletDto.getMonto();
        this.descripcionProyecto = detalletDto.getDescripcionProyecto();
    }

    public Integer getNumeroPalabras() {
        return numeroPalabras;
    }

    public void setNumeroPalabras(Integer numeroPalabras) {
        this.numeroPalabras = numeroPalabras;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}