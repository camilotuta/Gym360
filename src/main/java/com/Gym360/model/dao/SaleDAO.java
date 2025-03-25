package main.java.com.Gym360.model.dao;

import main.java.com.Gym360.model.classes.Sale;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.java.com.Gym360.util.database.DatabaseConnection;

public class SaleDAO {

    public List<Sale> getAllSales() {
        List<Sale> list = new ArrayList<>();
        String query = "SELECT * FROM Venta";
        Connection conn = null;
        PreparedStatement pSt = null;
        ResultSet rs = null;
        
        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            rs = pSt.executeQuery();
            
            while (rs.next()) {
                Sale sale = new Sale();
                sale.setIdVenta(rs.getString("idVenta"));
                sale.setFecha(rs.getString("fecha"));
                sale.setTotal(rs.getDouble("total"));
                sale.setIdEmpleado(rs.getString("idEmpleado"));
                sale.setIdClienteProveedor(rs.getString("idClienteProveedor"));
                list.add(sale);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, rs);
        }
        return list;
    }

    public boolean insertSale(Sale sale) {
        boolean inserted = false;
        String query = "INSERT INTO Venta (idVenta, fecha, total, idEmpleado, idClienteProveedor) VALUES (?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pSt = null;
        
        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setString(1, sale.getIdVenta());
            pSt.setString(2, sale.getFecha());
            pSt.setDouble(3, sale.getTotal());
            pSt.setString(4, sale.getIdEmpleado());
            pSt.setString(5, sale.getIdClienteProveedor());
            inserted = pSt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, null);
        }
        return inserted;
    }

    public boolean updateSale(Sale sale) {
        boolean updated = false;
        String query = "UPDATE Venta SET fecha=?, total=?, idEmpleado=?, idClienteProveedor=? WHERE idVenta=?";
        Connection conn = null;
        PreparedStatement pSt = null;
        
        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setString(1, sale.getFecha());
            pSt.setDouble(2, sale.getTotal());
            pSt.setString(3, sale.getIdEmpleado());
            pSt.setString(4, sale.getIdClienteProveedor());
            pSt.setString(5, sale.getIdVenta());
            updated = pSt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, null);
        }
        return updated;
    }

    public boolean deleteSale(String idVenta) {
        boolean deleted = false;
        String query = "DELETE FROM Venta WHERE idVenta=?";
        Connection conn = null;
        PreparedStatement pSt = null;
        
        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setString(1, idVenta);
            deleted = pSt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, null);
        }
        return deleted;
    }
}
