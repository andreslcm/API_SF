package com.api.facturas.dtos;
import java.util.List;

import com.api.facturas.dtos.DtoDetalleFactura;
import com.api.facturas.dtos.DtoFactura;
import com.api.facturas.modelos.EnvoltorioFactura;

public class EnvoltorioTester extends EnvoltorioFactura{


        /**
     * Constructor para propositos de testeo
     *  @param fac, det
     */
    public EnvoltorioTester(DtoFactura fac, List<DtoDetalleFactura> det) {
    	setFactura(fac);
    	setDetalles(det);
    }
    
    


}