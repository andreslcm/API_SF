package com.api.facturas.modelos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



/** Para testear la clase Usuario
 * @version 06/10/19
 * */

class UsuarioTest {
	
	/**  Usuario para usar en varios test */
	
	Usuario usuarioTest;
	
	@BeforeClass
	void setUp() { 
		
		/** seteado de usuarioTest para todas las pruebas */
		
	Usuario usuarioTest = new Usuario("nombre", "apellido", "nombreusuario", "contraseña", "correo", "direccion", 
            "ciudad", "estado", "pais", "codigopostal", "telefono");
	}
	
	@Test
	void constructorTest() {
		
		/** test de constructor */
		
		assertTrue(usuarioTest instanceof Usuario);
	}


	
	
}