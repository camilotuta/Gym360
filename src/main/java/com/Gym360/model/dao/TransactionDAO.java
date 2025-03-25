package main.java.com.Gym360.model.dao;

import main.java.com.Gym360.model.classes.Transaction;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.java.com.Gym360.util.database.DatabaseConnection;

public class TransactionDAO {

    public List<Transaction> getTransactionsByAccountingId(int idContabilidad) {
        List<Transaction> list = new ArrayList<>();
        String query = "SELECT * FROM Transaccion WHERE idContabilidad=?";
        Connection conn = null;
        PreparedStatement pSt = null;
        ResultSet rs = null;
        
        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setInt(1, idContabilidad);
            rs = pSt.executeQuery();
            
            while (rs.next()) {
                Transaction trans = new Transaction();
                trans.setIdTransaccion(rs.getInt("idTransaccion"));
                trans.setIdContabilidad(rs.getInt("idContabilidad"));
                trans.setDescripcion(rs.getString("descripcion"));
                list.add(trans);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, rs);
        }
        return list;
    }

    public boolean insertTransaction(Transaction trans) {
        boolean inserted = false;
        String query = "INSERT INTO Transaccion (idContabilidad, descripcion) VALUES (?, ?)";
        Connection conn = null;
        PreparedStatement pSt = null;
        
        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setInt(1, trans.getIdContabilidad());
            pSt.setString(2, trans.getDescripcion());
            inserted = pSt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, null);
        }
        return inserted;
    }

    public boolean deleteTransaction(int idTransaccion) {
        boolean deleted = false;
        String query = "DELETE FROM Transaccion WHERE idTransaccion=?";
        Connection conn = null;
        PreparedStatement pSt = null;
        
        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setInt(1, idTransaccion);
            deleted = pSt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, null);
        }
        return deleted;
    }
}
