package com.api.facturas.servicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
     * 
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

    /**
     * Método para listar una lista de usuario a partir de si id.
     * 
     * @param idUsuario
     * @return {List<DtoCliente> listaClientes}
     */
    public List<DtoCliente> listarClientes(Long idUsuario) {
        List<DtoCliente> listaClientes = new ArrayList<>();
        repoClientes.listarClientes(idUsuario).forEach(cliente -> {
            DtoCliente clienteDto = new DtoCliente(cliente);
            listaClientes.add(clienteDto);
        });
        return listaClientes;
    }

    /**
     * Método para eliminar a un cliente de la base de datos.
     * 
     * @param idCliente
     */
    public void eliminarCliente(Long idCliente) {
        Cliente cliente = repoClientes.encontrarPorId(idCliente);
        repoClientes.delete(cliente);
    }

}