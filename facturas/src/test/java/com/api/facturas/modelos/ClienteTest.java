package com.api.facturas.modelos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.api.facturas.dtos.DtoCliente;

/**
 * Para testear la clase Cliente
 * 
 */

class ClienteTest {

	/** Cliente para usar en varios test */

	Cliente testcliente;
	ClienteDtoTester dtoTest;
	List<Factura> facturasTest;
	List<Cliente> clientesTest;

	@BeforeClass
	void setUp() {

		/** seteado de variables para todas las pruebas */

		Cliente testcliente = new Cliente();
		DtoCliente dtoTest = new ClienteDtoTester();
		facturasTest = new ArrayList<Factura>();
		facturasTest.add(new Factura());
		clientesTest = new ArrayList<Cliente>();
		clientesTest.add(new Cliente());

	}

	@Test
	void constructorTest() {

		/** test de constructor */

		assertNotNull(testcliente);
		assertTrue(testcliente instanceof Cliente);
		Cliente constructorTest = new Cliente(dtoTest);
		assertNotNull(constructorTest);
		assertTrue(constructorTest instanceof Cliente);
	}

	@Test
	void getIdtestcliente() {

		/** test de getter de Cliente.IdCliente */

		assertNotNull(testcliente.getIdCliente());
		assertTrue(testcliente.getIdCliente() instanceof Long);

	}

	@Test
	void setIdtestcliente() {

		/** test de setter de Cliente.IdCliente */

		testcliente.setIdCliente(1234);
		assertNotNull(testcliente.getIdCliente());
		assertTrue(testcliente.getIdCliente() == 1234);

	}

	@Test
	void getCiudadTest() {

		/** test de getter de Cliente.ciudad */

		assertTrue(testcliente.getCiudad().equals("ciudad"));

	}

	@Test
	void setCiudadTest() {

		/** test de setter de Cliente.ciudad */

		testcliente.setCiudad("test");
		assertTrue(testcliente.getCiudad().equals("test"));

	}

	@Test
	void getPaisTest() {

		/** test de getter de Cliente.pais */

		assertTrue(testcliente.getPais().equals("pais"));

	}

	@Test
	void setPaisTest() {

		/** test de setter de Cliente.pais */

		testcliente.setPais("test");
		assertTrue(testcliente.getPais().equals("test"));

	}

	@Test
	void getEstadoTest() {

		/** test de getter de Cliente.estado */

		assertTrue(testcliente.getEstado().equals("estado"));

	}

	@Test
	void setEstadoTest() {

		/** test de setter de Cliente.estado */

		testcliente.setEstado("test");
		assertTrue(testcliente.getEstado().equals("test"));

	}

	@Test
	void getTelefonoTest() {

		/** test de getter de Cliente.telefono */

		assertTrue(testcliente.getTelefono().equals("telefono"));

	}

	@Test
	void setTelefonoTest() {

		/** test de setter de Cliente.telefono */

		testcliente.setTelefono("test");
		assertTrue(testcliente.getTelefono().equals("test"));

	}

	@Test
	void getCodigoPostalTest() {

		/** test de getter de Cliente.codigoPostal */

		assertTrue(testcliente.getCodigoPostal().equals("codigopostal"));

	}

	@Test
	void setCodigoPostalTest() {

		/** test de setter de Cliente.codigoPostal */
		testcliente.setCodigoPostal("test");
		assertTrue(testcliente.getCodigoPostal().equals("test"));

	}

	@Test
	void getCorreoTest() {

		/** test de getter de Cliente.codigo */

		assertTrue(testcliente.getCorreoElectronico().equals("codigo"));

	}

	@Test
	void setCorreoTest() {

		/** test de setter de Cliente.codigo */

		testcliente.setCodigoPostal("test");
		assertTrue(testcliente.getCodigoPostal().equals("test"));

	}

	@Test
	void getNombreTest() {

		/** test de getter de Cliente.nombre */

		assertTrue(testcliente.getNombreCliente().equals("nombre"));

	}

	@Test
	void setNombreTest() {

		/** test de setter de Cliente.nombre */

		testcliente.setNombreCliente("test");
		assertTrue(testcliente.getNombreCliente().equals("test"));

	}

	@Test
	void getDireccionTest() {

		/** test de getter de Cliente.direccion */

		assertTrue(testcliente.getDireccion().equals("direccion"));

	}

	@Test
	void setDireccionTest() {

		/** test de setter de Cliente.direccion */

		testcliente.setDireccion("test");
		assertTrue(testcliente.getDireccion().equals("test"));

	}

	@Test
	void setTerminoPagoTest() {

		/** test de setter de Cliente.terminoPago */

		testcliente.setTerminoPago(1000);
		assertTrue(testcliente.getTerminoPago() == 1000);

	}

	@Test
	void getTerminoPagoTest() {

		/** test de getter de Cliente.terminoPago */

		assertTrue(testcliente.getTerminoPago() == 1000);

	}

	@Test
	void setPalabraTraduccionTest() {

		/** test de setter de Cliente.palabraTraduccion */

		testcliente.setPalabraTraduccion(1000);
		assertTrue(testcliente.getPalabraTraduccion() == 1000);

	}

	@Test
	void getPalabraTraduccionTest() {

		/** test de getter de Cliente.palabraTraduccion */

		assertTrue(testcliente.getPalabraTraduccion() == 1000);

	}

	@Test
	void setHoraTraduccionTest() {

		/** test de setter de Cliente.horaTraduccion */

		testcliente.setHoraTraduccion(1000);
		assertTrue(testcliente.getHoraTraduccion() == 1000);

	}

	@Test
	void getHoraTraduccionTest() {

		/** test de getter de Cliente.horaTraduccion */

		assertTrue(testcliente.getHoraTraduccion() == 1000);

	}

	@Test
	void setPalabraEdicionTest() {

		/** test de setter de Cliente.palabraEdicion */

		testcliente.setPalabraEdicion(1000);
		assertTrue(testcliente.getPalabraEdicion() == 1000);

	}

	@Test
	void getPalabraEdicionTest() {

		/** test de getter de Cliente.palabraEdicion */

		assertTrue(testcliente.getPalabraEdicion() == 1000);

	}

	@Test
	void setHoraEdicionTest() {

		/** test de setter de Cliente.horaEdicion */

		testcliente.setHoraEdicion(1000);
		assertTrue(testcliente.getHoraEdicion() == 1000);

	}

	@Test
	void getHoraEdicionTest() {

		/** test de getter de Cliente.horaEdicion */

		assertTrue(testcliente.getHoraEdicion() == 1000);

	}

	@Test
	void setPalabraProofreadingTest() {

		/** test de setter de Cliente.palabraProofreading */

		testcliente.setPalabraProofreading(1000);
		assertTrue(testcliente.getPalabraProofreading() == 1000);

	}

	@Test
	void getPalabraProofreadingTest() {

		/** test de getter de Cliente.palabraProofreading */

		assertTrue(testcliente.getPalabraProofreading() == 1000);

	}

	@Test
	void setHoraProofreadingTest() {

		/** test de setter de Cliente.horaProofreading */

		testcliente.setHoraProofreading(1000);
		assertTrue(testcliente.getHoraProofreading() == 1000);

	}

	@Test
	void getHoraProofreadingTest() {

		/** test de getter de Cliente.horaProofreading */

		assertTrue(testcliente.getHoraProofreading() == 1000);

	}

}