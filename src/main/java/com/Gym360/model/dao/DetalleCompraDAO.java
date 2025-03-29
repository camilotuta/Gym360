package main.java.com.Gym360.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import main.java.com.Gym360.model.classes.DetalleCompra;
import main.java.com.Gym360.util.database.DatabaseConnection;

public class DetalleCompraDAO {

	public boolean insertar(DetalleCompra detalleCompra) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean resultado = false;

		try {
			conn = DatabaseConnection.conectar();
			String sql = "INSERT INTO DetalleCompras (idCompra, idProducto, cantidad, precioUnitario) "
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
			String sql = "UPDATE DetalleCompras SET idCompra = ?, idProducto = ?, "
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
			String sql = "DELETE FROM DetalleCompras WHERE idDetalleCompra = ?";

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
			String sql = "SELECT * FROM DetalleCompras WHERE idDetalleCompra = ?";

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
			String sql = "SELECT * FROM DetalleCompras";

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

	public List<DetalleCompra> obtenerPorCompra(int idCompra) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<DetalleCompra> detalles = new ArrayList<>();

		try {
			conn = DatabaseConnection.conectar();
			String sql = "SELECT * FROM DetalleCompras WHERE idCompra = ?";

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

				detalles.add(detalleCompra);
			}

		} catch (SQLException e) {
			System.err.println("Error al obtener detalles por compra: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, rs);
		}

		return detalles;
	}

	public List<DetalleCompra> obtenerPorProducto(int idProducto) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<DetalleCompra> detalles = new ArrayList<>();

		try {
			conn = DatabaseConnection.conectar();
			String sql = "SELECT * FROM DetalleCompras WHERE idProducto = ?";

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
