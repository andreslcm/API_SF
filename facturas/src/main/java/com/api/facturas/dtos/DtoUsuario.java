package com.api.facturas.dtos;

import com.api.facturas.modelos.Usuario;

/**
 * DtoUsuario
 */
public class DtoUsuario {

	private Long idUsuario;
	private String nombre;
	private String apellido;
	private String nombreUsuario;
	private String contrasena;
	private String correo;
	private String direccion;
	private String ciudad;
	private String estado;
	private String pais;
	private String codigoPostal;
	private String telefono;
	private String datosPaypal;
	private String datosBanco;
	private String datosPayoneer;

	/**
	 * Constructor vacìo.
	 */
	public DtoUsuario() {
	}

	/**
	 * Constructor que recibe como parámetro un objeto Usuario para crear un
	 * DtoUsuario a partir de este.
	 * 
	 * @param usuario
	 */
	public DtoUsuario(Usuario usuario) {
		this.idUsuario = usuario.getIdUsuario();
		this.nombre = usuario.getNombre();
		this.apellido = usuario.getApellido();
		this.nombreUsuario = usuario.getNombreUsuario();
		this.contrasena = usuario.getContrasena();
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
	 * Constructor que recibe parametros separados para propositos de testeo
	 * 
	 * 
	 * @param id, nombre, apellido, nombreusuario, contraseña, correo, 
	 * direccion, ciudad, estado, pais, codigopostal, telefono,
	 * datosbanco, datospaypal, datospayoneer
	 */
	
	
	public DtoUsuario(Long id, String nombre, String apellido, 
			String nombreusuario, String contraseña, String correo,
			String direccion, String ciudad, String estado, String pais,
			String codigopostal, String telefono, String datosbanco, String datospaypal, String datospayoneer) {
		this.idUsuario = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombreUsuario = nombreusuario;
		this.contrasena = contraseña;
		this.correo = correo;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.estado = estado;
		this.pais = pais;
		this.codigoPostal = codigopostal;
		this.telefono = telefono;
		this.datosBanco = datosbanco;
		this.datosPaypal = datospaypal;
		this.datosPayoneer = datospayoneer;
		
		
    	
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
	 * Método para asignar un id al DTO del usuario.
	 * 
	 * @param idUsuario
	 */
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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
}