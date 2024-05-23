package Banco.interfaces;

import Banco.Cliente;

import java.util.ArrayList;

public interface ServiciosClientes {
    void agregarCliente(Cliente cliente);
    void eliminarCliente(int numeroCliente);
    Cliente consultarCliente(int numeroCliente);
    ArrayList<Cliente> obtenerClientes();
    Cliente buscarClientePorRFC(String rfc);
}
