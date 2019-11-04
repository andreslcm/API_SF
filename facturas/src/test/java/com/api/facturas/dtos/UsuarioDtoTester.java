package com.api.facturas.dtos;
import com.api.facturas.dtos.DtoUsuario;

public class UsuarioDtoTester extends DtoUsuario{

    /**
	 * Constructor que recibe parametros separados para propositos de testeo
	 * 
	 * 
	 * @param id, nombre, apellido, nombreusuario, contraseña, correo, 
	 * direccion, ciudad, estado, pais, codigopostal, telefono,
	 * datosbanco, datospaypal, datospayoneer
	 */
	
	
	public UsuarioDtoTester(Long id, String nombre, String apellido, 
			String nombreusuario, String con, String correo,
			String direccion, String ciudad, String estado, String pais,
			String codigopostal, String telefono, String datbanco, String datospaypal, String datospayoneer) {
		
		setIdUsuario(id);
		setNombre(nombre);
		setApellido(apellido);
		setNombreUsuario(nombreusuario);
		setContrasena(con);
		setCorreo(correo);
		setDireccion(direccion);
		setCiudad(ciudad);
		setEstado(estado);
		setPais(pais);
		setCodigoPostal(codigopostal);
		setTelefono(telefono);
		setDatosBanco(datbanco);
		setDatosPaypal(datospaypal);
		setDatosPayoneer(datospayoneer);		
		
    	
    }
}