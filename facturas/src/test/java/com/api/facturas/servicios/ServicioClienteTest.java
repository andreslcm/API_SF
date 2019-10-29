package com.api.facturas.servicios;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.api.facturas.dtos.ClienteDtoTester;
import com.api.facturas.dtos.UsuarioDtoTester;
import com.api.facturas.excepciones.RecursoNoEncontrado;
import com.api.facturas.modelos.Cliente;
import com.api.facturas.modelos.Factura;
import com.api.facturas.modelos.Usuario;


class ServicioClienteTest {
	
	/**  ServicioCliente para usar en varios test */
	
	ServicioCliente serviciotest;
	Usuario testy;
	ClienteDtoTester dto;
	ServicioUsuario serv;
	
	
	@BeforeClass
	void setUp() { 
		
	/**  setUp para usar en los test  */
		
		testy = serv.crearUsuario((new UsuarioDtoTester(117.0, "testn", "testa",
				"testnu","testc","testcor","testdir","testcid","testes",
				"testpa","testcod","testtel","testdb","testdp",
				"testpayoneer")));
		
		dto = new ClienteDtoTester(44.0,"testn","testdir",
				"testc", "teste","testp", "testcod", "testtel",
				"testcorel", 999, 999.0, 999.0,
				999.0, (999.0, 999.0, 999.0);
		
	}
	
	@Test
	void agregarClienteYListarClientesTest() {
		
		/** test de ServicioCliente.agregarCliente() y ServicioCliente.ListarClientes
		 * @param dto
		 * ClienteDtoTester*/
		
		serviciotest.agregarCliente(dto, 117.0);
		assertTrue(enLista(serviciotest.listarClientes(117.0)));

	}
	
	@Test
	void eliminarClienteTest() {
		
		/** test de ServicioCliente.eliminarCliente() */
		
		serviciotest.eliminarCliente(44.0);
		assertFalse(enLista(serviciotest.listarClientes(117.0)));
		doThrow( new RecursoNoEncontrado("No hay ningún cliente con el ID número " + 321)).when(serviciotest).eliminarCliente(321.0);

	}
	
	
	@Test
	void modificarClienteTest() {
		
		/** test de ServicioCliente.modificarCliente() */
		
		ClienteDtoTester dto2 = new ClienteDtoTester(44.0,"nombredistinto","testdir",
				"testc", "teste","testp", "testcod", "testtel",
				"testcorel", 999, 999.0, 999.0,
				999.0, 999.0, 999.0, 999.0);
		
		serviciotest.modificarCliente(dto2,44.0);
		assertTrue(enListaMod(serviciotest.listarClientes(117.0), dto2));
		doThrow( new RecursoNoEncontrado("No hay ningún cliente con el ID número " + 321)).when(serviciotest).modificarCliente(dto2, 321.0);

	}
	
	
	
	public boolean enLista(List<ClienteDtoTester> lista) {
		
		/** metodo para asistir en los @test
		 * @param lista
		 * lista de ClienteDtoTester */
		
		for (ClienteDtoTester cliente : lista) {
			if (cliente.equals(dto)) return true;
		}
		return false;
	}
	
	public boolean enListaMod(List<ClienteDtoTester> lista, ClienteDtoTester dto) {
		
		/** metodo para asistir en los @test 
		 * @param lista, dto
		 * lista de ClienteDtoTester y ClienteDtoTester*/
		for (ClienteDtoTester cliente : lista) {
			if (cliente.getNombreCliente().equals(dto.getNombreCliente())) return true;
		}
		return false;
	}
	
	

}