package com.api.facturas.servicios;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.api.facturas.dtos.DtoCliente;
import com.api.facturas.dtos.DtoUsuario;
import com.api.facturas.modelos.Cliente;
import com.api.facturas.modelos.Factura;
import com.api.facturas.modelos.Usuario;


class ServicioClienteTest {
	
	/**  ServicioCliente para usar en varios test */
	
	ServicioCliente serviciotest;
	Usuario testy;
	Cliente cliente;
	DtoCliente dto;
	ServicioUsuario serv;
	
	
	@BeforeClass
	void setUp() { 
		
	/**  setUp para usar en los test  */
		
		testy = serv.crearusUario((new DtoUsuario((long) 117, "testn", "testa",
				"testnu","testc","testcor","testdir","testcid","testes",
				"testpa","testcod","testtel","testdb","testdp",
				"testpayoneer")));
		
		dto = new DtoCliente((long)44,"testn","testdir",
				"testc", "teste","testp", "testcod", "testtel",
				"testcorel", 999, (double) 999, (double) 999,
				(double) 999, (double) 999, (double) 999, (double) 999);
		
	}
	
	@Test
	void agregarClienteYListarClientesTest() {
		
		/** test de ServicioCliente.agregarCliente() y ServicioCliente.ListarClientes*/
		
		serviciotest.agregarCliente(dto, (long) 117);
		assertTrue(enLista(serviciotest.listarClientes((long)117)));

	}
	
	@Test
	void eliminarClienteTest() {
		
		/** test de ServicioCliente.eliminarCliente() */
		
		serviciotest.eliminarCliente((long)44);
		assertFalse(enLista(serviciotest.listarClientes((long)117)));

	}
	
	
	@Test
	void modificarClienteTest() {
		
		/** test de ServicioCliente.modificarCliente() */
		
		DtoCliente dto2 = new DtoCliente((long)44,"nombredistinto","testdir",
				"testc", "teste","testp", "testcod", "testtel",
				"testcorel", 999, (double) 999, (double) 999,
				(double) 999, (double) 999, (double) 999, (double) 999);
		
		serviciotest.modificarCliente(dto2, (long) 44);
		assertTrue(enListaMod(serviciotest.listarClientes((long)117), dto2));

	}
	
	
	
	public boolean enLista(List<DtoCliente> lista) {
		for (DtoCliente cliente : lista) {
			if (cliente.equals(dto)) return true;
		}
		return false;
	}
	
	public boolean enListaMod(List<DtoCliente> lista, DtoCliente dto) {
		for (DtoCliente cliente : lista) {
			if (cliente.getNombreCliente().equals(dto.getNombreCliente())) return true;
		}
		return false;
	}
	
	

}