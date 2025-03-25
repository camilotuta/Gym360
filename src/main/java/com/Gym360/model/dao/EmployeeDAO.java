package main.java.com.Gym360.model.dao;

import main.java.com.Gym360.model.classes.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.java.com.Gym360.util.database.DatabaseConnection;

public class EmployeeDAO {

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM Empleado";
        Connection conn = null;
        PreparedStatement pSt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            rs = pSt.executeQuery();

            while (rs.next()) {
                Employee emp = new Employee();
                emp.setIdEmpleado(rs.getString("idEmpleado"));
                emp.setNombre(rs.getString("nombre"));
                emp.setApellido(rs.getString("apellido"));
                emp.setSalario(rs.getDouble("salario"));
                emp.setFechaContratacion(rs.getString("fechaContratacion"));
                emp.setCargo(rs.getString("cargo"));
                emp.setTelefono(rs.getString("telefono"));
                emp.setEmail(rs.getString("email"));
                employees.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, rs);
        }
        return employees;
    }

    public Employee getEmployeeById(String id) {
        Employee emp = null;
        String query = "SELECT * FROM Empleado WHERE idEmpleado = ?";
        Connection conn = null;
        PreparedStatement pSt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setString(1, id);
            rs = pSt.executeQuery();

            if (rs.next()) {
                emp = new Employee();
                emp.setIdEmpleado(rs.getString("idEmpleado"));
                emp.setNombre(rs.getString("nombre"));
                emp.setApellido(rs.getString("apellido"));
                emp.setSalario(rs.getDouble("salario"));
                emp.setFechaContratacion(rs.getString("fechaContratacion"));
                emp.setCargo(rs.getString("cargo"));
                emp.setTelefono(rs.getString("telefono"));
                emp.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, rs);
        }
        return emp;
    }

    public boolean insertEmployee(Employee emp) {
        boolean inserted = false;
        String query = "INSERT INTO Empleado (idEmpleado, nombre, apellido, salario, fechaContratacion, cargo, telefono, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pSt = null;

        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setString(1, emp.getIdEmpleado());
            pSt.setString(2, emp.getNombre());
            pSt.setString(3, emp.getApellido());
            pSt.setDouble(4, emp.getSalario());
            pSt.setString(5, emp.getFechaContratacion());
            pSt.setString(6, emp.getCargo());
            pSt.setString(7, emp.getTelefono());
            pSt.setString(8, emp.getEmail());
            inserted = pSt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, null);
        }
        return inserted;
    }

    public boolean updateEmployee(Employee emp) {
        boolean updated = false;
        String query = "UPDATE Empleado SET nombre=?, apellido=?, salario=?, fechaContratacion=?, cargo=?, telefono=?, email=? WHERE idEmpleado=?";
        Connection conn = null;
        PreparedStatement pSt = null;

        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setString(1, emp.getNombre());
            pSt.setString(2, emp.getApellido());
            pSt.setDouble(3, emp.getSalario());
            pSt.setString(4, emp.getFechaContratacion());
            pSt.setString(5, emp.getCargo());
            pSt.setString(6, emp.getTelefono());
            pSt.setString(7, emp.getEmail());
            pSt.setString(8, emp.getIdEmpleado());
            updated = pSt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, null);
        }
        return updated;
    }

    public boolean deleteEmployee(String id) {
        boolean deleted = false;
        String query = "DELETE FROM Empleado WHERE idEmpleado = ?";
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
