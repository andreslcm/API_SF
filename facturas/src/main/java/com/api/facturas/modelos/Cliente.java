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
public class Cliente implements Serializable {

    private static final long serialVersionUID = -2560344747577539244L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    @ManyToOne
    private Usuario usuario;
    @OneToMany(mappedBy = "cliente")
    private List<Factura> facturas;
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

    /**
     * Constructor vacío. Necesario para que Hibernate instancie el objeto.
     */
    public Cliente() {
    }
    /**
     * Método para obtener el id del cliente.
     * @return idCliente
     */
    public Long getIdCliente() {
        return idCliente;
    }
    /**
     * Método para obtener el usuario al que está relacionado el cliente.
     * @return usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }
    /**
     * Método para asignar el usuario al cual está relacionado el cliente.
     * @param usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    /**
     * Método para obtener el nombre del cliente, que puede ser una agencia o un cliente particular.
     * @return nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }
    /**
     * Método para asignar el nombre del cliente, que puede ser una agencia o un cliente particular.
     * @param nombreCliente
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    /**
     * Método para obtener el país del cliente.
     * @return pais
     */
    public String getPais() {
        return pais;
    }
    /**
     * Método para asignar un país al cliente.
     * @param pais
     */
    public void setPais(String pais) {
        this.pais = pais;
    }
    /**
     * Método para obtener el estado o provincia del cliente.
     * @return estado
     */
    public String getEstado() {
        return estado;
    }
    /**
     * Método para asignar un estado o provincia al cliente.
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    /**
     * Método para obtener la ciudad del cliente.
     * @return ciudad
     */
    public String getCiudad() {
        return ciudad;
    }
    /**
     * Método para asignar una ciudad al cliente.
     * @param ciudad
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    /**
     * Método para obtener el código postal del cliente.
     * @return codigoPostal
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }
    /**
     * Método para asignar un código postal al cliente.
     * @param codigoPostal
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    /**
     * Método para obtener el teléfono del cliente.
     * @return telefono
     */
    public String getTelefono() {
        return telefono;
    }
    /**
     * Método para asignar un teléfono al cliente.
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    /**
     * Método para obtener el correo electrónico del cliente.
     * @return correoElectrónico
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    /**
     * Método para asignar un correo electrónico al cliente.
     * @param correoElectronico
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    /**
     * Método para obtener el plazo de pago para el cliente.
     * @return terminoPago
     */
    public int getTerminoPago() {
        return terminoPago;
    }
    /**
     * Método para asignar un plazo de pago para el cliente.
     * @param terminoPago
     */
    public void setTerminoPago(int terminoPago) {
        this.terminoPago = terminoPago;
    }
    /**
     * Método para obtener el precio por palabra traducida para el cliente.
     * @return palabraTraduccion
     */
    public double getPalabraTraduccion() {
        return palabraTraduccion;
    }
    /**
     * Método para asignar el precio por palabra traducida para el cliente.
     * @param palabraTraduccion
     */
    public void setPalabraTraduccion(double palabraTraduccion) {
        this.palabraTraduccion = palabraTraduccion;
    }
    /**
     * Método para obtener el precio por hora de traducción para el cliente.
     * @return horaTraduccion
     */
    public double getHoraTraduccion() {
        return horaTraduccion;
    }
    /**
     * Método para asignar el precio por hora de traducción para el cliente.
     * @param horaTraduccion
     */
    public void setHoraTraduccion(double horaTraduccion) {
        this.horaTraduccion = horaTraduccion;
    }
    /**
     * Método para obtener el precio por palabra editada para el cliente.
     * @return palabraEdicion
     */
    public double getPalabraEdicion() {
        return palabraEdicion;
    }
    /**
     * Método para asignar el precio por palabra editada para el cliente.
     * @param palabraEdicion
     */
    public void setPalabraEdicion(double palabraEdicion) {
        this.palabraEdicion = palabraEdicion;
    }
    /**
     * Método para obtener el precio por hora de edición para el cliente.
     * @return horaEdicion
     */
    public double getHoraEdicion() {
        return horaEdicion;
    }
    /**
     * Método para asignar el precio por hora de edición para el cliente.
     * @param horaEdicion
     */
    public void setHoraEdicion(double horaEdicion) {
        this.horaEdicion = horaEdicion;
    }
    /**
     * Método para obtener el precio por palabra revisada para el cliente.
     * @return palabraProofreading
     */
    public double getPalabraProofreading() {
        return palabraProofreading;
    }
    /**
     * Método para asignar el precio por palabra revisada para el cliente.
     * @param palabraProofreading
     */
    public void setPalabraProofreading(double palabraProofreading) {
        this.palabraProofreading = palabraProofreading;
    }
    /**
     * Método para obtener el precio por hora de proofreading para el cliente.
     * @return horaProofreading
     */
    public double getHoraProofreading() {
        return horaProofreading;
    }
    /**
     * Método para asignar el precio por hora de proofreading para el cliente.
     * @param horaProofreading
     */
    public void setHoraProofreading(double horaProofreading) {
        this.horaProofreading = horaProofreading;
    }
    /**
     * Método para obtener la dirección específica del cliente (i.e., calle, nro. de casa o edificio, etc.).
     * @return direccion
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     * Método para asignar una dirección específica al cliente.
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     * Método para obtener las facturas correspondientes al cliente.
     * @return facturas
     */
    public List<Factura> getFacturas() {
        return facturas;
    }
    /**
     * Método para asignar facturas al cliente.
     * @param facturas
     */
    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    
}
