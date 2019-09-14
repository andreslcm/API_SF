package com.api.facturas.modelos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.api.facturas.dtos.DtoUsuario;



/** Para testear la clase Usuario
 *
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
	
	@Test
	void getCiudadTest() {
		
		/** test de getter de Usuario.ciudad */
		
		assertTrue(usuarioTest.getCiudad().equals("ciudad"));

	}
	
	@Test
	void setCiudadTest() {
		
		/** test de setter de Usuario.ciudad */
		
		usuarioTest.setCiudad("test");
		assertTrue(usuarioTest.getCiudad().equals("test"));

	}
	
	@Test
	void getPaisTest() {
		
		/** test de getter de Usuario.pais */
		
		assertTrue(usuarioTest.getPais().equals("pais"));

	}
	
	@Test
	void setPaisTest() {
		
		/** test de setter de Usuario.pais */
		
		usuarioTest.setPais("test");
		assertTrue(usuarioTest.getPais().equals("test"));

	}
	
	@Test
	void getEstadoTest() {
		
		/** test de getter de Usuario.estado */
		
		assertTrue(usuarioTest.getEstado().equals("estado"));

	}
	
	@Test
	void setEstadoTest() {
		
		/** test de setter de Usuario.estado */
		
		usuarioTest.setEstado("test");
		assertTrue(usuarioTest.getEstado().equals("test"));

	}
	
	@Test
	void getTelefonoTest() {
		
		/** test de getter de Usuario.telefono */
		
		assertTrue(usuarioTest.getTelefono().equals("telefono"));

	}
	
	@Test
	void setTelefonoTest() {
		
		/** test de setter de Usuario.telefono */
		
		usuarioTest.setTelefono("test");
		assertTrue(usuarioTest.getTelefono().equals("test"));

	}
	
	
	@Test
	void getCodigoPostalTest() {
		
		/** test de getter de Usuario.codigoPostal */
		
		assertTrue(usuarioTest.getCodigoPostal().equals("codigopostal"));

	}
	
	@Test
	void setCodigoPostalTest() {
		
		
		/** test de setter de Usuario.codigoPostal */
		usuarioTest.setCodigoPostal("test");
		assertTrue(usuarioTest.getCodigoPostal().equals("test"));

	}
	
	@Test
	void getCorreoTest() {
		
		/** test de getter de Usuario.codigo */
		
		assertTrue(usuarioTest.getCorreo().equals("codigo"));

	}
	
	@Test
	void setCorreoTest() {
		
		/** test de setter de Usuario.codigo */
		
		usuarioTest.setCodigoPostal("test");
		assertTrue(usuarioTest.getCodigoPostal().equals("test"));

	}
	
	@Test
	void getNombreUsuarioTest() {
		
		/** test de getter de Usuario.nombreUsuario */
		
		assertTrue(usuarioTest.getNombreUsuario().equals("nombreusuario"));

	}
	
	@Test
	void setNombreUsuarioTest() {
		
		/** test de setter de Usuario.nombreUsuario */
		
		usuarioTest.setNombreUsuario("test");
		assertTrue(usuarioTest.getNombreUsuario().equals("test"));

	}
	
	@Test
	void getContraseñaTest() {
		
		/** test de getter de Usuario.contraseña */
		
		assertTrue(usuarioTest.getContraseña().equals("contraseña"));

	}
	
	@Test
	void setContraseñaTest() {
		
		/** test de setter de Usuario.contraseña */
		
		usuarioTest.setContraseña("test");
		assertTrue(usuarioTest.getContraseña().equals("test"));

	}
	
	@Test
	void setAndGetDatosPaylpalTest() {
		
		/** test de setter de Usuario.paylPal */
		
		usuarioTest.setDatosPaylpal("test");
		assertTrue(usuarioTest.getDatosPaylpal().equals("test"));

	}
	
	@Test
	void getAndSetDatosBancoTest() {
		
		/** test de getter de Usuario.datosBanco */
		
		usuarioTest.setDatosBanco("test");
		assertTrue(usuarioTest.getDatosBanco().equals("test"));

	}
	
	@Test
	void getAndSetDatosPayoneerTest() {
		
		/** test de getter de Usuario.datosPayonner */
		
		usuarioTest.setDatosPayoneer("test");
		assertTrue(usuarioTest.getDatosPayoneer().equals("test"));

	}
	
	@Test
	void getNombreTest() {
		
		/** test de getter de Usuario.nombre */
		
		assertTrue(usuarioTest.getNombre().equals("nombre"));

	}
	
	@Test
	void setNombreTest() {
		
		/** test de setter de Usuario.nombre */
		
		usuarioTest.setNombre("test");
		assertTrue(usuarioTest.getNombre().equals("test"));

	}
	
	@Test
	void getApellidoTest() {
		
		/** test de getter de Usuario.apellido */
		
		assertTrue(usuarioTest.getApellido().equals("apellido"));

	}
	
	@Test
	void setApellidoTest() {
		
		/** test de setter de Usuario.apellido */
		
		usuarioTest.setApellido("test");
		assertTrue(usuarioTest.getApellido().equals("test"));

	}
	
	@Test
	void getDireccionTest() {
		
		/** test de getter de Usuario.direccion */
		
		assertTrue(usuarioTest.getDireccion().equals("direccion"));

	}
	
	@Test
	void setDireccionTest() {
		
		/** test de setter de Usuario.direccion */
		
		usuarioTest.setDireccion("test");
		assertTrue(usuarioTest.getDireccion().equals("test"));

	}
}