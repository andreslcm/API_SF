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
public class Factura implements Serializable{

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


    
}
