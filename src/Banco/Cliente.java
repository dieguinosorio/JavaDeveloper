package Banco;

import Banco.interfaces.ServiciosCuentas;

import java.util.ArrayList;

public class Cliente implements ServiciosCuentas {
    private Integer numero;
    private String nombre;
    private Domicilio domicilio;
    private String rfc;
    private String telefono;
    private ArrayList<Cuenta> cuentas;
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

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
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
        for (int i = 0; i < cuentas.size(); i++) {
            if (cuentas.get(i).getNumero().equals(numeroCuenta)) {
                cuentas.remove(i);
                break;
            }
        }
    }

    @Override
    public void abonarCuenta(int numeroCuenta, double monto) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumero().equals(numeroCuenta)) {
                cuenta.setSaldo(cuenta.getSaldo() + monto);
                break;
            }
        }
    }

    @Override
    public void retirar(int numeroCuenta, double monto) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumero().equals(numeroCuenta)) {
                double saldoActual = cuenta.getSaldo();
                if (saldoActual >= monto) {
                    cuenta.setSaldo(saldoActual - monto);
                } else {
                    System.out.println("No hay suficientes fondos para retirar.");
                }
                break;
            }
        }
    }

    @Override
    public ArrayList<Cuenta> obtenerCuentas() {
        return cuentas;
    }
}
