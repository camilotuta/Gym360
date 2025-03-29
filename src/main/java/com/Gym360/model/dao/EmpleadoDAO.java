package main.java.com.Gym360.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import main.java.com.Gym360.model.classes.Empleado;
import main.java.com.Gym360.util.database.DatabaseConnection;

public class EmpleadoDAO {
    
    public boolean insertar(Empleado empleado) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean resultado = false;
        
        try {
            conn = DatabaseConnection.conectar();
            String sql = "INSERT INTO Empleado (nombre, apellido, salario, fechaContratacion, cargo, telefono, email) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, empleado.getNombre());
            pst.setString(2, empleado.getApellido());
            pst.setDouble(3, empleado.getSalario());
            pst.setString(4, empleado.getFechaContratacion());
            pst.setString(5, empleado.getCargo());
            pst.setString(6, empleado.getTelefono());
            pst.setString(7, empleado.getEmail());
            
            int filas = pst.executeUpdate();
            if (filas > 0) {
                resultado = true;
                rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    empleado.setIdEmpleado(rs.getInt(1));
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error al insertar empleado: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }
        
        return resultado;
    }
    
    public boolean actualizar(Empleado empleado) {
        Connection conn = null;
        PreparedStatement pst = null;
        boolean resultado = false;
        
        try {
            conn = DatabaseConnection.conectar();
            String sql = "UPDATE Empleado SET nombre = ?, apellido = ?, salario = ?, fechaContratacion = ?, " +
                        "cargo = ?, telefono = ?, email = ? WHERE idEmpleado = ?";
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, empleado.getNombre());
            pst.setString(2, empleado.getApellido());
            pst.setDouble(3, empleado.getSalario());
            pst.setString(4, empleado.getFechaContratacion());
            pst.setString(5, empleado.getCargo());
            pst.setString(6, empleado.getTelefono());
            pst.setString(7, empleado.getEmail());
            pst.setInt(8, empleado.getIdEmpleado());
            
            int filas = pst.executeUpdate();
            if (filas > 0) {
                resultado = true;
            }
            
        } catch (SQLException e) {
            System.err.println("Error al actualizar empleado: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, null);
        }
        
        return resultado;
    }
    
    public boolean eliminar(int id) {
        Connection conn = null;
        PreparedStatement pst = null;
        boolean resultado = false;
        
        try {
            conn = DatabaseConnection.conectar();
            String sql = "DELETE FROM Empleado WHERE idEmpleado = ?";
            
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            
            int filas = pst.executeUpdate();
            if (filas > 0) {
                resultado = true;
            }
            
        } catch (SQLException e) {
            System.err.println("Error al eliminar empleado: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, null);
        }
        
        return resultado;
    }
    
    public Empleado obtenerPorId(int id) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Empleado empleado = null;
        
        try {
            conn = DatabaseConnection.conectar();
            String sql = "SELECT * FROM Empleado WHERE idEmpleado = ?";
            
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            
            rs = pst.executeQuery();
            if (rs.next()) {
                empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt("idEmpleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setSalario(rs.getDouble("salario"));
                empleado.setFechaContratacion(rs.getString("fechaContratacion"));
                empleado.setCargo(rs.getString("cargo"));
                empleado.setTelefono(rs.getString("telefono"));
                empleado.setEmail(rs.getString("email"));
            }
            
        } catch (SQLException e) {
            System.err.println("Error al obtener empleado: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }
        
        return empleado;
    }
    
    public List<Empleado> obtenerTodos() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Empleado> empleados = new ArrayList<>();
        
        try {
            conn = DatabaseConnection.conectar();
            String sql = "SELECT * FROM Empleado";
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt("idEmpleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setSalario(rs.getDouble("salario"));
                empleado.setFechaContratacion(rs.getString("fechaContratacion"));
                empleado.setCargo(rs.getString("cargo"));
                empleado.setTelefono(rs.getString("telefono"));
                empleado.setEmail(rs.getString("email"));
                
                empleados.add(empleado);
            }
            
        } catch (SQLException e) {
            System.err.println("Error al obtener todos los empleados: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }
        
        return empleados;
    }
}