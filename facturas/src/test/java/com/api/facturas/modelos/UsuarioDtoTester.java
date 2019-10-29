


Class UsuarioDtoTester extends UsuarioDtoTester{

    /**
	 * Constructor que recibe parametros separados para propositos de testeo
	 * 
	 * 
	 * @param id, nombre, apellido, nombreusuario, contraseña, correo, 
	 * direccion, ciudad, estado, pais, codigopostal, telefono,
	 * datosbanco, datospaypal, datospayoneer
	 */
	
	
	public UsuarioDtoTester(Long id, String nombre, String apellido, 
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
}