package Banco.services;

import Banco.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private static final String URL = "jdbc:mysql://localhost:3306/banco";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public List<Cliente> obtenerClientes() {
        List<Cliente> listaClientes = new ArrayList<>();
        String sql = "SELECT id, nombre, domicilio, codigo, telefono, fecha_nacimiento FROM clientes";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String codigo = resultSet.getString("codigo");
                String telefono = resultSet.getString("telefono");
                String fechaNacimiento = resultSet.getString("fecha_nacimiento");
                Cliente cliente = new Cliente(id, nombre, null, codigo, telefono, null, fechaNacimiento);
                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaClientes;
    }

    private List<String> obtenerCuentasPorCliente(int clienteId) {
        List<String> cuentas = new ArrayList<>();
        String sql = "SELECT cuenta FROM cuentas WHERE cliente_id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, clienteId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    cuentas.add(resultSet.getString("cuenta"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cuentas;
    }
}
