package com.api.facturas.seguridad;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;

class HerramientaTokenTest {

	/** HerramientaToken para usar en varios test */

	HerramientaToken test;
	UserDetails usertest;
	String tokentest;

	@BeforeClass
	void setUp() {

		/** seteado de variables para todas las pruebas */

		test = new HerramientaToken();
		tokentest = test.generarToken(usertest);

	}
	
	@Test
	void validarTokenTest() {

		/** test de HerramientaToken.validarToken */

		assertTrue(test.validarToken(tokentest, usertest));

	}
	
	@Test
	void obtenerFechaVencimientoTokenTest() {

		/** test de HerramientaToken.obtenerFechaVencimientoToken */

		assertTrue(test.obtenerFechaVencimientoToken(tokentest) instanceof Date);

	}
	
	@Test
	void getNombreUsuarioTokenTest() {

		/** test de HerramientaToken.getNombreUsuarioToken */

		assertTrue(test.getNombreUsuarioToken(tokentest).equals(usertest.getUsername()));

	}
	
	

	



}
