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
public class DetalleFactura implements Serializable{
    
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
    
}