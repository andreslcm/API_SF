package com.api.facturas.seguridad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RespuestaHttpTest {

	/** RespuestaHttp para usar en varios test */

	RespuestaHttp test;
	
	@BeforeClass
	void setUp() {

		/** seteado de variables para todas las pruebas */

		test = new RespuestaHttp(new RespuestaJwt("test"), 11);

	}

	
	
	@Test
	void getTokenTest() {

		/** test de getter de RespuestaHttp.getToken */

		assertTrue(test.getToken().getTokenJwt().equals("test"));

	}

	@Test
	void setTokenTest() {

		/** test de setter de RespuestaHttp.setToken */

		test.setToken(new RespuestaJwt("test2"));
		assertTrue(test.getToken().getTokenJwt().equals("test2"));

	}
	
	@Test
	void getContraseñaTest() {

		/** test de getter de SolicitudJwt.getContrasena */

		assertTrue(test.getContrasena().equals("test"));

	}

	@Test
	void setContrasenaTest() {

		/** test de setter de SolicitudJwt.setContrasena */

		test.setContrasena("test2");
		assertTrue(test.getContrasena().equals("test2"));

	}

}
