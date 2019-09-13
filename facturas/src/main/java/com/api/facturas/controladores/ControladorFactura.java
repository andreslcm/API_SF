package com.api.facturas.controladores;

import java.util.List;

import com.api.facturas.dtos.DtoFactura;
import com.api.facturas.modelos.EnvoltorioFactura;
import com.api.facturas.servicios.ServicioFactura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
     * @return {ResponseEntity<>}
     */
    @PostMapping("crear-factura/{idUsuario}")
    public ResponseEntity<?> agregarFactura(@RequestBody EnvoltorioFactura envoltorio,
            @PathVariable(value = "idUsuario") Long idUsuario, @RequestParam(value = "idCliente") Long idCliente) {

        servicio.agregarFactura(envoltorio, idUsuario, idCliente);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Método para listar todas las facturas de un usuario
     * 
     * @param idUsuario
     * @return {ResponseEntity<>}
     */
    @GetMapping("listar-facturas/{idUsuario}")
    public ResponseEntity<?> listarFacturas(@PathVariable Long idUsuario) {

        List<DtoFactura> listaFacturas = servicio.listarFacturas(idUsuario);
        return new ResponseEntity<>(listaFacturas, HttpStatus.OK);
    }

    /**
     * Método para listar las facturas por cliente.
     * 
     * @param idCliente
     * @return{ResponseEntity<>}
     */
    @GetMapping("facturas-cliente/{idCliente}")
    public ResponseEntity<?> listarFacturasPorCliente(@PathVariable Long idCliente) {

        List<DtoFactura> listaFacturas = servicio.listarFacturasPorCliente(idCliente);
        return new ResponseEntity<>(listaFacturas, HttpStatus.OK);
    }

    /**
     * Método para actualizar datos de una factura
     * 
     * @param envoltorio
     * @param idFactura
     * @return {ResponseEntity<>}
     */
    @PutMapping("actualizar-factura/{idFactura}")
    public ResponseEntity<?> modificarFactura(@RequestBody EnvoltorioFactura envoltorio, @PathVariable Long idFactura) {

        servicio.modificarFactura(envoltorio, idFactura);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    
}
