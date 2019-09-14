package com.api.facturas.modelos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.api.facturas.dtos.DtoCliente;
import com.api.facturas.dtos.DtoFactura;

class FacturaTest {

	Factura testfactura;
	DtoFactura dtoTest;
	List<DetalleFactura> facturasTest;
	Usuario usuariotest;
	Date datetest;

	@BeforeClass
	void setUp() {

		/** seteado de variables para todas las pruebas */
		datetest = new Date();
		testfactura = new Factura(1000, new Date());
		dtoTest = new DtoFactura(1001, new Date());
		facturasTest = new ArrayList<Factura>();
		facturasTest.add(new DetalleFactura("test", 4321));
		usuariotest = new Usuario("nombre", "apellido", "nombreusuario", "contraseña", "correo", "direccion", "ciudad",
				"estado", "pais", "codigopostal", "telefono");

	}

	@Test
	void constructorTest() {

		/** test de constructor */

		assertNotNull(testfactura);
		assertTrue(testfactura instanceof Factura);
		Factura constructorTest = new Factura(dtoTest);
		assertNotNull(constructorTest);
		assertTrue(constructorTest instanceof Factura);
	}

	@test
	void setAndgetUsuarioTest() {

		/** test de getter y setter de Factura.usuario */

		testfactura.setUsuario(usuariotest);
		assertTrue(testfactura.getUsuario().equals(usuariotest));
	}

	@test
	void setAndgetDetalleFacturaTest() {

		/** test de getter y setter de Factura.detalleFactura */

		testfactura.setDetalleFactura(facturasTest);
		assertTrue(testfactura.getDetalleFactura().equals(facturasTest));
	}

	@Test
	void setNotasTest() {

		/** test de setter de Factura.Notas */

		testfactura.setNotas("test");
		assertTrue(testfactura.getNotas().equals("test"));

	}

	@Test
	void getNotasTest() {

		/** test de getter de Factura.Notas */

		assertTrue(testfactura.getNotas().equals("test"));

	}

	@Test
	void setAndgetFechaFacturaTest() {

		/** test de setter y getter de Factura.fechaFactura */

		testfactura.setFechaFactura(datetest);
		assertTrue(testfactura.getFechaFactura().equals(datetest));

	}

	@Test
	void setAndgetFechaVencimientoTest() {

		/** test de setter y getter de Factura.fechaVencimiento */

		testfactura.setFechaVencimiento(datetest);
		assertTrue(testfactura.getFechaVencimiento().equals(datetest));

	}

	@Test
	void setSubtotalTest() {

		/** test de setter de Factura.subtotal */

		testfactura.setSubtotal(1000);
		assertTrue(testfactura.getSubtotal() == 1000);

	}

	@Test
	void getSubtotalTest() {

		/** test de getter de Factura.subtotal */

		assertTrue(testfactura.getSubtotal() == 1000);

	}

	@Test
	void setImpuestosTest() {

		/** test de setter de Factura.impuestos */

		testfactura.setImpuestos(1000);
		assertTrue(testfactura.getImpuestos() == 1000);

	}

	@Test
	void getImpuestosTest() {

		/** test de getter de Factura.impuestos */

		assertTrue(testfactura.getImpuestos() == 1000);

	}

	@Test
	void setTotalTest() {

		/** test de setter de Factura.total */

		testfactura.setTotal(1000);
		assertTrue(testfactura.getTotal() == 1000);

	}

	@Test
	void getTotalTest() {

		/** test de getter de Factura.total */

		assertTrue(testfactura.getTotal() == 1000);

	}

	@Test
	void setNotasTest() {

		/** test de setter de Factura.notas */

		testfactura.setNotas("test");
		assertTrue(testfactura.getNotas().equals("test"));

	}

	@Test
	void getNotasTest() {

		/** test de getter de Factura.notas */

		assertTrue(testfactura.getNotas().equals("test"));

	}

}