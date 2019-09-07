package com.api.facturas.modelos;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Cliente
 */
@Entity
@Table(name = "clientes")
@EntityListeners(AuditingEntityListener.class)
public class Cliente implements Serializable{

    private static final long serialVersionUID = -2560344747577539244L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    @ManyToOne
    private Usuario usuario;
    @OneToMany(mappedBy = "cliente")
    private List<Factura>facturas;
    @Column(name = "nombre_cliente", nullable = false)
    private String nombreCliente;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "estado")
    private String estado;
    @Column(name = "pais")
    private String pais;
    @Column(name = "codigo_postal")
    private String codigoPostal;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Column(name = "termino_pago")
    private int terminoPago;
    @Column(name = "palabra_traduccion")
    private double palabraTraduccion;
    @Column(name = "hora_traduccion")
    private double horaTraduccion;
    @Column(name = "palabra_edicion")
    private double palabraEdicion;
    @Column(name = "hora_edcion")
    private double horaEdicion;
    @Column(name = "palabra_proofreading")
    private double palabraProofreading;
    @Column(name = "hora_proofreading")
    private double horaProofreading;
    
    
}

