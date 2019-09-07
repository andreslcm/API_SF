package com.api.facturas.modelos;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

import javax.persistence.*;

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

    /**
     * Constructor vacío. Necesario para que Hibernate instancie el objeto.
     */
    public DetalleFactura() {
    }

    /**
     * Constructor para crear un detalle con un monto y una descripción.
     * 
     * @param monto
     * @param descripcionProyecto
     */
    public DetalleFactura(double monto, String descripcionProyecto) {
        this.monto = monto;
        this.descripcionProyecto = descripcionProyecto;
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