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
	void getIdTest() {

		/** test de getter de RespuestaHtto.getId */

		assertTrue(test.getId() == 11);

	}

	@Test
	void setIdTest() {

		/** test de setter de RespuestaHttp.setId */

		test.setId(12);
		assertTrue(test.getId() == 12);

	}

}
