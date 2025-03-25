package main.java.com.Gym360.model.dao;

import main.java.com.Gym360.model.classes.ClientSupplier;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.java.com.Gym360.util.database.DatabaseConnection;

public class ClientSupplierDAO {

    public List<ClientSupplier> getAll() {
        List<ClientSupplier> list = new ArrayList<>();
        String query = "SELECT * FROM ClienteProveedor";
        Connection conn = null;
        PreparedStatement pSt = null;
        ResultSet rs = null;
        
        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            rs = pSt.executeQuery();
            
            while (rs.next()) {
                ClientSupplier cs = new ClientSupplier();
                cs.setId(rs.getString("id"));
                cs.setNombre(rs.getString("nombre"));
                cs.setApellido(rs.getString("apellido"));
                cs.setTelefono(rs.getString("telefono"));
                cs.setEmail(rs.getString("email"));
                cs.setTipo(rs.getString("tipo"));
                cs.setSaldo(rs.getDouble("saldo"));
                list.add(cs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, rs);
        }
        return list;
    }

    public ClientSupplier getById(String id) {
        ClientSupplier cs = null;
        String query = "SELECT * FROM ClienteProveedor WHERE id = ?";
        Connection conn = null;
        PreparedStatement pSt = null;
        ResultSet rs = null;
        
        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setString(1, id);
            rs = pSt.executeQuery();
            
            if (rs.next()) {
                cs = new ClientSupplier();
                cs.setId(rs.getString("id"));
                cs.setNombre(rs.getString("nombre"));
                cs.setApellido(rs.getString("apellido"));
                cs.setTelefono(rs.getString("telefono"));
                cs.setEmail(rs.getString("email"));
                cs.setTipo(rs.getString("tipo"));
                cs.setSaldo(rs.getDouble("saldo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, rs);
        }
        return cs;
    }

    public boolean insert(ClientSupplier cs) {
        boolean inserted = false;
        String query = "INSERT INTO ClienteProveedor (id, nombre, apellido, telefono, email, tipo, saldo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pSt = null;
        
        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setString(1, cs.getId());
            pSt.setString(2, cs.getNombre());
            pSt.setString(3, cs.getApellido());
            pSt.setString(4, cs.getTelefono());
            pSt.setString(5, cs.getEmail());
            pSt.setString(6, cs.getTipo());
            pSt.setDouble(7, cs.getSaldo());
            inserted = pSt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, null);
        }
        return inserted;
    }

    public boolean update(ClientSupplier cs) {
        boolean updated = false;
        String query = "UPDATE ClienteProveedor SET nombre=?, apellido=?, telefono=?, email=?, tipo=?, saldo=? WHERE id=?";
        Connection conn = null;
        PreparedStatement pSt = null;
        
        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setString(1, cs.getNombre());
            pSt.setString(2, cs.getApellido());
            pSt.setString(3, cs.getTelefono());
            pSt.setString(4, cs.getEmail());
            pSt.setString(5, cs.getTipo());
            pSt.setDouble(6, cs.getSaldo());
            pSt.setString(7, cs.getId());
            updated = pSt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, null);
        }
        return updated;
    }

    public boolean delete(String id) {
        boolean deleted = false;
        String query = "DELETE FROM ClienteProveedor WHERE id = ?";
        Connection conn = null;
        PreparedStatement pSt = null;
        
        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setString(1, id);
            deleted = pSt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, null);
        }
        return deleted;
    }
}
