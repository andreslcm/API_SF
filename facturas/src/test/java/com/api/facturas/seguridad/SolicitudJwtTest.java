package com.api.facturas.seguridad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.api.facturas.modelos.DetalleFactura;
import com.api.facturas.modelos.Factura;

class SolicitudJwtTest {

	/** SolicitudJwt para usar en varios test */

	SolicitudJwt test;

	@BeforeClass
	void setUp() {

		/** seteado de variables para todas las pruebas */

		test = new SolicitudJwt("test", "test");

	}


	@Test
	void getNombreUsuarioTest() {

		/** test de getter de SolicitudJwt.getNombreUsuario */

		assertTrue(test.getNombreUsuario().equals("test"));

	}

	@Test
	void setNombreUsuarioTest() {

		/** test de setter de SolicitudJwt.setNombreUsuario */

		test.setNombreUsuario("test2");
		assertTrue(test.getNombreUsuario().equals("test2"));

	}

	@Test
	void getMontoTest() {

		/** test de getter de DetalleFactura.monto */

		assertTrue(detalletest.getMonto() == 1000);

	}

	@Test
	void setMontoTest() {

		/** test de setter de DetalleFactura.monto */

		detalletest.setMonto(10);
		assertTrue(detalletest.getMonto() == 10);

	}

	@Test
	void setAndgetFacturaTest() {

		/** test de getter y setter de DetalleFactura.factura */

		detalletest.setFactura(facturatest);
		assertTrue(detalletest.getFactura().equals(facturatest));
	}

}
