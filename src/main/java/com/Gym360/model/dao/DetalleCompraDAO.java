package main.java.com.Gym360.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import main.java.com.Gym360.model.classes.DetalleCompra;

import main.java.com.Gym360.util.database.DatabaseConnection;

public class DetalleCompraDAO {

    public List<Object[]> obtenerDetallesDeComprasConFiltro(String filtro) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Object[]> detalles = new ArrayList<>();

        try {
            conn = DatabaseConnection.conectar();
            String sql = "SELECT dc.idDetalleCompra, " + "dc.idCompra, " + "p.nombre AS nombreProducto, "
                    + "p.descripcion, " + "dc.cantidad, " + "dc.precioUnitario, "
                    + "(dc.cantidad * dc.precioUnitario) AS totalProducto " + "FROM DetalleCompra dc "
                    + "JOIN Producto p ON dc.idProducto = p.idProducto " + "WHERE p.nombre LIKE ?"; // Filtro por nombre
                                                                                                    // del producto

            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + filtro + "%"); // El "%" permite hacer una búsqueda parcial
            rs = pst.executeQuery();

            while (rs.next()) {
                Object[] detalle = new Object[7];
                detalle[0] = rs.getInt("idDetalleCompra");
                detalle[1] = rs.getInt("idCompra");
                detalle[2] = rs.getString("nombreProducto");
                detalle[3] = rs.getString("descripcion");
                detalle[4] = rs.getInt("cantidad");
                detalle[5] = rs.getDouble("precioUnitario");
                detalle[6] = rs.getDouble("totalProducto");

                detalles.add(detalle);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener los detalles de compra con filtro: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return detalles;
    }

    public List<Object[]> obtenerDetallesDeCompras() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Object[]> detalles = new ArrayList<>();

        try {
            conn = DatabaseConnection.conectar();
            String sql = "SELECT dc.idDetalleCompra, " + "dc.idCompra, " + "p.nombre AS nombreProducto, "
                    + "p.descripcion, " + "dc.cantidad, " + "dc.precioUnitario, "
                    + "(dc.cantidad * dc.precioUnitario) AS totalProducto " + "FROM DetalleCompra dc "
                    + "JOIN Producto p ON dc.idProducto = p.idProducto";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Object[] detalle = new Object[7];
                detalle[0] = rs.getInt("idDetalleCompra");
                detalle[1] = rs.getInt("idCompra");
                detalle[2] = rs.getString("nombreProducto");
                detalle[3] = rs.getString("descripcion");
                detalle[4] = rs.getInt("cantidad");
                detalle[5] = rs.getDouble("precioUnitario");
                detalle[6] = rs.getDouble("totalProducto");

                detalles.add(detalle);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener los detalles de compra: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return detalles;
    }

    // Método para llenar un JTable con los detalles obtenidos
    public DefaultTableModel obtenerModeloTablaDetalles() {
        String[] columnas = { "ID Detalle", "ID Compra", "Producto", "Descripción", "Cantidad", "Precio Unitario",
                "Total Producto" };
        List<Object[]> detalles = obtenerDetallesDeCompras();

        // Crear el modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        // Llenar el modelo con los datos
        for (Object[] detalle : detalles) {
            modelo.addRow(detalle);
        }

        return modelo;
    }

    public boolean insertar(DetalleCompra detalleCompra) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean resultado = false;

        try {
            conn = DatabaseConnection.conectar();
            String sql = "INSERT INTO DetalleCompra (idCompra, idProducto, cantidad, precioUnitario) "
                    + "VALUES (?, ?, ?, ?)";

            pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, detalleCompra.getIdCompra());
            pst.setInt(2, detalleCompra.getIdProducto());
            pst.setInt(3, detalleCompra.getCantidad());
            pst.setDouble(4, detalleCompra.getPrecioUnitario());

