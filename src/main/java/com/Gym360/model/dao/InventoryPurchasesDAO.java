package main.java.com.Gym360.model.dao;

import main.java.com.Gym360.model.classes.InventoryPurchase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.java.com.Gym360.util.database.DatabaseConnection;

public class InventoryPurchasesDAO {

    public List<InventoryPurchase> getAllPurchases() {
        List<InventoryPurchase> list = new ArrayList<>();
        String query = "SELECT * FROM InventarioCompras";
        Connection conn = null;
        PreparedStatement pSt = null;
        ResultSet rs = null;
        
        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            rs = pSt.executeQuery();
            
            while (rs.next()) {
                InventoryPurchase ip = new InventoryPurchase();
                ip.setIdCompra(rs.getString("idCompra"));
                ip.setFecha(rs.getString("fecha"));
                ip.setTotalCompras(rs.getDouble("totalCompras"));
                ip.setIdClienteProveedor(rs.getString("idClienteProveedor"));
                list.add(ip);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, rs);
        }
        return list;
    }

    public boolean insertPurchase(InventoryPurchase ip) {
        boolean inserted = false;
        String query = "INSERT INTO InventarioCompras (idCompra, fecha, totalCompras, idClienteProveedor) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pSt = null;
        
        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setString(1, ip.getIdCompra());
            pSt.setString(2, ip.getFecha());
            pSt.setDouble(3, ip.getTotalCompras());
            pSt.setString(4, ip.getIdClienteProveedor());
            inserted = pSt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, null);
        }
        return inserted;
    }

    public boolean updatePurchase(InventoryPurchase ip) {
        boolean updated = false;
        String query = "UPDATE InventarioCompras SET fecha=?, totalCompras=?, idClienteProveedor=? WHERE idCompra=?";
        Connection conn = null;
        PreparedStatement pSt = null;
        
        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setString(1, ip.getFecha());
            pSt.setDouble(2, ip.getTotalCompras());
            pSt.setString(3, ip.getIdClienteProveedor());
            pSt.setString(4, ip.getIdCompra());
            updated = pSt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, null);
        }
        return updated;
    }

    public boolean deletePurchase(String idCompra) {
        boolean deleted = false;
        String query = "DELETE FROM InventarioCompras WHERE idCompra=?";
        Connection conn = null;
        PreparedStatement pSt = null;
        
        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setString(1, idCompra);
            deleted = pSt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, null);
        }
        return deleted;
    }
}
