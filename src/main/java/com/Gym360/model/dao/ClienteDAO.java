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

    public List<Cliente> obtenerPorIdFiltro(String filtro) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            conn = DatabaseConnection.conectar();
            String sql = "SELECT * FROM Cliente WHERE id LIKE ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, filtro + "%");

            rs = pst.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getString("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEmail(rs.getString("email"));
                cliente.setContraseña(rs.getString("contraseña"));
                cliente.setSaldo(rs.getDouble("saldo"));
                cliente.setTipoMembresia(rs.getString("tipo_membresia"));
                cliente.setEstado(rs.getString("estado"));

                clientes.add(cliente);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener clientes por ID parcial: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return clientes;
    }

    public boolean insertar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement pst = null;
        boolean resultado = false;

        try {
            conn = DatabaseConnection.conectar();
            String sql = "INSERT INTO Cliente (id, nombre, apellido, telefono, email, contraseña, saldo, tipo_membresia, estado) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            pst = conn.prepareStatement(sql);
            pst.setString(1, cliente.getId());
            pst.setString(2, cliente.getNombre());
            pst.setString(3, cliente.getApellido());
            pst.setString(4, cliente.getTelefono());
            pst.setString(5, cliente.getEmail());
            pst.setString(6, cliente.getContraseña());
            pst.setDouble(7, cliente.getSaldo());
            pst.setString(8, cliente.getTipoMembresia());
            pst.setString(9, cliente.getEstado());

            resultado = pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al insertar cliente: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, null);
        }

        return resultado;
    }

    public boolean actualizar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement pst = null;
        boolean resultado = false;

        try {
            conn = DatabaseConnection.conectar();
            String sql = "UPDATE Cliente SET nombre = ?, apellido = ?, telefono = ?, email = ?, contraseña = ?, saldo = ?, tipo_membresia = ?, estado = ? WHERE id = ?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellido());
            pst.setString(3, cliente.getTelefono());
            pst.setString(4, cliente.getEmail());
            pst.setString(5, cliente.getContraseña());
            pst.setDouble(6, cliente.getSaldo());
            pst.setString(7, cliente.getTipoMembresia());
            pst.setString(8, cliente.getEstado());
            pst.setString(9, cliente.getId());

            resultado = pst.executeUpdate() > 0;

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

            resultado = pst.executeUpdate() > 0;

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
                cliente.setContraseña(rs.getString("contraseña"));
                cliente.setSaldo(rs.getDouble("saldo"));
                cliente.setTipoMembresia(rs.getString("tipo_membresia"));
                cliente.setEstado(rs.getString("estado"));
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
                cliente.setContraseña(rs.getString("contraseña"));
                cliente.setSaldo(rs.getDouble("saldo"));
                cliente.setTipoMembresia(rs.getString("tipo_membresia"));
                cliente.setEstado(rs.getString("estado"));

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
                cliente.setContraseña(rs.getString("contraseña"));
                cliente.setSaldo(rs.getDouble("saldo"));
                cliente.setTipoMembresia(rs.getString("tipo_membresia"));
                cliente.setEstado(rs.getString("estado"));

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
