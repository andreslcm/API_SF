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
import com.api.facturas.dtos.DtoCliente;
import com.api.facturas.dtos.DtoDetalleFactura;
import com.api.facturas.dtos.DtoFactura;
import com.api.facturas.dtos.DtoUsuario;
import com.api.facturas.dtos.FacturaDtoTester;
import com.api.facturas.dtos.UsuarioDtoTester;
import com.api.facturas.dtos.EnvoltorioTester;
import com.api.facturas.excepciones.RecursoNoEncontrado;
import com.api.facturas.modelos.Cliente;
import com.api.facturas.modelos.EnvoltorioFactura;
import com.api.facturas.modelos.Factura;
import com.api.facturas.modelos.Usuario;



class ServicioFacturaTest {
	
	/**  ServicioFactura para usar en varios test */
	
	
	ServicioFactura serviciotest;
	ServicioCliente serviciotest2;
	ServicioUsuario serviciotest3;
	DtoCliente dto;
	DtoUsuario dto2;
	DtoFactura dto3;
	DtoDetalleFactura dto4;
	EnvoltorioFactura envoltoriotest;
	List<DtoDetalleFactura> arraytest;
	
	
	@BeforeClass
	void setUp() { 
		
	/**  setUp para usar en los test  */
		
		
		dto = new ClienteDtoTester((long)44, "testn","testdir",
				"testc", "teste","testp", "testcod", "testtel",
				"testcorel", 999, 999.0, 999.0,
				999.0, 999.0, 999.0, 999.0);
		
		dto2 = new UsuarioDtoTester((long)117, "testn", "testa",
				"testnu","testc","testcor","testdir","testcid","testes",
				"testpa","testcod","testtel","testdb","testdp",
				"testpayoneer");
		
		Date datetest = new Date();
		
		dto3 = new FacturaDtoTester((long)77, (long)77, "orden", datetest,
				datetest, 77.0, 77.0, 77.0,
				"notas", false );
		
		dto4 = new DtoDetalleFactura();
		dto4.setIdDetalleFactura((long)88);
		dto4.setDescripcionProyecto("descripcion");
		dto4.setMonto(88.0);
		
		arraytest = new ArrayList<>();
		arraytest.add(dto4);
		
		serviciotest3.crearusUario(dto2);
		
		serviciotest2.agregarCliente(dto, (long)117);
				
		envoltoriotest = new EnvoltorioTester(dto3, arraytest);
		
	}
	
	
	@Test
	void agregarFacturaYListarFacturaTest() {
		
		/** test de ServicioFactura.agregarFactura() , ServicioFactura.listarFacturas() y servicioFactura.listarFacturasPorCliente */
		
		
		serviciotest.agregarFactura(envoltoriotest, (long)117, (long)44);
		doThrow( new RecursoNoEncontrado("No existe ningún usuario con el ID " + 321)).when(serviciotest).agregarFactura(envoltoriotest, 312.0, 44.0);
		doThrow( new RecursoNoEncontrado("No existe ningún cliente con el ID " + 321)).when(serviciotest).agregarFactura(envoltoriotest, 117.0, 321.0);
		assertTrue(facturaEnLista(serviciotest.listarFacturas((long)117)));
		assertTrue(facturaEnLista(serviciotest.listarFacturasPorCliente((long)44)));
	}
	
	
	@Test
	void modificarFacturaTest() {
		
		/** test de ServicioFactura.modificarFactura()*/
		
		envoltoriotest.setFactura( new FacturaDtoTester((long)77, (long)77, "ordencambiada", new Date(),
				new Date(), 77.0, 77.0, 77.0,
				"notas", false ));
		serviciotest.modificarFactura(envoltoriotest, (long)77);
		doThrow( new RecursoNoEncontrado("No existe una factura con el ID " + 321)).when(serviciotest).modificarFactura(envoltoriotest, 321.0);
		assertFalse(facturaEnLista(serviciotest.listarFacturas((long) 77)));

	}
	
	@Test
	void eliminarFacturaTest() {
		
		/** test de ServicioFactura.eliminarFactura()*/
		
		List<Long> id = new ArrayList<>();
		List<Long> id2 = new ArrayList<>();
		id.add((long)77);
		id2.add((long)321);
		serviciotest.eliminarFactura(id);
		doThrow( new RecursoNoEncontrado("No existe ninguna factura con el ID " + 321)).when(serviciotest).eliminarFactura(id2);
		assertTrue(facturaEnLista(serviciotest.listarFacturas((long)77)));

	}
	
	@Test
	void pagarFacturaTest() {
		
		/** test de ServicioFactura.pagarFactura()*/
		
		List<Long> id = new ArrayList<>();
		List<Long> id2 = new ArrayList<>();
		id.add((long)77);
		id2.add((long)321);
		serviciotest.pagarFactura(id);
		doThrow( new RecursoNoEncontrado("No existe ninguna factura con el ID " + 321)).when(serviciotest).pagarFactura(id2);
		assertTrue(facturaPagadaEnLista(serviciotest.listarFacturas((long)77), (long)77));

	}
	
	public boolean facturaEnLista(List<DtoFactura> list) {
		
		/** metodo para asistir en los @test 
		 * @param lista
		 * una lista de DtoFacturas*/
		
		for (DtoFactura factura : list) {
			if (factura.equals(dto3)) return true;
		}
		return false;
	}
	
	public boolean facturaPagadaEnLista(List<DtoFactura> list, Long id) {
		
		/** metodo para asistir en los @test 
		 * @param lista, id
		 * una lista de DtoFactura y un Long*/
		
		for (DtoFactura factura : list) {
			if (factura.getIdFactura() == id && factura.getEstaPagada()) return true;
		}
		return false;
	}
	
	

}