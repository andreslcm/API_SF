package com.api.facturas.controladores;

import com.api.facturas.dtos.DtoCliente;
import com.api.facturas.servicios.ServicioCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ControladorCliente
 */
@RestController
@CrossOrigin
public class ControladorCliente {

    @Autowired
    private ServicioCliente servicio;

    /**
     * Método para agregar un cliente.
     * 
     * @param cliente
     * @param idUsuario
     * @return {ResponseEntity<>}
     */
    @PostMapping(value = "/agregar-cliente/{idUsuario}")
    public ResponseEntity<?> agregarCliente(@RequestBody DtoCliente cliente,
            @PathVariable("idUsuario") Long idUsuario) {
        servicio.agregarCliente(cliente, idUsuario);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

}