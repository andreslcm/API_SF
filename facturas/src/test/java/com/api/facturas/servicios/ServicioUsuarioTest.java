package com.api.facturas.servicios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.api.facturas.dtos.DtoUsuario;
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
		
		usuarioTest = new DtoUsuario((long) 117, "testn", "testa", "testnu",
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
	
	
	
	
	


	
	
	
	
	
}