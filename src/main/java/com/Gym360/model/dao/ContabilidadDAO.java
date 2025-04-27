// cSpell:ignore egresos
package main.java.com.Gym360.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import main.java.com.Gym360.model.classes.Contabilidad;
import main.java.com.Gym360.util.database.DatabaseConnection;

public class ContabilidadDAO {

    public boolean insertar(Contabilidad contabilidad) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean resultado = false;

        try {
            conn = DatabaseConnection.conectar();
            String sql = "INSERT INTO Contabilidad (ingresos, egresos) VALUES (?, ?)";

            pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setDouble(1, contabilidad.getIngresos());
            pst.setDouble(2, contabilidad.getEgresos());

            int filas = pst.executeUpdate();
            if (filas > 0) {
                resultado = true;
                rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    contabilidad.setIdContabilidad(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al insertar contabilidad: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return resultado;
    }

    public boolean actualizar(Contabilidad contabilidad) {
        Connection conn = null;
        PreparedStatement pst = null;
        boolean resultado = false;

        try {
            conn = DatabaseConnection.conectar();
            String sql = "UPDATE Contabilidad SET ingresos = ?, egresos = ? WHERE idContabilidad = ?";

            pst = conn.prepareStatement(sql);
            pst.setDouble(1, contabilidad.getIngresos());
            pst.setDouble(2, contabilidad.getEgresos());
            pst.setInt(3, contabilidad.getIdContabilidad());

            int filas = pst.executeUpdate();
            if (filas > 0) {
                resultado = true;
            }

        } catch (SQLException e) {
            System.err.println("Error al actualizar contabilidad: " + e.getMessage());
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
            String sql = "DELETE FROM Contabilidad WHERE idContabilidad = ?";

            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);

            int filas = pst.executeUpdate();
            if (filas > 0) {
                resultado = true;
            }

        } catch (SQLException e) {
            System.err.println("Error al eliminar contabilidad: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, null);
        }

        return resultado;
    }

    public Contabilidad obtenerPorId(int id) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Contabilidad contabilidad = null;

        try {
            conn = DatabaseConnection.conectar();
            String sql = "SELECT * FROM Contabilidad WHERE idContabilidad = ?";

            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);

            rs = pst.executeQuery();
            if (rs.next()) {
                contabilidad = new Contabilidad();
                contabilidad.setIdContabilidad(rs.getInt("idContabilidad"));
                contabilidad.setIngresos(rs.getDouble("ingresos"));
                contabilidad.setEgresos(rs.getDouble("egresos"));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener contabilidad: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return contabilidad;
    }

    public List<Contabilidad> obtenerTodos() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Contabilidad> registros = new ArrayList<>();

        try {
            conn = DatabaseConnection.conectar();
            String sql = "SELECT * FROM Contabilidad";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Contabilidad contabilidad = new Contabilidad();
                contabilidad.setIdContabilidad(rs.getInt("idContabilidad"));
                contabilidad.setIngresos(rs.getDouble("ingresos"));
                contabilidad.setEgresos(rs.getDouble("egresos"));

                registros.add(contabilidad);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener todos los registros de contabilidad: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return registros;
    }
}