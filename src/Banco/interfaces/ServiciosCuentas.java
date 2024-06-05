package Banco.interfaces;

import Banco.Cuenta;

import java.util.ArrayList;
import java.util.List;

public interface ServiciosCuentas {
    void agregarCuenta(Cuenta cuenta);
    void cancelarCuenta(int numeroCuenta);
    void abonarCuenta(int numeroCuenta, double monto);
    void retirar(int numeroCuenta, double monto);
    List<Cuenta> obtenerCuentas();
}
