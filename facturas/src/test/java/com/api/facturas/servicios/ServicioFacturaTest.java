package com.api.facturas.servicios;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.api.facturas.dtos.DtoCliente;
import com.api.facturas.dtos.DtoDetalleFactura;
import com.api.facturas.dtos.DtoFactura;
import com.api.facturas.dtos.DtoUsuario;
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
		
		
		dto = new DtoCliente((long)44,"testn","testdir",
				"testc", "teste","testp", "testcod", "testtel",
				"testcorel", 999, (double) 999, (double) 999,
				(double) 999, (double) 999, (double) 999, (double) 999);
		
		dto2 = new DtoUsuario((long) 117, "testn", "testa",
				"testnu","testc","testcor","testdir","testcid","testes",
				"testpa","testcod","testtel","testdb","testdp",
				"testpayoneer");
		
		Date datetest = new Date();
		
		dto3 = new DtoFactura((long) 77, (long) 77, "orden", datetest,
				datetest, (double) 77, (double) 77, (double) 77,
				"notas", false );
		
		dto4 = new DtoDetalleFactura((long)88, "descripcion", (double) 88);
		
		arraytest = new ArrayList<>();
		arraytest.add(dto4);
		
		serviciotest3.crearusUario(dto2);
		
		serviciotest2.agregarCliente(dto,(long) 117);
				
		envoltoriotest = new EnvoltorioFactura(dto3, arraytest);
		
	}
	

}