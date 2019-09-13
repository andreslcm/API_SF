package com.api.facturas.controladores;

import com.api.facturas.modelos.EnvoltorioFactura;
import com.api.facturas.servicios.ServicioFactura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ControladorFactura
 */

@RestController
@CrossOrigin
public class ControladorFactura {

    @Autowired
    private ServicioFactura servicio;

    /**
     * Método para agregar una factura a la BD.
     * 
     * @param envoltorio
     * @param idUsuario
     * @param idCliente
     * @return
     */
    @PostMapping("crear-factura/{idUsuario}")
    public ResponseEntity<?> agregarFactura(@RequestBody EnvoltorioFactura envoltorio,
            @PathVariable(value = "idUsuario") Long idUsuario, @RequestParam(value = "idCliente") Long idCliente) {

        servicio.agregarFactura(envoltorio, idUsuario, idCliente);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
