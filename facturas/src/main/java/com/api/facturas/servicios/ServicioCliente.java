package com.api.facturas.servicios;

import java.util.Arrays;

import com.api.facturas.dtos.DtoCliente;
import com.api.facturas.modelos.Cliente;
import com.api.facturas.modelos.Usuario;
import com.api.facturas.repositorios.RepositorioClientes;
import com.api.facturas.repositorios.RepositorioFacturas;
import com.api.facturas.repositorios.RepositorioUsuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ServicioCliente
 */
@Service
public class ServicioCliente {

    @Autowired
    RepositorioFacturas repoFacturas;

    @Autowired
    RepositorioClientes repoClientes;

    @Autowired
    RepositorioUsuarios repoUsuarios;

    /**
     * Método para agregar un cliente a la base de datos a partir de un DTO.
     * @param dtoCliente
     * @param idUsuario
     */
    public void agregarCliente(DtoCliente dtoCliente, Long idUsuario) {
        Cliente cliente = new Cliente(dtoCliente);
        Usuario usuario = repoUsuarios.encontrarPorId(idUsuario);
        usuario.setClientes(Arrays.asList(cliente));
        cliente.setUsuario(usuario);
        repoClientes.save(cliente);
    }

}