            int filas = pst.executeUpdate();
            if (filas > 0) {
                resultado = true;
                rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    detalleCompra.setIdDetalleCompra(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al insertar detalle de compra: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return resultado;
    }

    public boolean actualizar(DetalleCompra detalleCompra) {
        Connection conn = null;
        PreparedStatement pst = null;
        boolean resultado = false;

        try {
            conn = DatabaseConnection.conectar();
            String sql = "UPDATE DetalleCompra SET idCompra = ?, idProducto = ?, "
                    + "cantidad = ?, precioUnitario = ? WHERE idDetalleCompra = ?";

            pst = conn.prepareStatement(sql);
            pst.setInt(1, detalleCompra.getIdCompra());
            pst.setInt(2, detalleCompra.getIdProducto());
            pst.setInt(3, detalleCompra.getCantidad());
            pst.setDouble(4, detalleCompra.getPrecioUnitario());
            pst.setInt(5, detalleCompra.getIdDetalleCompra());

            int filas = pst.executeUpdate();
            if (filas > 0) {
                resultado = true;
            }

        } catch (SQLException e) {
            System.err.println("Error al actualizar detalle de compra: " + e.getMessage());
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
            String sql = "DELETE FROM DetalleCompra WHERE idDetalleCompra = ?";

            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);

            int filas = pst.executeUpdate();
            if (filas > 0) {
                resultado = true;
            }

        } catch (SQLException e) {
            System.err.println("Error al eliminar detalle de compra: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, null);
        }

        return resultado;
    }

    public DetalleCompra obtenerPorId(int id) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        DetalleCompra detalleCompra = null;

        try {
            conn = DatabaseConnection.conectar();
            String sql = "SELECT * FROM DetalleCompra WHERE idDetalleCompra = ?";

            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);

            rs = pst.executeQuery();
            if (rs.next()) {
                detalleCompra = new DetalleCompra();
                detalleCompra.setIdDetalleCompra(rs.getInt("idDetalleCompra"));
                detalleCompra.setIdCompra(rs.getInt("idCompra"));
                detalleCompra.setIdProducto(rs.getInt("idProducto"));
                detalleCompra.setCantidad(rs.getInt("cantidad"));
                detalleCompra.setPrecioUnitario(rs.getDouble("precioUnitario"));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener detalle de compra: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return detalleCompra;
    }

    public List<DetalleCompra> obtenerTodos() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<DetalleCompra> detalles = new ArrayList<>();

        try {
            conn = DatabaseConnection.conectar();
            String sql = "SELECT * FROM DetalleCompra";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                DetalleCompra detalleCompra = new DetalleCompra();
                detalleCompra.setIdDetalleCompra(rs.getInt("idDetalleCompra"));
                detalleCompra.setIdCompra(rs.getInt("idCompra"));
                detalleCompra.setIdProducto(rs.getInt("idProducto"));
                detalleCompra.setCantidad(rs.getInt("cantidad"));
                detalleCompra.setPrecioUnitario(rs.getDouble("precioUnitario"));

                detalles.add(detalleCompra);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener todos los detalles de compra: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return detalles;
    }

    public DetalleCompra obtenerPorIdCompra(int idCompra) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.conectar();
            String sql = "SELECT * FROM DetalleCompra WHERE idCompra = ?";

            pst = conn.prepareStatement(sql);
            pst.setInt(1, idCompra);

            rs = pst.executeQuery();
            while (rs.next()) {
                DetalleCompra detalleCompra = new DetalleCompra();
                detalleCompra.setIdDetalleCompra(rs.getInt("idDetalleCompra"));
                detalleCompra.setIdCompra(rs.getInt("idCompra"));
                detalleCompra.setIdProducto(rs.getInt("idProducto"));
                detalleCompra.setCantidad(rs.getInt("cantidad"));
                detalleCompra.setPrecioUnitario(rs.getDouble("precioUnitario"));

                return detalleCompra;
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener detalles por compra: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return null;
    }

    public List<DetalleCompra> obtenerPorProducto(int idProducto) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<DetalleCompra> detalles = new ArrayList<>();

        try {
            conn = DatabaseConnection.conectar();
            String sql = "SELECT * FROM DetalleCompra WHERE idProducto = ?";

            pst = conn.prepareStatement(sql);
            pst.setInt(1, idProducto);

            rs = pst.executeQuery();
            while (rs.next()) {
                DetalleCompra detalleCompra = new DetalleCompra();
                detalleCompra.setIdDetalleCompra(rs.getInt("idDetalleCompra"));
                detalleCompra.setIdCompra(rs.getInt("idCompra"));
                detalleCompra.setIdProducto(rs.getInt("idProducto"));
                detalleCompra.setCantidad(rs.getInt("cantidad"));
                detalleCompra.setPrecioUnitario(rs.getDouble("precioUnitario"));

                detalles.add(detalleCompra);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener detalles por producto: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return detalles;
    }
}
