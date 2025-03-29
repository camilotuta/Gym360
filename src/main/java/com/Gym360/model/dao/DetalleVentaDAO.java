package main.java.com.Gym360.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import main.java.com.Gym360.model.classes.DetalleVenta;
import main.java.com.Gym360.util.database.DatabaseConnection;

public class DetalleVentaDAO {

    public boolean insertar(DetalleVenta detalleVenta) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean resultado = false;

        try {
            conn = DatabaseConnection.conectar();
            String sql = "INSERT INTO DetallesVenta (idVenta, idProducto, cantidad, precioUnitario) VALUES (?, ?, ?, ?)";

            pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, detalleVenta.getIdVenta());
            pst.setInt(2, detalleVenta.getIdProducto());
            pst.setInt(3, detalleVenta.getCantidad());
            pst.setDouble(4, detalleVenta.getPrecioUnitario());

            int filas = pst.executeUpdate();
            if (filas > 0) {
                resultado = true;
                rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    detalleVenta.setIdDetalleVenta(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al insertar detalle de venta: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return resultado;
    }

    public boolean actualizar(DetalleVenta detalleVenta) {
        Connection conn = null;
        PreparedStatement pst = null;
        boolean resultado = false;

        try {
            conn = DatabaseConnection.conectar();
            String sql = "UPDATE DetallesVenta SET idVenta = ?, idProducto = ?, cantidad = ?, precioUnitario = ? WHERE idDetalleVenta = ?";

            pst = conn.prepareStatement(sql);
            pst.setInt(1, detalleVenta.getIdVenta());
            pst.setInt(2, detalleVenta.getIdProducto());
            pst.setInt(3, detalleVenta.getCantidad());
            pst.setDouble(4, detalleVenta.getPrecioUnitario());
            pst.setInt(5, detalleVenta.getIdDetalleVenta());

            int filas = pst.executeUpdate();
            if (filas > 0) {
                resultado = true;
            }

        } catch (SQLException e) {
            System.err.println("Error al actualizar detalle de venta: " + e.getMessage());
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
            String sql = "DELETE FROM DetallesVenta WHERE idDetalleVenta = ?";

            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);

            int filas = pst.executeUpdate();
            if (filas > 0) {
                resultado = true;
            }

        } catch (SQLException e) {
            System.err.println("Error al eliminar detalle de venta: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, null);
        }

        return resultado;
    }

    public DetalleVenta obtenerPorId(int id) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        DetalleVenta detalleVenta = null;

        try {
            conn = DatabaseConnection.conectar();
            String sql = "SELECT * FROM DetallesVenta WHERE idDetalleVenta = ?";

            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);

            rs = pst.executeQuery();
            if (rs.next()) {
                detalleVenta = new DetalleVenta();
                detalleVenta.setIdDetalleVenta(rs.getInt("idDetalleVenta"));
                detalleVenta.setIdVenta(rs.getInt("idVenta"));
                detalleVenta.setIdProducto(rs.getInt("idProducto"));
                detalleVenta.setCantidad(rs.getInt("cantidad"));
                detalleVenta.setPrecioUnitario(rs.getDouble("precioUnitario"));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener detalle de venta: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return detalleVenta;
    }

    public List<DetalleVenta> obtenerPorVenta(int idVenta) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<DetalleVenta> detalles = new ArrayList<>();

        try {
            conn = DatabaseConnection.conectar();
            String sql = "SELECT * FROM DetallesVenta WHERE idVenta = ?";

            pst = conn.prepareStatement(sql);
            pst.setInt(1, idVenta);

            rs = pst.executeQuery();
            while (rs.next()) {
                DetalleVenta detalleVenta = new DetalleVenta();
                detalleVenta.setIdDetalleVenta(rs.getInt("idDetalleVenta"));
                detalleVenta.setIdVenta(rs.getInt("idVenta"));
                detalleVenta.setIdProducto(rs.getInt("idProducto"));
                detalleVenta.setCantidad(rs.getInt("cantidad"));
                detalleVenta.setPrecioUnitario(rs.getDouble("precioUnitario"));

                detalles.add(detalleVenta);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener detalles por venta: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return detalles;
    }

    public List<DetalleVenta> obtenerTodos() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<DetalleVenta> detalles = new ArrayList<>();

        try {
            conn = DatabaseConnection.conectar();
            String sql = "SELECT * FROM DetallesVenta";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                DetalleVenta detalleVenta = new DetalleVenta();
                detalleVenta.setIdDetalleVenta(rs.getInt("idDetalleVenta"));
                detalleVenta.setIdVenta(rs.getInt("idVenta"));
                detalleVenta.setIdProducto(rs.getInt("idProducto"));
                detalleVenta.setCantidad(rs.getInt("cantidad"));
                detalleVenta.setPrecioUnitario(rs.getDouble("precioUnitario"));

                detalles.add(detalleVenta);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener todos los detalles de venta: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return detalles;
    }
}