package com.api.facturas.dtos;

import com.api.facturas.modelos.Cliente;

/**
 * DtoCliente
 */
public class DtoCliente {

    private Long idCliente;
    private String nombreCliente;
    private String direccion;
    private String ciudad;
    private String estado;
    private String pais;
    private String codigoPostal;
    private String telefono;
    private String correoElectronico;
    private int terminoPago;
    private double palabraTraduccion;
    private double horaTraduccion;
    private double palabraEdicion;
    private double horaEdicion;
    private double palabraProofreading;
    private double horaProofreading;
    
    
    
    
    
    
    

    /**
     * Constructor vacío
     */
    public DtoCliente() {
    }

    /**
     * Constructor que toma como parámetro un objeto de tipo Cliente para generar un
     * DTO a partir de este.
     * 
     * @param cliente
     */
    public DtoCliente(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nombreCliente = cliente.getNombreCliente();
        this.direccion = cliente.getDireccion();
        this.ciudad = cliente.getCiudad();
        this.estado = cliente.getEstado();
        this.pais = cliente.getPais();
        this.codigoPostal = cliente.getCodigoPostal();
        this.telefono = cliente.getTelefono();
        this.correoElectronico = cliente.getCorreoElectronico();
        this.terminoPago = cliente.getTerminoPago();
        this.palabraTraduccion = cliente.getPalabraTraduccion();
        this.palabraEdicion = cliente.getPalabraEdicion();
        this.palabraProofreading = cliente.getPalabraProofreading();
        this.horaTraduccion = cliente.getHoraTraduccion();
        this.horaEdicion = cliente.getHoraEdicion();
        this.horaProofreading = cliente.getHoraProofreading();
    }
    
    
    /**
     * Constructor para propositos de testeo
     * 
     * 
     * @param id,nombre,direccion,ciudad,estado,pais,codpos,tel,corel,termpago,
     * paltrac,paled,palproo,horatra,horaed,horaproo
     */
    
    
    public DtoCliente(Long id, String nombre, String direccion,
    		String ciudad, String estado, String pais, String codpos,
    		String tel, String corel, int termpago, Double paltrac,
    		Double paled, Double palproo, Double horatra, Double horaed, Double horaproo) {
    	
        this.idCliente = id;
        this.nombreCliente = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.estado = estado;
        this.pais = pais;
        this.codigoPostal = codpos;
        this.telefono = tel;
        this.correoElectronico = corel;
        this.terminoPago = termpago;
        this.palabraTraduccion = paltrac;
        this.palabraEdicion = paled;
        this.palabraProofreading = palproo;
        this.horaTraduccion = horatra;
        this.horaEdicion = horaed;
        this.horaProofreading = horaproo;
    	
    
    }

    /**
     * Método para obtener el id del cliente.
     * 
     * @return idCliente
     */
    public Long getIdCliente() {
        return idCliente;
    }

    /**
     * Método para asignar un id al DTO del cliente
     * 
     * @param idCliente
     */
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Método para obtener el nombre del cliente, que puede ser una agencia o un
     * cliente particular.
     * 
     * @return nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * Método para asignar el nombre del cliente, que puede ser una agencia o un
     * cliente particular.
     * 
     * @param nombreCliente
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * Método para obtener el país del cliente.
     * 
     * @return pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * Método para asignar un país al cliente.
     * 
     * @param pais
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Método para obtener el estado o provincia del cliente.
     * 
     * @return estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método para asignar un estado o provincia al cliente.
     * 
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método para obtener la ciudad del cliente.
     * 
     * @return ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Método para asignar una ciudad al cliente.
     * 
     * @param ciudad
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Método para obtener el código postal del cliente.
     * 
     * @return codigoPostal
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Método para asignar un código postal al cliente.
     * 
     * @param codigoPostal
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Método para obtener el teléfono del cliente.
     * 
     * @return telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Método para asignar un teléfono al cliente.
     * 
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método para obtener el correo electrónico del cliente.
     * 
     * @return correoElectrónico
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Método para asignar un correo electrónico al cliente.
     * 
     * @param correoElectronico
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Método para obtener el plazo de pago para el cliente.
     * 
     * @return terminoPago
     */
    public int getTerminoPago() {
        return terminoPago;
    }

    /**
     * Método para asignar un plazo de pago para el cliente.
     * 
     * @param terminoPago
     */
    public void setTerminoPago(int terminoPago) {
        this.terminoPago = terminoPago;
    }

    /**
     * Método para obtener el precio por palabra traducida para el cliente.
     * 
     * @return palabraTraduccion
     */
    public double getPalabraTraduccion() {
        return palabraTraduccion;
    }

    /**
     * Método para asignar el precio por palabra traducida para el cliente.
     * 
     * @param palabraTraduccion
     */
    public void setPalabraTraduccion(double palabraTraduccion) {
        this.palabraTraduccion = palabraTraduccion;
    }

    /**
     * Método para obtener el precio por hora de traducción para el cliente.
     * 
     * @return horaTraduccion
     */
    public double getHoraTraduccion() {
        return horaTraduccion;
    }

    /**
     * Método para asignar el precio por hora de traducción para el cliente.
     * 
     * @param horaTraduccion
     */
    public void setHoraTraduccion(double horaTraduccion) {
        this.horaTraduccion = horaTraduccion;
    }

    /**
     * Método para obtener el precio por palabra editada para el cliente.
     * 
     * @return palabraEdicion
     */
    public double getPalabraEdicion() {
        return palabraEdicion;
    }

    /**
     * Método para asignar el precio por palabra editada para el cliente.
     * 
     * @param palabraEdicion
     */
    public void setPalabraEdicion(double palabraEdicion) {
        this.palabraEdicion = palabraEdicion;
    }

    /**
     * Método para obtener el precio por hora de edición para el cliente.
     * 
     * @return horaEdicion
     */
    public double getHoraEdicion() {
        return horaEdicion;
    }

    /**
     * Método para asignar el precio por hora de edición para el cliente.
     * 
     * @param horaEdicion
     */
    public void setHoraEdicion(double horaEdicion) {
        this.horaEdicion = horaEdicion;
    }

    /**
     * Método para obtener el precio por palabra revisada para el cliente.
     * 
     * @return palabraProofreading
     */
    public double getPalabraProofreading() {
        return palabraProofreading;
    }

    /**
     * Método para asignar el precio por palabra revisada para el cliente.
     * 
     * @param palabraProofreading
     */
    public void setPalabraProofreading(double palabraProofreading) {
        this.palabraProofreading = palabraProofreading;
    }

    /**
     * Método para obtener el precio por hora de proofreading para el cliente.
     * 
     * @return horaProofreading
     */
    public double getHoraProofreading() {
        return horaProofreading;
    }

    /**
     * Método para asignar el precio por hora de proofreading para el cliente.
     * 
     * @param horaProofreading
     */
    public void setHoraProofreading(double horaProofreading) {
        this.horaProofreading = horaProofreading;
    }

    /**
     * Método para obtener la dirección específica del cliente (i.e., calle, nro. de
     * casa o edificio, etc.).
     * 
     * @return direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Método para asignar una dirección específica al cliente.
     * 
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}