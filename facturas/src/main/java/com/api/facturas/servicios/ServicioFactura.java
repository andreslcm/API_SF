package com.api.facturas.servicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.api.facturas.dtos.DtoDetalleFactura;
import com.api.facturas.dtos.DtoFactura;
import com.api.facturas.excepciones.RecursoNoEncontrado;
import com.api.facturas.modelos.Cliente;
import com.api.facturas.modelos.DetalleFactura;
import com.api.facturas.modelos.EnvoltorioFactura;
import com.api.facturas.modelos.Factura;
import com.api.facturas.modelos.Usuario;
import com.api.facturas.repositorios.RepositorioClientes;
import com.api.facturas.repositorios.RepositorioDetalles;
import com.api.facturas.repositorios.RepositorioFacturas;
import com.api.facturas.repositorios.RepositorioUsuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ServicioFactura
 */
@Service
public class ServicioFactura {

    @Autowired
    RepositorioClientes repoClientes;
    @Autowired
    RepositorioFacturas repoFacturas;
    @Autowired
    RepositorioUsuarios repoUsuarios;
    @Autowired
    RepositorioDetalles repoDetalle;

    /**
     * Método para agregar una factura y asignarla a un cliente y a un usuario.
     * 
     * @param envoltorio
     * @param idUsuario
     * @param idCliente
     */
    public void agregarFactura(EnvoltorioFactura envoltorio, Long idUsuario, Long idCliente) {
        List<DetalleFactura> detalles = new ArrayList<>();
        Factura factura = new Factura(envoltorio.getFactura());
        int auxiliar = 0;
        Cliente cliente = repoClientes.encontrarPorId(idCliente)
                .orElseThrow(() -> new RecursoNoEncontrado("No existe ningún cliente con el ID " + idCliente));
        Usuario usuario = repoUsuarios.findById(idUsuario)
                .orElseThrow(() -> new RecursoNoEncontrado("No existe ningún usuario con el ID " + idCliente));

        // Se asginan entre sí tanto las facturas como el usuario y el cliente para que
        // Hibernate haga las relaciones correspondiestes al momento de generar la
        // tabla.
        factura.setCliente(cliente);
        factura.setUsuario(usuario);
        cliente.setFacturas(Arrays.asList(factura));
        usuario.setFacturas(Arrays.asList(factura));

        // Se agregan los detalles correspondientes a cada factura.
        for (DtoDetalleFactura detalle : envoltorio.getDetalles()) {
            detalles.add(new DetalleFactura(detalle));
            detalles.get(auxiliar).setFactura(factura);
            auxiliar++;
        }

        factura.setDetalleFactura(detalles);

        // Se guarda la factura en la BD.
        repoFacturas.save(factura);

        // Se guarda cada detalle en la BD.
        detalles.forEach(detalle -> repoDetalle.save(detalle));
    }

    /**
     * Método para listar las facturas correspondientes a un usuario.
     * 
     * @param idUsuario
     * @return {List<DtoFacturas>} listaFacturas
     */
    public List<DtoFactura> listarFacturas(Long idUsuario) {
        List<DtoFactura> listaFacturas = new ArrayList<>();

        repoFacturas.listarFacturasPorIdUsuario(idUsuario)
                .forEach(factura -> listaFacturas.add(new DtoFactura(factura)));

        return listaFacturas;
    }

}
