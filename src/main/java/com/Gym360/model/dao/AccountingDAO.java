package main.java.com.Gym360.model.dao;

import main.java.com.Gym360.model.classes.Accounting;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.java.com.Gym360.util.database.DatabaseConnection;

public class AccountingDAO {

    public List<Accounting> getAllAccountingRecords() {
        List<Accounting> list = new ArrayList<>();
        String query = "SELECT * FROM Contabilidad";
        Connection conn = null;
        PreparedStatement pSt = null;
        ResultSet rs = null;
        
        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            rs = pSt.executeQuery();
            
            while (rs.next()) {
                Accounting acc = new Accounting();
                acc.setIdContabilidad(rs.getInt("idContabilidad"));
                acc.setIngresos(rs.getDouble("ingresos"));
                acc.setEgresos(rs.getDouble("egresos"));
                list.add(acc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, rs);
        }
        return list;
    }

    public boolean insertAccounting(Accounting acc) {
        boolean inserted = false;
        String query = "INSERT INTO Contabilidad (ingresos, egresos) VALUES (?, ?)";
        Connection conn = null;
        PreparedStatement pSt = null;
        
        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setDouble(1, acc.getIngresos());
            pSt.setDouble(2, acc.getEgresos());
            inserted = pSt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, null);
        }
        return inserted;
    }

    public boolean updateAccounting(Accounting acc) {
        boolean updated = false;
        String query = "UPDATE Contabilidad SET ingresos=?, egresos=? WHERE idContabilidad=?";
        Connection conn = null;
        PreparedStatement pSt = null;
        
        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setDouble(1, acc.getIngresos());
            pSt.setDouble(2, acc.getEgresos());
            pSt.setInt(3, acc.getIdContabilidad());
            updated = pSt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, null);
        }
        return updated;
    }

    public boolean deleteAccounting(int idContabilidad) {
        boolean deleted = false;
        String query = "DELETE FROM Contabilidad WHERE idContabilidad=?";
        Connection conn = null;
        PreparedStatement pSt = null;
        
        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setInt(1, idContabilidad);
            deleted = pSt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, null);
        }
        return deleted;
    }
}
