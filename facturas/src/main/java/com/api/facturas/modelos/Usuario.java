package com.api.facturas.modelos;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;

import com.api.facturas.dtos.DtoUsuario;

import java.io.Serializable;
import java.util.List;

/**
 * Usuario
 */
@Entity
@Table(name = "usuarios")
@EntityListeners(AuditingEntityListener.class)
public class Usuario implements Serializable {

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
    @Column(name = "medio_pago_1")
    private String datosPaypal;
    @Column(name = "medio_pago_2")
    private String datosBanco;
    @Column(name = "medio_pago_3")
    private String datosPayoneer;

    /**
     * Constructor vacío. Necesario para que Hibernate instancie el objeto.
     */
    public Usuario() {
    }

    /**
     * Constructor que toma como parámetro un objeto DtoUsuario para generar un
     * usuario a partir de este.
     * 
     * @param usuario
     */
    public Usuario(DtoUsuario usuario) {
        this.nombre = usuario.getNombre();
        this.apellido = usuario.getApellido();
        this.nombreUsuario = usuario.getNombreUsuario();
        // this.contrasena = usuario.getContrasena();
        this.correo = usuario.getCorreo();
        this.direccion = usuario.getDireccion();
        this.ciudad = usuario.getCiudad();
        this.estado = usuario.getEstado();
        this.pais = usuario.getPais();
        this.codigoPostal = usuario.getCodigoPostal();
        this.telefono = usuario.getTelefono();
        this.datosBanco = usuario.getDatosBanco();
        this.datosPaypal = usuario.getDatosPaypal();
        this.datosPayoneer = usuario.getDatosPayoneer();
    }

    /**
     * Método para obtener el id del usuario.
     * 
     * @return idUsuario
     */
    public Long getIdUsuario() {
        return idUsuario;
    }

    /**
     * Método para obtener la lista de facturas del usuario.
     * 
     * @return facturas
     */
    public List<Factura> getFacturas() {
        return facturas;
    }

    /**
     * Método para asignar un conjunto de facturas al usuario.
     */
    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    /**
     * Método para obtener los clientes del usuario.
     * 
     * @return clientes
     */
    public List<Cliente> getClientes() {
        return clientes;
    }

    /**
     * Método para asignar clientes al usuario.
     * 
     * @param clientes
     */
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     * Método para obtener la ciudad del usuario.
     * 
     * @return ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Método para asignar ciudad al usuario.
     * 
     * @param ciudad
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Método para obtener el país del usuario.
     * 
     * @return pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * Método para asignar país al usuario.
     * 
     * @param pais
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Método para obtener el estado o provincia del usuario.
     * 
     * @return estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método para asignar estado o provincia al usuario.
     * 
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método para obtener el número telefónico del usuario.
     * 
     * @return telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Método para asignar número telefónico al usuario.
     * 
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método para obtener el código postal del usuario.
     * 
     * @return codigoPostal
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Método para asignar código postal al usuario.
     * 
     * @param codigoPostal
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Método para obtener el correo electrónico del usuario.
     * 
     * @return correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Método para asignar correo electrónico al usuario.
     * 
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Método para obtener el nombre de usuario del usuario.
     * 
     * @return nombreUsuario.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Método para asignar nombre de usuario al usuario.
     * 
     * @param nombreUsuario
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Método para obtener la contraseña del usuario.
     * 
     * @return
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Método para asignar contraseña al usuario.
     * 
     * @param contrasena
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Método para obtener los datos de PayPal del usuario.
     * 
     * @return datosPaypal
     */
    public String getDatosPaypal() {
        return datosPaypal;
    }

    /**
     * Método para asignar datos de PayPal al usuario.
     * 
     * @param datosPaypal
     */
    public void setDatosPaypal(String datosPaypal) {
        this.datosPaypal = datosPaypal;
    }

    /**
     * Método para obtener los datos de pago bancarios del usuario.
     * 
     * @return datosBanco
     */
    public String getDatosBanco() {
        return datosBanco;
    }

    /**
     * Método para asignar los datos de pago bancarios del usuario.
     * 
     * @param datosBanco
     */
    public void setDatosBanco(String datosBanco) {
        this.datosBanco = datosBanco;
    }

    /**
     * Método para obtener los datos de pago de Payoneer del usuario.
     * 
     * @return datosPayoneer
     */
    public String getDatosPayoneer() {
        return datosPayoneer;
    }

    /**
     * Método para asignar los datos de pago de Payoneer del usuario.
     * 
     * @param datosPayoneer
     */
    public void setDatosPayoneer(String datosPayoneer) {
        this.datosPayoneer = datosPayoneer;
    }

    /**
     * Método para obtener el nombre del usuario.
     * 
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para asignar nombre al usuario.
     * 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para asignar apellido al usuario.
     * 
     * @return apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Método para asignar apellido al usuario.
     * 
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Método para obtener la dirección específica del usuario (i.e., calle, nro. de
     * casa o edificio, etc.).
     * 
     * @return direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Método para asignar dirección específica al usuario.
     * 
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Método que recibe como parámetro un objeto DtoUsuario para actualizar los
     * datos del usuario a partir de este.
     * 
     * @param usuario
     */
    public void actualizarDatos(DtoUsuario usuario) {
        this.setNombre(usuario.getNombre());
        this.setApellido(usuario.getApellido());
        this.setNombreUsuario(usuario.getNombreUsuario());
        this.setContrasena(usuario.getContrasena());
        this.setCorreo(usuario.getCorreo());
        this.setDireccion(usuario.getDireccion());
        this.setCiudad(usuario.getCiudad());
        this.setEstado(usuario.getEstado());
        this.setPais(usuario.getPais());
        this.setCodigoPostal(usuario.getCodigoPostal());
        this.setTelefono(usuario.getTelefono());
        this.setDatosBanco(usuario.getDatosBanco());
        this.setDatosPaypal(usuario.getDatosPaypal());
        this.setDatosPayoneer(usuario.getDatosPayoneer());
    }

}
