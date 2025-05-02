package main.java.com.Gym360.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import main.java.com.Gym360.model.classes.Cliente;
import main.java.com.Gym360.util.database.DatabaseConnection;

public class ClienteDAO {

    public boolean insertar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean resultado = false;

        try {
            conn = DatabaseConnection.conectar();
            String sql = "INSERT INTO Cliente (id, nombre, apellido, telefono, email, saldo, tipo_membresia) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            pst = conn.prepareStatement(sql);
            pst.setString(1, cliente.getId());
            pst.setString(2, cliente.getNombre());
            pst.setString(3, cliente.getApellido());
            pst.setString(4, cliente.getTelefono());
            pst.setString(5, cliente.getEmail());
            pst.setDouble(6, cliente.getSaldo());
            pst.setString(7, cliente.getTipoMembresia());

            int filas = pst.executeUpdate();
            if (filas > 0) {
                resultado = true;
            }

        } catch (SQLException e) {
            System.err.println("Error al insertar cliente: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return resultado;
    }

    public boolean actualizar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement pst = null;
        boolean resultado = false;

        try {
            conn = DatabaseConnection.conectar();
            String sql = "UPDATE Cliente SET nombre = ?, apellido = ?, telefono = ?, "
                    + "email = ?, saldo = ?, tipo_membresia = ? WHERE id = ?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellido());
            pst.setString(3, cliente.getTelefono());
            pst.setString(4, cliente.getEmail());
            pst.setDouble(5, cliente.getSaldo());
            pst.setString(6, cliente.getTipoMembresia());
            pst.setString(7, cliente.getId());

            int filas = pst.executeUpdate();
            if (filas > 0) {
                resultado = true;
            }

        } catch (SQLException e) {
            System.err.println("Error al actualizar cliente: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, null);
        }

        return resultado;
    }

    public boolean eliminar(String id) {
        Connection conn = null;
        PreparedStatement pst = null;
        boolean resultado = false;

        try {
            conn = DatabaseConnection.conectar();
            String sql = "DELETE FROM Cliente WHERE id = ?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, id);

            int filas = pst.executeUpdate();
            if (filas > 0) {
                resultado = true;
            }

        } catch (SQLException e) {
            System.err.println("Error al eliminar cliente: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, null);
        }

        return resultado;
    }

    public Cliente obtenerPorId(String id) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Cliente cliente = null;

        try {
            conn = DatabaseConnection.conectar();
            String sql = "SELECT * FROM Cliente WHERE id = ?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, id);

            rs = pst.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getString("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSaldo(rs.getDouble("saldo"));
                cliente.setTipoMembresia(rs.getString("tipo_membresia"));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener cliente: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return cliente;
    }

    public List<Cliente> obtenerTodos() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            conn = DatabaseConnection.conectar();
            String sql = "SELECT * FROM Cliente";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getString("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSaldo(rs.getDouble("saldo"));
                cliente.setTipoMembresia(rs.getString("tipo_membresia"));

                clientes.add(cliente);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener todos los clientes: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return clientes;
    }

    public List<Cliente> obtenerPorMembresia(String tipoMembresia) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Cliente> resultado = new ArrayList<>();

        try {
            conn = DatabaseConnection.conectar();
            String sql = "SELECT * FROM Cliente WHERE tipo_membresia = ?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, tipoMembresia);

            rs = pst.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getString("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSaldo(rs.getDouble("saldo"));
                cliente.setTipoMembresia(rs.getString("tipo_membresia"));

                resultado.add(cliente);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener clientes por membresía: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return resultado;
    }
}
