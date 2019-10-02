package com.api.facturas.modelos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import com.api.facturas.dtos.DtoFactura;

class DetalleFacturaTest {

	/** DetalleFactura para usar en varios test */

	DetalleFactura detalletest;
	Factura facturatest;

	@BeforeClass
	void setUp() {

		/** seteado de variables para todas las pruebas */

		detalletest = new DetalleFactura();
		facturatest = new Factura();

	}

	@Test
	void constructorTest() {

		/** test de constructor */

		assertNotNull(detalletest);
		assertTrue(detalletest instanceof DetalleFactura);
	}

	@Test
	void getDescripcionProyectoTest() {

		/** test de getter de DetalleFactura.descripcionProyecto */

		assertTrue(detalletest.getDescripcionProyecto().equals("test"));

	}

	@Test
	void setDescripcionProyectoTest() {

		/** test de setter de DetalleFactura.descripcionProyecto */

		detalletest.setDescripcionProyecto("test");
		assertTrue(detalletest.getDescripcionProyecto().equals("test"));

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