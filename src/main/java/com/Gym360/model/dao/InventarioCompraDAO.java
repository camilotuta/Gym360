package main.java.com.Gym360.model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import main.java.com.Gym360.model.classes.InventarioCompra;
import main.java.com.Gym360.util.database.DatabaseConnection;

public class InventarioCompraDAO {

	public boolean insertar(InventarioCompra compra) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean resultado = false;

		try {
			conn = DatabaseConnection.conectar();
			String sql = "INSERT INTO InventarioCompras (fecha, totalCompras, idClienteProveedor) "
				+ "VALUES (?, ?, ?)";

			pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, compra.getFecha());
			pst.setDouble(2, compra.getTotalCompras());
			pst.setInt(3, compra.getIdClienteProveedor());

			int filas = pst.executeUpdate();
			if (filas > 0) {
				resultado = true;
				rs = pst.getGeneratedKeys();
				if (rs.next()) {
					compra.setIdCompra(rs.getInt(1));
				}
			}

		} catch (SQLException e) {
			System.err.println("Error al insertar compra: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, rs);
		}

		return resultado;
	}

	public boolean actualizar(InventarioCompra compra) {
		Connection conn = null;
		PreparedStatement pst = null;
		boolean resultado = false;

		try {
			conn = DatabaseConnection.conectar();
			String sql = "UPDATE InventarioCompras SET fecha = ?, totalCompras = ?, "
				+ "idClienteProveedor = ? WHERE idCompra = ?";

			pst = conn.prepareStatement(sql);
			pst.setString(1, compra.getFecha());
			pst.setDouble(2, compra.getTotalCompras());
			pst.setInt(3, compra.getIdClienteProveedor());
			pst.setInt(4, compra.getIdCompra());

			int filas = pst.executeUpdate();
			if (filas > 0) {
				resultado = true;
			}

		} catch (SQLException e) {
			System.err.println("Error al actualizar compra: " + e.getMessage());
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
			String sql = "DELETE FROM InventarioCompras WHERE idCompra = ?";

			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);

			int filas = pst.executeUpdate();
			if (filas > 0) {
				resultado = true;
			}

		} catch (SQLException e) {
			System.err.println("Error al eliminar compra: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, null);
		}

		return resultado;
	}

	public InventarioCompra obtenerPorId(int id) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		InventarioCompra compra = null;

		try {
			conn = DatabaseConnection.conectar();
			String sql = "SELECT * FROM InventarioCompras WHERE idCompra = ?";

			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);

			rs = pst.executeQuery();
			if (rs.next()) {
				compra = new InventarioCompra();
				compra.setIdCompra(rs.getInt("idCompra"));
				compra.setFecha(rs.getString("fecha"));
				compra.setTotalCompras(rs.getDouble("totalCompras"));
				compra.setIdClienteProveedor(rs.getInt("idClienteProveedor"));
			}

		} catch (SQLException e) {
			System.err.println("Error al obtener compra: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, rs);
		}

		return compra;
	}

	public List<InventarioCompra> obtenerTodos() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<InventarioCompra> compras = new ArrayList<>();

		try {
			conn = DatabaseConnection.conectar();
			String sql = "SELECT * FROM InventarioCompras";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				InventarioCompra compra = new InventarioCompra();
				compra.setIdCompra(rs.getInt("idCompra"));
				compra.setFecha(rs.getString("fecha"));
				compra.setTotalCompras(rs.getDouble("totalCompras"));
				compra.setIdClienteProveedor(rs.getInt("idClienteProveedor"));

				compras.add(compra);
			}

		} catch (SQLException e) {
			System.err.println("Error al obtener todas las compras: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, rs);
		}

		return compras;
	}

	public List<InventarioCompra> obtenerPorProveedor(int idProveedor) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<InventarioCompra> compras = new ArrayList<>();

		try {
			conn = DatabaseConnection.conectar();
			String sql = "SELECT * FROM InventarioCompras WHERE idClienteProveedor = ?";

			pst = conn.prepareStatement(sql);
			pst.setInt(1, idProveedor);

			rs = pst.executeQuery();
			while (rs.next()) {
				InventarioCompra compra = new InventarioCompra();
				compra.setIdCompra(rs.getInt("idCompra"));
				compra.setFecha(rs.getString("fecha"));
				compra.setTotalCompras(rs.getDouble("totalCompras"));
				compra.setIdClienteProveedor(rs.getInt("idClienteProveedor"));

				compras.add(compra);
			}

		} catch (SQLException e) {
			System.err.println("Error al obtener compras por proveedor: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, rs);
		}

		return compras;
	}
}
