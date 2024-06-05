package Banco;

import Banco.interfaces.ServiciosCuentas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cliente implements ServiciosCuentas, Comparable<Cliente> {
    private Integer numero;
    private String nombre;
    private Domicilio domicilio;
    private String rfc;
    private String telefono;
    private List<Cuenta> cuentas;
    private String fechaNacimiento;

    public Cliente(Integer numero, String nombre, Domicilio domicilio, String rfc, String telefono, ArrayList<Cuenta> cuentas, String fechaNacimiento) {
        this.numero = numero;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.rfc = rfc;
        this.telefono = telefono;
        this.cuentas = cuentas;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cliente() {
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
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

    public List<Cuenta> getCuentas() {
        return cuentas.stream().collect(Collectors.toList());
    }

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "numero=" + numero +
                ", nombre='" + nombre + '\'' +
                ", domicilio=" + domicilio +
                ", rfc='" + rfc + '\'' +
                ", telefono='" + telefono + '\'' +
                ", cuentas=" + cuentas +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                '}';
    }

    @Override
    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    @Override
    public void cancelarCuenta(int numeroCuenta) {
        cuentas = cuentas.stream()
                .filter(cuenta -> !cuenta.getNumero().equals(numeroCuenta))
                .collect(Collectors.toList());
    }

    @Override
    public void abonarCuenta(int numeroCuenta, double monto) {
        cuentas.stream()
                .filter(cuenta -> cuenta.getNumero().equals(numeroCuenta))
                .findFirst()
                .ifPresent(cuenta -> cuenta.setSaldo(cuenta.getSaldo() + monto));
    }

    @Override
    public void retirar(int numeroCuenta, double monto) {
        cuentas.stream()
                .filter(cuenta -> cuenta.getNumero().equals(numeroCuenta))
                .findFirst()
                .ifPresent(cuenta -> {
                    double saldoActual = cuenta.getSaldo();
                    if (saldoActual >= monto) {
                        cuenta.setSaldo(saldoActual - monto);
                    } else {
                        System.out.println("No hay suficientes fondos para retirar.");
                    }
                });
    }

    @Override
    public List<Cuenta> obtenerCuentas() {
        return cuentas.stream().collect(Collectors.toList());
    }

    @Override
    public int compareTo(Cliente otroCliente) {
        return Integer.compare(this.getNumero(), otroCliente.getNumero());
    }
}
