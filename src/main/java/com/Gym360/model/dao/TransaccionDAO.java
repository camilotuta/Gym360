package main.java.com.Gym360.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import main.java.com.Gym360.model.classes.Transaccion;
import main.java.com.Gym360.util.database.DatabaseConnection;

public class TransaccionDAO {

	public boolean insertar(Transaccion transaccion) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean resultado = false;

		try {
			conn = DatabaseConnection.conectar();
			String sql = "INSERT INTO Transacciones (idContabilidad, descripcion) VALUES (?, ?)";

			pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, transaccion.getIdContabilidad());
			pst.setString(2, transaccion.getDescripcion());

			int filas = pst.executeUpdate();
			if (filas > 0) {
				resultado = true;
				rs = pst.getGeneratedKeys();
				if (rs.next()) {
					transaccion.setIdTransaccion(rs.getInt(1));
				}
			}

		} catch (SQLException e) {
			System.err.println("Error al insertar transacción: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, rs);
		}

		return resultado;
	}

	public boolean actualizar(Transaccion transaccion) {
		Connection conn = null;
		PreparedStatement pst = null;
		boolean resultado = false;

		try {
			conn = DatabaseConnection.conectar();
			String sql = "UPDATE Transacciones SET idContabilidad = ?, descripcion = ? WHERE idTransaccion = ?";

			pst = conn.prepareStatement(sql);
			pst.setInt(1, transaccion.getIdContabilidad());
			pst.setString(2, transaccion.getDescripcion());
			pst.setInt(3, transaccion.getIdTransaccion());

			int filas = pst.executeUpdate();
			if (filas > 0) {
				resultado = true;
			}

		} catch (SQLException e) {
			System.err.println("Error al actualizar transacción: " + e.getMessage());
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
			String sql = "DELETE FROM Transacciones WHERE idTransaccion = ?";

			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);

			int filas = pst.executeUpdate();
			if (filas > 0) {
				resultado = true;
			}

		} catch (SQLException e) {
			System.err.println("Error al eliminar transacción: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, null);
		}

		return resultado;
	}

	public Transaccion obtenerPorId(int id) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Transaccion transaccion = null;

		try {
			conn = DatabaseConnection.conectar();
			String sql = "SELECT * FROM Transacciones WHERE idTransaccion = ?";

			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);

			rs = pst.executeQuery();
			if (rs.next()) {
				transaccion = new Transaccion();
				transaccion.setIdTransaccion(rs.getInt("idTransaccion"));
				transaccion.setIdContabilidad(rs.getInt("idContabilidad"));
				transaccion.setDescripcion(rs.getString("descripcion"));
			}

		} catch (SQLException e) {
			System.err.println("Error al obtener transacción: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, rs);
		}

		return transaccion;
	}

	public List<Transaccion> obtenerTodos() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Transaccion> transacciones = new ArrayList<>();

		try {
			conn = DatabaseConnection.conectar();
			String sql = "SELECT * FROM Transacciones";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				Transaccion transaccion = new Transaccion();
				transaccion.setIdTransaccion(rs.getInt("idTransaccion"));
				transaccion.setIdContabilidad(rs.getInt("idContabilidad"));
				transaccion.setDescripcion(rs.getString("descripcion"));

				transacciones.add(transaccion);
			}

		} catch (SQLException e) {
			System.err.println("Error al obtener todas las transacciones: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, rs);
		}

		return transacciones;
	}

	public List<Transaccion> obtenerPorContabilidad(int idContabilidad) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Transaccion> transacciones = new ArrayList<>();

		try {
			conn = DatabaseConnection.conectar();
			String sql = "SELECT * FROM Transacciones WHERE idContabilidad = ?";

			pst = conn.prepareStatement(sql);
			pst.setInt(1, idContabilidad);

			rs = pst.executeQuery();
			while (rs.next()) {
				Transaccion transaccion = new Transaccion();
				transaccion.setIdTransaccion(rs.getInt("idTransaccion"));
				transaccion.setIdContabilidad(rs.getInt("idContabilidad"));
				transaccion.setDescripcion(rs.getString("descripcion"));

				transacciones.add(transaccion);
			}

		} catch (SQLException e) {
			System.err.println("Error al obtener transacciones por contabilidad: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, rs);
		}

		return transacciones;
	}
}
