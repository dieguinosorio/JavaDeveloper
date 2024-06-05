package Banco;

import Banco.interfaces.ServiciosClientes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Banco implements ServiciosClientes {
    private String nombre;
    private Domicilio domicilio;
    private String rfc;
    private String telefono;

    private List<Cliente> clientes;

    public Banco(String nombre, Domicilio domicilio, String rfc, String telefono) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.rfc = rfc;
        this.telefono = telefono;
        this.clientes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "nombre='" + nombre + '\'' +
                ", domicilio=" + domicilio +
                ", rfc='" + rfc + '\'' +
                ", telefono='" + telefono + '\'' +
                ", clientes=" + clientes +
                '}';
    }

    @Override
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public void eliminarCliente(int numeroCliente) {
        clientes = clientes.stream()
                .filter(cliente -> !cliente.getNumero().equals(numeroCliente))
                .collect(Collectors.toList());
    }

    @Override
    public Cliente consultarCliente(int numeroCliente) {
        return clientes.stream()
                .filter( cliente -> cliente.getNumero().equals(numeroCliente))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return clientes;
    }

    @Override
    public Cliente buscarClientePorRFC(String rfc) {
        return clientes.stream()
                .filter( cliente -> cliente.getRfc().equals(rfc))
                .findFirst()
                .orElse(null);
    }
}
