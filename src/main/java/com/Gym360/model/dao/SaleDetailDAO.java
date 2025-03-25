package main.java.com.Gym360.model.dao;

import main.java.com.Gym360.model.classes.SaleDetail;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.java.com.Gym360.util.database.DatabaseConnection;

public class SaleDetailDAO {

    public List<SaleDetail> getSaleDetailsBySaleId(String idVenta) {
        List<SaleDetail> list = new ArrayList<>();
        String query = "SELECT * FROM DetalleVenta WHERE idVenta = ?";
        Connection conn = null;
        PreparedStatement pSt = null;
        ResultSet rs = null;
        
        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setString(1, idVenta);
            rs = pSt.executeQuery();
            
            while (rs.next()) {
                SaleDetail detail = new SaleDetail();
                detail.setIdDetalleVenta(rs.getInt("idDetalleVenta"));
                detail.setIdVenta(rs.getString("idVenta"));
                detail.setProducto(rs.getString("producto"));
                list.add(detail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, rs);
        }
        return list;
    }

    public boolean insertSaleDetail(SaleDetail detail) {
        boolean inserted = false;
        String query = "INSERT INTO DetalleVenta (idVenta, producto) VALUES (?, ?)";
        Connection conn = null;
        PreparedStatement pSt = null;
        
        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setString(1, detail.getIdVenta());
            pSt.setString(2, detail.getProducto());
            inserted = pSt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, null);
        }
        return inserted;
    }

    public boolean deleteSaleDetail(int idDetalleVenta) {
        boolean deleted = false;
        String query = "DELETE FROM DetalleVenta WHERE idDetalleVenta=?";
        Connection conn = null;
        PreparedStatement pSt = null;
        
        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setInt(1, idDetalleVenta);
            deleted = pSt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, null);
        }
        return deleted;
    }
}
