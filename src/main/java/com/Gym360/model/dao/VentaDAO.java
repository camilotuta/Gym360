package main.java.com.Gym360.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import main.java.com.Gym360.model.classes.Venta;
import main.java.com.Gym360.util.database.DatabaseConnection;

public class VentaDAO {

	public boolean insertar(Venta venta) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean resultado = false;

		try {
			conn = DatabaseConnection.conectar();
			String sql = "INSERT INTO Ventas (fecha, total, idEmpleado, idClienteProveedor) VALUES (?, ?, ?, ?)";

			pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, venta.getFecha());
			pst.setDouble(2, venta.getTotal());
			pst.setInt(3, venta.getIdEmpleado());
			pst.setInt(4, venta.getIdClienteProveedor());

			int filas = pst.executeUpdate();
			if (filas > 0) {
				resultado = true;
				rs = pst.getGeneratedKeys();
				if (rs.next()) {
					venta.setIdVenta(rs.getInt(1));
				}
			}

		} catch (SQLException e) {
			System.err.println("Error al insertar venta: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, rs);
		}

		return resultado;
	}

	public boolean actualizar(Venta venta) {
		Connection conn = null;
		PreparedStatement pst = null;
		boolean resultado = false;

		try {
			conn = DatabaseConnection.conectar();
			String sql = "UPDATE Ventas SET fecha = ?, total = ?, idEmpleado = ?, idClienteProveedor = ? WHERE idVenta = ?";

			pst = conn.prepareStatement(sql);
			pst.setString(1, venta.getFecha());
			pst.setDouble(2, venta.getTotal());
			pst.setInt(3, venta.getIdEmpleado());
			pst.setInt(4, venta.getIdClienteProveedor());
			pst.setInt(5, venta.getIdVenta());

			int filas = pst.executeUpdate();
			if (filas > 0) {
				resultado = true;
			}

		} catch (SQLException e) {
			System.err.println("Error al actualizar venta: " + e.getMessage());
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
			String sql = "DELETE FROM Ventas WHERE idVenta = ?";

			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);

			int filas = pst.executeUpdate();
			if (filas > 0) {
				resultado = true;
			}

		} catch (SQLException e) {
			System.err.println("Error al eliminar venta: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, null);
		}

		return resultado;
	}

	public Venta obtenerPorId(int id) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Venta venta = null;

		try {
			conn = DatabaseConnection.conectar();
			String sql = "SELECT * FROM Ventas WHERE idVenta = ?";

			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);

			rs = pst.executeQuery();
			if (rs.next()) {
				venta = new Venta();
				venta.setIdVenta(rs.getInt("idVenta"));
				venta.setFecha(rs.getString("fecha"));
				venta.setTotal(rs.getDouble("total"));
				venta.setIdEmpleado(rs.getInt("idEmpleado"));
				venta.setIdClienteProveedor(rs.getInt("idClienteProveedor"));
			}

		} catch (SQLException e) {
			System.err.println("Error al obtener venta: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, rs);
		}

		return venta;
	}

	public List<Venta> obtenerTodos() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Venta> ventas = new ArrayList<>();

		try {
			conn = DatabaseConnection.conectar();
			String sql = "SELECT * FROM Ventas";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				Venta venta = new Venta();
				venta.setIdVenta(rs.getInt("idVenta"));
				venta.setFecha(rs.getString("fecha"));
				venta.setTotal(rs.getDouble("total"));
				venta.setIdEmpleado(rs.getInt("idEmpleado"));
				venta.setIdClienteProveedor(rs.getInt("idClienteProveedor"));

				ventas.add(venta);
			}

		} catch (SQLException e) {
			System.err.println("Error al obtener todas las ventas: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, rs);
		}

		return ventas;
	}

	public List<Venta> obtenerPorEmpleado(int idEmpleado) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Venta> ventas = new ArrayList<>();

		try {
			conn = DatabaseConnection.conectar();
			String sql = "SELECT * FROM Ventas WHERE idEmpleado = ?";

			pst = conn.prepareStatement(sql);
			pst.setInt(1, idEmpleado);

			rs = pst.executeQuery();
			while (rs.next()) {
				Venta venta = new Venta();
				venta.setIdVenta(rs.getInt("idVenta"));
				venta.setFecha(rs.getString("fecha"));
				venta.setTotal(rs.getDouble("total"));
				venta.setIdEmpleado(rs.getInt("idEmpleado"));
				venta.setIdClienteProveedor(rs.getInt("idClienteProveedor"));

				ventas.add(venta);
			}

		} catch (SQLException e) {
			System.err.println("Error al obtener ventas por empleado: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, rs);
		}

		return ventas;
	}

	public List<Venta> obtenerPorCliente(int idCliente) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Venta> ventas = new ArrayList<>();

		try {
			conn = DatabaseConnection.conectar();
			String sql = "SELECT * FROM Ventas WHERE idClienteProveedor = ?";

			pst = conn.prepareStatement(sql);
			pst.setInt(1, idCliente);

			rs = pst.executeQuery();
			while (rs.next()) {
				Venta venta = new Venta();
				venta.setIdVenta(rs.getInt("idVenta"));
				venta.setFecha(rs.getString("fecha"));
				venta.setTotal(rs.getDouble("total"));
				venta.setIdEmpleado(rs.getInt("idEmpleado"));
				venta.setIdClienteProveedor(rs.getInt("idClienteProveedor"));

				ventas.add(venta);
			}

		} catch (SQLException e) {
			System.err.println("Error al obtener ventas por cliente: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, rs);
		}

		return ventas;
	}
}
