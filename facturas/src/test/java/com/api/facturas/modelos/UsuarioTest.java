package com.api.facturas.modelos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.api.facturas.dtos.DtoUsuario;



/** Para testear la clase Usuario
 * @version 06/10/19
 * */

class UsuarioTest {
	
	/**  Usuario para usar en varios test */
	
	Usuario usuarioTest;
	DtoUsuario dtoTest;
	
	@BeforeClass
	void setUp() { 
		
		/** seteado de usuarioTest para todas las pruebas */
		
	Usuario usuarioTest = new Usuario("nombre", "apellido", "nombreusuario", "contraseña", "correo", "direccion", 
            "ciudad", "estado", "pais", "codigopostal", "telefono");
	DtoUsuario dtoTest = new DtoUsuario("dtonombre", "dtoapellido", "dtonombreusuario", "dtocontraseña", "dtocorreo", "dtodireccion", 
            "dtociudad", "dtoestado", "dtopais", "dtocodigopostal", "dtotelefono");
	}
	
	@Test
	void constructorTest() {
		
		/** test de constructor */
		
		assertNotNull(usuarioTest);
		assertTrue(usuarioTest instanceof Usuario);
		Usuario constructorTest = new Usuario(dtoTest);
		assertNotNull(constructorTest);
		assertTrue(constructorTest instanceof Usuario);
	}

	@Test
	void getIdUsuarioTest() {
		
		/** test de getter de Usuario.IdUsuario */
		
		assertNotNull(usuarioTest.getIdUsuario());
		assertTrue(usuarioTest.getIdUsuario() instanceof Long);

	}
	
	@Test
	void setIdUsuarioTest() {
		
		/** test de setter de Usuario.IdUsuario */
		
		usuarioTest.setIdUsuario(1234);
		assertNotNull(usuarioTest.getIdUsuario());
		assertTrue(usuarioTest.getIdUsuario() == 1234);

	}
	
	
	
	
}