import Banco.Banco;
import Banco.Domicilio;
import Banco.Cliente;
import Banco.*;
import Banco.services.ClienteService;

import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ClienteService clienteDao = new ClienteService();
        ArrayList<Domicilio> listaDomicilios = new ArrayList<>();
        listaDomicilios.add(new Domicilio("Calle 32", 10, "colonia 1", "Estado 1", 50001));
        listaDomicilios.add(new Domicilio("Calle 33", 11, "colonia 2", "Estado 3", 50003));
        listaDomicilios.add(new Domicilio("Banco", 11, "colonia 001", "Estado banco", 50002));

        ArrayList<CuentaAhorro> listaCuentasAhorro = new ArrayList<>();
        listaCuentasAhorro.add(new CuentaAhorro(1, 10.2, 100000.1));
        listaCuentasAhorro.add(new CuentaAhorro(2, 0.10, 20000.00));

        ArrayList<CuentaCheque> listaCuentasCheque = new ArrayList<>();
        listaCuentasCheque.add(new CuentaCheque(5, 10.2, 100000.1));
        listaCuentasCheque.add(new CuentaCheque(6, 0.10, 20000.00));

        ArrayList<Cuenta> cuentasCliente1 = new ArrayList<>();
        cuentasCliente1.add(listaCuentasAhorro.get(0));
        cuentasCliente1.add(listaCuentasCheque.get(0));

        ArrayList<Cuenta> cuentasCliente2 = new ArrayList<>();
        cuentasCliente2.add(listaCuentasAhorro.get(1));
        cuentasCliente2.add(listaCuentasCheque.get(1));

        //Obtenemos los clientes de la BD
        List<Cliente> listaClientes = clienteDao.obtenerClientes();

        Banco banco = new Banco("Banco Test", listaDomicilios.get(2), "123", "1234-122");
        banco.setClientes(listaClientes);

        System.out.println("Información del Banco:");
        System.out.println(banco);
        System.out.println("Lista de clientes del banco:");
        System.out.println(banco.getClientes());


        //Solucion implementando las interfaces
        Banco banco2 = new Banco("Banco Test", listaDomicilios.get(2), "123", "1234-122");
        listaClientes.forEach(banco2::agregarCliente);

        System.out.println("Información del Banco:");
        System.out.println(banco2);
        System.out.println("Lista de clientes del banco:");
        System.out.println(banco2.getClientes());

        Cliente primerCliente = banco2.obtenerClientes().get(0);
        System.out.println("Cuentas del primer cliente:");
        System.out.println(primerCliente.obtenerCuentas());

        Cuenta cuentaAhorroCliente1 = primerCliente.obtenerCuentas().get(0);
        Cuenta cuentaChequeCliente1 = primerCliente.obtenerCuentas().get(1);

        primerCliente.abonarCuenta(cuentaAhorroCliente1.getNumero(), 5000.0);

        primerCliente.retirar(cuentaChequeCliente1.getNumero(), 200.0);

        System.out.println("Cuentas actualizadas del primer cliente:");
        System.out.println(primerCliente.obtenerCuentas());

        //Solucion implementando Comparator
        Collections.sort(listaClientes);
        System.out.println("---- Imprimo los clientes ordenados ----");
        listaClientes.forEach(cliente -> System.out.println(cliente.getNumero()));

        Collections.sort(cuentasCliente1);
        System.out.println("---- Imprimo las cuentas ordenadas ----");
        cuentasCliente1.forEach(cuenta -> System.out.println(cuenta.getSaldo()));
    }

    public static void cargarClientes() {
        String url = "jdbc:mysql://localhost:3306/banco";
        String user = "root";
        String password = "admin1234";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM clientes");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("columnname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}