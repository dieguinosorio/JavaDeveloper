package Banco.interfaces;

import Banco.Cliente;

import java.util.ArrayList;
import java.util.List;

public interface ServiciosClientes {
    void agregarCliente(Cliente cliente);
    void eliminarCliente(int numeroCliente);
    Cliente consultarCliente(int numeroCliente);
    List<Cliente> obtenerClientes();
    Cliente buscarClientePorRFC(String rfc);
}
