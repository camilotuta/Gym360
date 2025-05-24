package main.java.com.Gym360.model.dao;

import main.java.com.Gym360.model.classes.DetalleVenta;
import main.java.com.Gym360.util.database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetalleVentaDAO {

    public boolean insertar(DetalleVenta detalle) {
        Connection conn = null;
        PreparedStatement pst = null;
        boolean resultado = false;

        try {
            conn = DatabaseConnection.conectar();
            String sql = "INSERT INTO DetalleVenta (idVenta, idProducto) VALUES (?, ?)";
            pst = conn.prepareStatement(sql);

            pst.setInt(1, detalle.getIdVenta());
            pst.setInt(2, detalle.getIdProducto());

            resultado = pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al insertar detalle de venta: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, null);
        }

        return resultado;
    }

    public boolean actualizar(DetalleVenta detalle) {
        Connection conn = null;
        PreparedStatement pst = null;
        boolean resultado = false;

        try {
            conn = DatabaseConnection.conectar();
            String sql = "UPDATE DetalleVenta SET idVenta = ?, idProducto = ? WHERE idDetalleVenta = ?";
            pst = conn.prepareStatement(sql);

            pst.setInt(1, detalle.getIdVenta());
            pst.setInt(2, detalle.getIdProducto());
            pst.setInt(3, detalle.getIdDetalleVenta());

            resultado = pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al actualizar detalle de venta: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, null);
        }

        return resultado;
    }

    public boolean eliminar(int idDetalleVenta) {
        Connection conn = null;
        PreparedStatement pst = null;
        boolean resultado = false;

        try {
            conn = DatabaseConnection.conectar();
            String sql = "DELETE FROM DetalleVenta WHERE idDetalleVenta = ?";
            pst = conn.prepareStatement(sql);

            pst.setInt(1, idDetalleVenta);

            resultado = pst.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar detalle de venta: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, null);
        }

        return resultado;
    }

    public DetalleVenta obtenerPorId(int idDetalleVenta) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        DetalleVenta detalle = null;

        try {
            conn = DatabaseConnection.conectar();
            String sql = "SELECT * FROM DetalleVenta WHERE idDetalleVenta = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, idDetalleVenta);
            rs = pst.executeQuery();

            if (rs.next()) {
                detalle = new DetalleVenta();
                detalle.setIdDetalleVenta(rs.getInt("idDetalleVenta"));
                detalle.setIdVenta(rs.getInt("idVenta"));
                detalle.setIdProducto(rs.getInt("idProducto"));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener detalle de venta por ID: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return detalle;
    }

    public List<DetalleVenta> obtenerTodos() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<DetalleVenta> lista = new ArrayList<>();

        try {
            conn = DatabaseConnection.conectar();
            String sql = "SELECT * FROM DetalleVenta";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                DetalleVenta detalle = new DetalleVenta();
                detalle.setIdDetalleVenta(rs.getInt("idDetalleVenta"));
                detalle.setIdVenta(rs.getInt("idVenta"));
                detalle.setIdProducto(rs.getInt("idProducto"));
                lista.add(detalle);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener todos los detalles de venta: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return lista;
    }
}
