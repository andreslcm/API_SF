package com.api.facturas.controladores;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.api.facturas.dtos.DtoCliente;
import com.api.facturas.dtos.DtoUsuario;
import com.api.facturas.excepciones.RecursoNoEncontrado;
import com.api.facturas.modelos.Usuario;
import com.api.facturas.controladores.ControladorCliente;
import com.api.facturas.dtos.ClienteDtoTester;
import com.api.facturas.servicios.ServicioCliente;
import com.api.facturas.servicios.ServicioUsuario;
import com.api.facturas.dtos.UsuarioDtoTester;

class ControladorClienteTest {
	

class ServicioClienteTest {
	
	/**  ServicioCliente para usar en varios test */
	
	ControladorCliente test;
	ServicioCliente serviciotest;
	DtoCliente dto;
	DtoUsuario dto2;
	ServicioUsuario serviciotest2;
	
	
	@BeforeClass
	void setUp() { 
		
	/**  setUp para usar en los test  */
		
		dto2 = new UsuarioDtoTester((long)117, "testn", "testa",
				"testnu","testc","testcor","testdir","testcid","testes",
				"testpa","testcod","testtel","testdb","testdp",
				"testpayoneer");
		
		dto = new ClienteDtoTester((long)44, "testn","testdir",
				"testc", "teste","testp", "testcod", "testtel",
				"testcorel", 999, 999.0, 999.0,
				999.0, 999.0, 999.0, 999.0);
		serviciotest2.crearUsuario(dto2);
		
		
	}
	
	@Test
	void agregarClienteTest() {
		
		/**  test de ControladorCliente.agregarCliente()
		 * @param dto 
		 * @param long*/
		
		test.agregarCliente(dto, (long)117);
		assertTrue(enLista(serviciotest.listarClientes((long)117)));

	}
	
	@test
	
	void listarClienteTest() {
		
		/**  test de ControladorCliente.listarCliente()  */
		
		assertTrue(test.listarCliente((long)117).getBody());
	}
	
	
	public boolean enLista(List<DtoCliente> lista) {
		
		/** metodo para asistir en los @test
		 * @param lista
		 * lista de DtoCliente */
		
		for (DtoCliente cliente : lista) {
			if (cliente.equals(dto)) return true;
		}
		return false;
	}


	}
	

}