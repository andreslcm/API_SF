package com.api.facturas.controladores;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import com.api.facturas.dtos.ClienteDtoTester;
import com.api.facturas.dtos.DtoCliente;
import com.api.facturas.dtos.DtoDetalleFactura;
import com.api.facturas.dtos.DtoFactura;
import com.api.facturas.dtos.DtoUsuario;
import com.api.facturas.dtos.EnvoltorioTester;
import com.api.facturas.dtos.FacturaDtoTester;
import com.api.facturas.dtos.UsuarioDtoTester;
import com.api.facturas.modelos.EnvoltorioFactura;
import com.api.facturas.servicios.ServicioCliente;
import com.api.facturas.servicios.ServicioFactura;
import com.api.facturas.servicios.ServicioUsuario;

class ControladorFacturaTest {
	
	
	
	/**  ControladorFacturaTest para usar en varios test */
	
	ControladorFactura test;
	ServicioCliente serviciotest;
	DtoCliente dto;
	DtoUsuario dto2;
	DtoFactura dto3;
	EnvoltorioFactura dto4;
	DtoFactura dto5;
	List<DtoDetalleFactura> lista;
	ServicioUsuario serviciotest2;
	ServicioFactura serviciotest3;
	
	
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
		
		Date datetest = new Date();
		lista = new ArrayList<>();
		
		dto3 = new FacturaDtoTester((long)77, (long)77, "orden", datetest,
				datetest, 77.0, 77.0, 77.0,
				"notas", false );
		
		dto4 = new EnvoltorioTester(dto3, lista);
		
		dto5 = new FacturaDtoTester((long)77, (long)77, "orden", datetest,
				datetest, 77.0, 77.0, 77.0,
				"notas", true );
		
		serviciotest2.crearUsuario(dto2);
		serviciotest.agregarCliente(dto, (long)117);
		
		
	}
	
	@Test
	void agregarFacturaTest() {
		
		/**  test de Controladorfactura.agregarFactura()
		 * @param dto 
		 * @param long*/
		
		test.agregarFactura(dto4, (long)117, (long)44);
		assertTrue(serviciotest3.listarFacturas((long)117).contains(dto3));

	}

	@Test
	void listarFacturaTest() {
		
		/**  test de ControladorFactura.listarFactura()
		 * 
		 * @param dto 
		 * @param long*/
		
		ResponseEntity responsetest = test.listarFacturas((long)117);
		assertTrue(((List<DtoDetalleFactura>) responsetest.getBody()).contains(dto3));

	}
	
	@Test
	void listarFacturaPorClienteTest() {
		
		/**  test de ControladorFactura.listarFacturaPorCliente()
		 * 
		 * @param dto 
		 * @param long*/
		
		ResponseEntity responsetest = test.listarFacturasPorCliente((long)44);
		assertTrue(((List<DtoDetalleFactura>) responsetest).contains(dto3));

	}
	
	
	@Test
	void modificarFacturaTest() {
		
		/**  test de ControladorFactura.modificarFactura()
		 * 
		 * @param dto5
		 * @param dto4
		 * @param long*/
		
		dto4.setFactura(dto5);

		test.modificarFactura(dto4, (long)77);
		ResponseEntity responsetest = test.listarFacturas((long)117);
		assertTrue(((List<DtoDetalleFactura>) responsetest).contains(dto5));

	}
	
	@Test
	void eliminarFacturaTest() {
		
		/**  test de ControladorFactura.eliminarFactura()
		 * 
		 * @param long*/
	
		ArrayList<Long> arraytest = new ArrayList<>();
		arraytest.add((long)77);
		ResponseEntity responsetest = test.eliminarFactura((arraytest));
		assertTrue(!((List<DtoDetalleFactura>) responsetest).contains(dto3));

	}
	
	@Test
	void pagarFacturaTest() {
		
		/**  test de ControladorFactura.pagarFactura()
		 * 
		 * @param long*/
	
		ArrayList<Long> arraytest = new ArrayList<>();
		arraytest.add((long)77);
		ResponseEntity responsetest = test.pagarFactura(arraytest);
		assertTrue(((List<DtoDetalleFactura>) responsetest).contains(dto5));

	}
	
	
	
	public boolean enLista(List<DtoFactura> lista, DtoFactura dto) {
		
		/** metodo para asistir en los @test
		 * @param lista
		 * lista de DtoCliente */
		
		for (DtoFactura factura : lista) {
			if (factura.equals(dto)) return true;
		}
		return false;
	}


}
	
