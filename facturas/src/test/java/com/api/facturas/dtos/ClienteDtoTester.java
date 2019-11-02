package com.api.facturas.dtos;

import com.api.facturas.dtos.DtoCliente;

public class ClienteDtoTester extends DtoCliente {



        /**
     * Constructor para propositos de testeo
     * 
     * 
     * @param id,nombre,direccion,ciudad,estado,pais,codpos,tel,corel,termpago,
     * paltrac,paled,palproo,horatra,horaed,horaproo
     */
    
    
    public ClienteDtoTester(Long id, String nombre, String direccion,
    		String ciudad, String estado, String pais, String codpos,
    		String tel, String corel, int termpago, Double paltrac,
    		Double paled, Double palproo, Double horatra, Double horaed, Double horaproo) {
    	
        setIdCliente(id);
        setNombreCliente(nombre);
        setDireccion(direccion);
        setCiudad(ciudad);
        setEstado(estado);
        setPais(pais);
        setCodigoPostal(codpos);
        setTelefono(tel);
        setCorreoElectronico(corel);
        setTerminoPago(termpago);
        setPalabraTraduccion(paltrac);
        setPalabraEdicion(paled);
        setPalabraProofreading(palproo);
        setHoraTraduccion(horatra);
        setHoraEdicion(horaed);
        setHoraProofreading(horaproo);
       
    }

    
    
}


