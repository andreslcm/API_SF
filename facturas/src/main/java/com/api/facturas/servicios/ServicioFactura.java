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
                .orElseThrow(() -> new RecursoNoEncontrado("No existe ningún usuario con el ID " + idUsuario));

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

    /**
     * Método para listar las facturas por cliente.
     * 
     * @param idCliente
     * @return {List<DtoFactura> listaFacturas}
     */
    public List<DtoFactura> listarFacturasPorCliente(Long idCliente) {
        List<DtoFactura> listaFacturas = new ArrayList<>();

        repoFacturas.listarFacturasPorIdCliente(idCliente)
                .forEach(factura -> listaFacturas.add(new DtoFactura(factura)));

        return listaFacturas;
    }

    /**
     * Método para modificar una factura y sus detalles.
     * 
     * @param envoltorio
     * @param idFactura
     */
    public void modificarFactura(EnvoltorioFactura envoltorio, Long idFactura) {

        int auxiliar = 0;
        Factura factura = repoFacturas.encontrarFacturaPorId(idFactura)
                .orElseThrow(() -> new RecursoNoEncontrado("No existe una factura con el ID " + idFactura));
        factura.actualizarFactura(envoltorio.getFactura());
        List<DetalleFactura> detalles = repoDetalle.listarDetalles(idFactura);
        List<DetalleFactura> borrarDetalles = new ArrayList<>();

        // Se borran todos los detalles existentes para cargar los detalles nuevo.
        detalles.forEach(detalle -> {
            repoDetalle.delete(detalle);
            borrarDetalles.add(detalle);
        });

        detalles.removeAll(borrarDetalles);

        for (DtoDetalleFactura detalleDto : envoltorio.getDetalles()) {
            detalles.add(new DetalleFactura(detalleDto));
            detalles.get(auxiliar).setFactura(factura);
            auxiliar++;
        }

        factura.setDetalleFactura(detalles);
        detalles.forEach(detalle -> repoDetalle.save(detalle));
        repoFacturas.save(factura);
    }

    /**
     * Método para eliminar una factura de la BD.
     * 
     * @param idFactura
     */
    public void eliminarFactura(List<Long> idFactura) {

        idFactura.forEach(id -> {
            List<DetalleFactura> detalles = repoDetalle.listarDetalles(id);
            repoDetalle.deleteAll(detalles);
        });
        idFactura.forEach(id -> {
            Factura factura = repoFacturas.encontrarFacturaPorId(id)
                    .orElseThrow(() -> new RecursoNoEncontrado("No existe ninguna factura con el ID " + idFactura));
            repoFacturas.delete(factura);
        });
    }

    /**
     * Método para marcar una factura como pagada.
     * @param idFactura
     */
    public void pagarFactura(List<Long> idFactura) {
        
        idFactura.forEach(id -> {
            Factura factura = repoFacturas.encontrarFacturaPorId(id)
                    .orElseThrow(() -> new RecursoNoEncontrado("No existe ninguna factura con el ID " + idFactura));
            factura.setEstaPagada(true);
            repoFacturas.save(factura);
        });
    }

}
