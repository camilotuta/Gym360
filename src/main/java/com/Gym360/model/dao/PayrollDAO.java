package main.java.com.Gym360.model.dao;

import main.java.com.Gym360.model.classes.Payroll;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.java.com.Gym360.util.database.DatabaseConnection;

public class PayrollDAO {

    public List<Payroll> getPayrollsByEmployeeId(String employeeId) {
        List<Payroll> payrolls = new ArrayList<>();
        String query = "SELECT * FROM Nomina WHERE idEmpleado = ?";
        Connection conn = null;
        PreparedStatement pSt = null;
        ResultSet rs = null;
        
        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setString(1, employeeId);
            rs = pSt.executeQuery();
            
            while (rs.next()) {
                Payroll payroll = new Payroll();
                payroll.setIdNomina(rs.getString("idNomina"));
                payroll.setFecha(rs.getString("fecha"));
                payroll.setSalarioBase(rs.getDouble("salarioBase"));
                payroll.setDeducciones(rs.getDouble("deducciones"));
                payroll.setBonificaciones(rs.getDouble("bonificaciones"));
                payroll.setIdEmpleado(rs.getString("idEmpleado"));
                payrolls.add(payroll);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, rs);
        }
        return payrolls;
    }

    public boolean insertPayroll(Payroll payroll) {
        boolean inserted = false;
        String query = "INSERT INTO Nomina (idNomina, fecha, salarioBase, deducciones, bonificaciones, idEmpleado) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pSt = null;
        
        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setString(1, payroll.getIdNomina());
            pSt.setString(2, payroll.getFecha());
            pSt.setDouble(3, payroll.getSalarioBase());
            pSt.setDouble(4, payroll.getDeducciones());
            pSt.setDouble(5, payroll.getBonificaciones());
            pSt.setString(6, payroll.getIdEmpleado());
            inserted = pSt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, null);
        }
        return inserted;
    }

    public boolean updatePayroll(Payroll payroll) {
        boolean updated = false;
        String query = "UPDATE Nomina SET fecha=?, salarioBase=?, deducciones=?, bonificaciones=? WHERE idNomina=?";
        Connection conn = null;
        PreparedStatement pSt = null;
        
        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setString(1, payroll.getFecha());
            pSt.setDouble(2, payroll.getSalarioBase());
            pSt.setDouble(3, payroll.getDeducciones());
            pSt.setDouble(4, payroll.getBonificaciones());
            pSt.setString(5, payroll.getIdNomina());
            updated = pSt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, null);
        }
        return updated;
    }

    public boolean deletePayroll(String idNomina) {
        boolean deleted = false;
        String query = "DELETE FROM Nomina WHERE idNomina = ?";
        Connection conn = null;
        PreparedStatement pSt = null;
        
        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setString(1, idNomina);
            deleted = pSt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, null);
        }
        return deleted;
    }
}
