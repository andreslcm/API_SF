package com.api.facturas.seguridad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class RespuestaJwtTest {


	/** RespuestaJwt para usar en varios test */

	RespuestaJwt test;

	@BeforeClass
	void setUp() {

		/** seteado de variables para todas las pruebas */

		test = new RespuestaJwt("test");

	}

	@Test
	void setNombreUsuarioTest() {

		/** test de setter de RespuestaJwt.getTokenJwt */
		
		assertTrue(test.getTokenJwt().equals("test"));

	}
	
}
