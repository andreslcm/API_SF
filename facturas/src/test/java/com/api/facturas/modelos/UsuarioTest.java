package com.api.facturas.modelos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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
	List<Factura> facturasTest;
	List<Cliente> clientesTest;
	
	@BeforeClass
	void setUp() { 
		
		/** seteado de variables para todas las pruebas */
		
	Usuario usuarioTest = new Usuario("nombre", "apellido", "nombreusuario", "contraseña", "correo", "direccion", 
            "ciudad", "estado", "pais", "codigopostal", "telefono");
	DtoUsuario dtoTest = new DtoUsuario("dtonombre", "dtoapellido", "dtonombreusuario", "dtocontraseña", "dtocorreo", "dtodireccion", 
            "dtociudad", "dtoestado", "dtopais", "dtocodigopostal", "dtotelefono");
	facturasTest = new ArrayList<Factura>();
	facturasTest.add(new Factura(1234,4321));
	clientesTest = new ArrayList<Cliente>();
	clientesTest.add(new Cliente("nombreCliente", "direccion", "ciudad", "estado", "pais","codigoPostal"));
	
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
	
	@Test
	void getFacturasTest() {
		
		/** test de getter de Usuario.facturas */
		
		assertTrue(usuarioTest.getFacturas() instanceof List<Factura>);

	}
	
	@Test
	void setFacturasTest() {
		
		/** test de setter de Usuario.facturas */
		
		usuarioTest.setFacturas(facturasTest);
		assertTrue(usuarioTest.getFacturas().equals(facturasTest));

	}
	
	@Test
	void getClientesTest() {
		
		/** test de getter de Usuario.clientes */
		
		assertTrue(usuarioTest.getClientes() instanceof List<Cliente>);

	}
	
	@Test
	void setClientesTest() {
		
		/** test de setter de Usuario.clientes */
		
		usuarioTest.setCliente(clientesTest);
		assertTrue(usuarioTest.getClientes().equals(clientesTest));

	}
	
	
	
}