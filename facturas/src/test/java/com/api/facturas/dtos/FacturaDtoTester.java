package com.api.facturas.dtos;
import java.util.Date;

import com.api.facturas.dtos.DtoFactura;

public class FacturaDtoTester extends DtoFactura{

        /**
     * Constructor para propositos de testeo
     * 
     * 
     * @param id,numfac, orden, fechafac, fechaven, sobtot, imp, total, notas,
     *  pagada
     */
    
    public FacturaDtoTester(Long id, Long numfac, String orden, Date fechafac,
    		Date fechaven, Double subtot, Double imp, Double total,
    		String notas, boolean pagada) {
    	
    	setIdFactura(id);
    	setNumeroFactura(numfac);
    	setOrdenCompra(orden);
    	setFechaFactura(fechafac);
    	setFechaVencimiento(fechaven);
    	setSubtotal(subtot);
    	setImpuestos(imp);
    	setTotal(total);
    	setNotas(notas);
    	setEstaPagada(pagada);
    	
    }




}