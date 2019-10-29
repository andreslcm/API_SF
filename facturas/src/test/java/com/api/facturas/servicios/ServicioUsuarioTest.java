package com.api.facturas.servicios;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.api.facturas.dtos.DtoUsuario;
import com.api.facturas.excepciones.RecursoNoEncontrado;
import com.api.facturas.modelos.Cliente;
import com.api.facturas.modelos.Factura;
import com.api.facturas.modelos.Usuario;

class ServicioUsuarioTest {

	/**  ServicioUsuario para usar en varios test */
	
	ServicioUsuario servicioTest;
	DtoUsuario usuarioTest;
	
	@BeforeClass
	void setUp() { 
		
	/**  setUp de DtoUsuario para usar en los test  */
		
		usuarioTest = new DtoUsuario(117.0, "testn", "testa", "testnu",
				"testc","testcor","testdir","testcid","testes","testpa",
				"testcod","testtel","testdb","testdp","testpayoneer");
		
	}
	
	@Test
	void crearUsuarioTest() {
		
		/** test de ServicioUsuario.crearUsuario() */
		
		Usuario testy = servicioTest.crearusUario(usuarioTest);
		
		assertNotNull(testy);
		assertTrue(testy instanceof Usuario);
		assertTrue(testy.equals(new Usuario(usuarioTest)));
	}
	
	@Test
	void verificacionNombreUsuarioTest() {
		
		/** test de ServicioUsuario.verificacionNombreUsuario() */
		
		assertTrue(servicioTest.verificacionNombreUsuario("testnu"));
		assertFalse(servicioTest.verificacionNombreUsuario("testnuuuuu"));
	}
	
	@Test
	void verificacionCorreoTest() {
		
		/** test de ServicioUsuario.verificacionCorreo() */
		
		assertTrue(servicioTest.verificacionNombreUsuario("testcor"));
		assertFalse(servicioTest.verificacionNombreUsuario("testcoooooooooooooooor"));
	}
	
	@Test
	void actualizarDatosTest() {
		
		/** test de ServicioUsuario.actualizarDatos() */
		
		servicioTest.actualizarDatos(new DtoUsuario(117.0, "testn", "testa", "actualizartest",
				"testc","testcor","testdir","testcid","testes","testpa",
				"testcod","testtel","testdb","testdp","testpayoneer"), 117.0);
		assertTrue(servicioTest.verificacionNombreUsuario("actualizartest"));
		doThrow( new RecursoNoEncontrado("No existe un usuario con el ID " + 321)).when(servicioTest).actualizarDatos(usuarioTest, 321.0);
	}
	
	@Test
	void consultarDatosTest() {
		
		/** test de ServicioUsuario.consultarDatos() */
		
		assertTrue(servicioTest.consultarDatos(117.0).equals(usuarioTest));
		doThrow( new RecursoNoEncontrado("No existe un usuario con el ID " + 321)).when(servicioTest).consultarDatos(321.0);
		
	}
	


	
	
	


	
	
	
	
	
}