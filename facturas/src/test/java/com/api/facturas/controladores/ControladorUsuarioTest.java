package com.api.facturas.controladores;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.api.facturas.dtos.ClienteDtoTester;
import com.api.facturas.dtos.DtoCliente;
import com.api.facturas.dtos.DtoUsuario;
import com.api.facturas.dtos.UsuarioDtoTester;
import com.api.facturas.servicios.ServicioCliente;
import com.api.facturas.servicios.ServicioUsuario;

class ControladorUsuarioTest {

	
	
	
	/**  ControladorUsuarioTest para usar en varios test */
	
	ControladorUsuario test;
	DtoUsuario dto;
	DtoUsuario dto2;
	ServicioUsuario serviciotest;
	
	
	@BeforeClass
	void setUp() { 
		
	/**  setUp para usar en los test  */
		
		dto = new UsuarioDtoTester((long)117, "testn", "testa",
				"testnu","testc","testcor","testdir","testcid","testes",
				"testpa","testcod","testtel","testdb","testdp",
				"testpayoneer");
	}
	
	@Test
	void RegistrarUsuarioTest() {
		
		/**  test de ControladorUsuario.registrarUsuario()
		 * @param dto 
		 * @param long*/
		
		test.registrarUsuario(dto);
		assertTrue((serviciotest.consultarDatos((long)117).equals(dto)));

	}
	
	@Test
	
	void actualizarDatosTest() {
		
		/**  test de ControladorUsuario.actualizarDatos()  */
		test.actualizarDatos(dto2, (long)117);
		assertTrue(serviciotest.consultarDatos(((long)117)).equals(dto2));
	}
	
	@Test
	
	void obtenerDatosUsuarioTest() {
		
		/**  test de ControladorUsuario.obtenerDatosUsuario()  */
		
		assertTrue(serviciotest.consultarDatos(((long)117)).equals(dto2));
	}
	
}
	