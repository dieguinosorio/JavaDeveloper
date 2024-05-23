import Banco.Banco;
import Banco.Domicilio;
import Banco.Cliente;
import Banco.*;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ArrayList<Domicilio> listaDomicilios = new ArrayList<>();
        listaDomicilios.add(new Domicilio("Calle 32",10, "colonia 1", "Estado 1", 50001));
        listaDomicilios.add(new Domicilio("Calle 33",11, "colonia 2", "Estado 3", 50003));
        listaDomicilios.add(new Domicilio("Banco",11, "colonia 001", "Estado banco", 50002));

        ArrayList<CuentaAhorro> listaCuentasAhorro = new ArrayList<CuentaAhorro>();
        listaCuentasAhorro.add(new CuentaAhorro(0001, 10.2, 100000.1));
        listaCuentasAhorro.add(new CuentaAhorro(0002, 0.10, 20000.00));

        ArrayList<CuentaCheque> listaCuentasCheque= new ArrayList<CuentaCheque>();
        listaCuentasCheque.add(new CuentaCheque(0005, 10.2, 100000.1));
        listaCuentasCheque.add(new CuentaCheque(0006, 0.10, 20000.00));

        ArrayList<Cuenta> cuentasCliente1 = new ArrayList<Cuenta>();
        cuentasCliente1.add(listaCuentasAhorro.get(0));
        cuentasCliente1.add(listaCuentasCheque.get(0));

        ArrayList<Cuenta> cuentasCliente2 = new ArrayList<Cuenta>();
        cuentasCliente1.add(listaCuentasAhorro.get(1));
        cuentasCliente1.add(listaCuentasCheque.get(1));

        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        listaClientes.add(new Cliente(1, "Pepito", listaDomicilios.get(0), "001", "12345", cuentasCliente1, "1992-01-01"));
        listaClientes.add(new Cliente(2, "Jaime", listaDomicilios.get(1), "002", "12345", cuentasCliente2, "1993-01-01"));

        Banco banco = new Banco("Banco Test", listaDomicilios.get(2),"123", "1234-122");
        banco.setClientes(listaClientes);

        System.out.println("Información del Banco:");
        System.out.println(banco.toString());
        System.out.println("Lista de clientes del banco");
        System.out.println(banco.getClientes());
    }
}