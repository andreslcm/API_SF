package com.api.facturas.servicios;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.api.facturas.dtos.ClienteDtoTester;
import com.api.facturas.dtos.DtoDetalleFactura;
import com.api.facturas.dtos.DtoFactura;
import com.api.facturas.dtos.UsuarioDtoTester;
import com.api.facturas.excepciones.RecursoNoEncontrado;
import com.api.facturas.modelos.Cliente;
import com.api.facturas.modelos.Factura;
import com.api.facturas.modelos.Usuario;



class ServicioFacturaTest {
	
	/**  ServicioFactura para usar en varios test */
	
	
	ServicioFactura serviciotest;
	ServicioCliente serviciotest2;
	ServicioUsuario serviciotest3;
	ClienteDtoTester dto;
	UsuarioDtoTester dto2;
	FacturaDtoTester dto3;
	DtoDetalleFactura dto4;
	EnvoltorioTester envoltoriotest;
	List<DtoDetalleFactura> arraytest;
	
	
	@BeforeClass
	void setUp() { 
		
	/**  setUp para usar en los test  */
		
		
		dto = new ClienteDtoTester(44.0,"testn","testdir",
				"testc", "teste","testp", "testcod", "testtel",
				"testcorel", 999, 999.0, 999.0,
				999.0, 999.0, 999.0, 999.0;
		
		dto2 = new UsuarioDtoTester(117.0, "testn", "testa",
				"testnu","testc","testcor","testdir","testcid","testes",
				"testpa","testcod","testtel","testdb","testdp",
				"testpayoneer");
		
		Date datetest = new Date();
		
		dto3 = new FacturaDtoTester(77.0, 77.0, "orden", datetest,
				datetest, 77.0, 77.0, 77.0,
				"notas", false );
		
		dto4 = new DtoDetalleFactura(88.0, "descripcion", 88.0);
		
		arraytest = new ArrayList<>();
		arraytest.add(dto4);
		
		serviciotest3.crearusUario(dto2);
		
		serviciotest2.agregarCliente(dto,117.0);
				
		envoltoriotest = new EnvoltorioTester(dto3, arraytest);
		
	}
	
	
	@Test
	void agregarFacturaYListarFacturaTest() {
		
		/** test de ServicioFactura.agregarFactura() , ServicioFactura.listarFacturas() y servicioFactura.listarFacturasPorCliente */
		
		
		serviciotest.agregarFactura(envoltoriotest, 117.0,44.0);
		doThrow( new RecursoNoEncontrado("No existe ningún usuario con el ID " + 321)).when(serviciotest).agregarFactura(envoltoriotest, 312.0, 44.0);
		doThrow( new RecursoNoEncontrado("No existe ningún cliente con el ID " + 321)).when(serviciotest).agregarFactura(envoltoriotest, 117.0, 321.0);
		assertTrue(facturaEnLista(serviciotest.listarFacturas(117.0)));
		assertTrue(facturaEnLista(serviciotest.listarFacturasPorCliente(44.0)));
	}
	
	
	@Test
	void modificarFacturaTest() {
		
		/** test de ServicioFactura.modificarFactura()*/
		
		envoltoriotest.setFactura( new FacturaDtoTester(77.0, 77.0, "ordencambiada", new Date(),
				new Date(), 77.0, 77.0, 77.0,
				"notas", false ));
		serviciotest.modificarFactura(envoltoriotest, 77.0);
		doThrow( new RecursoNoEncontrado("No existe una factura con el ID " + 321)).when(serviciotest).modificarFactura(envoltoriotest, 321.0);
		assertFalse(facturaEnLista(serviciotest.listarFacturas(77.0)));

	}
	
	@Test
	void eliminarFacturaTest() {
		
		/** test de ServicioFactura.eliminarFactura()*/
		
		List<Long> id = new ArrayList<>();
		List<Long> id2 = new ArrayList<>();
		id.add(77.0);
		id2.add(321.0);
		serviciotest.eliminarFactura(id);
		doThrow( new RecursoNoEncontrado("No existe ninguna factura con el ID " + 321)).when(serviciotest).eliminarFactura(id2);
		assertTrue(facturaEnLista(serviciotest.listarFacturas(77.0)));

	}
	
	@Test
	void pagarFacturaTest() {
		
		/** test de ServicioFactura.pagarFactura()*/
		
		List<Long> id = new ArrayList<>();
		List<Long> id2 = new ArrayList<>();
		id.add(77.0);
		id2.add(321.0);
		serviciotest.pagarFactura(id);
		doThrow( new RecursoNoEncontrado("No existe ninguna factura con el ID " + 321)).when(serviciotest).pagarFactura(id2);
		assertTrue(facturaPagadaEnLista(serviciotest.listarFacturas(77.0), 77.0));

	}
	
	public boolean facturaEnLista(List<FacturaDtoTester> lista) {
		
		/** metodo para asistir en los @test 
		 * @param lista
		 * una lista de DtoFacturas*/
		
		for (FacturaDtoTester factura : lista) {
			if (factura.equals(dto3)) return true;
		}
		return false;
	}
	
	public boolean facturaPagadaEnLista(List<FacturaDtoTester> lista, Long id) {
		
		/** metodo para asistir en los @test 
		 * @param lista, id
		 * una lista de DtoFactura y un Long*/
		
		for (FacturaDtoTester factura : lista) {
			if (factura.getIdFactura() == id && factura.getEstaPagada()) return true;
		}
		return false;
	}
	
	

}