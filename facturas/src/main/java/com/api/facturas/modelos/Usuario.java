package com.api.facturas.modelos;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Usuario
 */
@Entity
@Table(name = "usuarios")
@EntityListeners(AuditingEntityListener.class)
public class Usuario implements Serializable{

    private static final long serialVersionUID = -2887032741573862174L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;
    @OneToMany(mappedBy = "usuario")
    private List<Factura> facturas;
    @OneToMany(mappedBy = "usuario")
    private List<Cliente> clientes;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Column(name = "contrasena")
    private String contrasena;
    @Column(name = "correo_electronico")
    private String correo;
    @Column (name = "direccion")
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
    @Column(name = "medio_pago_1")
    private String datosPaypal;
    @Column(name = "medio_pago_2")
    private String datosBanco;
    @Column(name = "medio_pago_3")
    private String datosPayoneer;
    

}
