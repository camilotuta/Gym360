package main.java.com.Gym360.model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import main.java.com.Gym360.model.classes.Nomina;
import main.java.com.Gym360.util.database.DatabaseConnection;

public class NominaDAO {

	public boolean insertar(Nomina nomina) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean resultado = false;

		try {
			conn = DatabaseConnection.conectar();
			String sql = "INSERT INTO Nomina (fecha, salarioBase, deducciones, bonificaciones, idEmpleado) "
				+ "VALUES (?, ?, ?, ?, ?)";

			pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, nomina.getFecha());
			pst.setDouble(2, nomina.getSalarioBase());
			pst.setDouble(3, nomina.getDeducciones());
			pst.setDouble(4, nomina.getBonificaciones());
			pst.setInt(5, nomina.getIdEmpleado());

			int filas = pst.executeUpdate();
			if (filas > 0) {
				resultado = true;
				rs = pst.getGeneratedKeys();
				if (rs.next()) {
					nomina.setIdNomina(rs.getInt(1));
				}
			}

		} catch (SQLException e) {
			System.err.println("Error al insertar nómina: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, rs);
		}

		return resultado;
	}

	public boolean actualizar(Nomina nomina) {
		Connection conn = null;
		PreparedStatement pst = null;
		boolean resultado = false;

		try {
			conn = DatabaseConnection.conectar();
			String sql = "UPDATE Nomina SET fecha = ?, salarioBase = ?, deducciones = ?, "
				+ "bonificaciones = ?, idEmpleado = ? WHERE idNomina = ?";

			pst = conn.prepareStatement(sql);
			pst.setString(1, nomina.getFecha());
			pst.setDouble(2, nomina.getSalarioBase());
			pst.setDouble(3, nomina.getDeducciones());
			pst.setDouble(4, nomina.getBonificaciones());
			pst.setInt(5, nomina.getIdEmpleado());
			pst.setInt(6, nomina.getIdNomina());

			int filas = pst.executeUpdate();
			if (filas > 0) {
				resultado = true;
			}

		} catch (SQLException e) {
			System.err.println("Error al actualizar nómina: " + e.getMessage());
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
			String sql = "DELETE FROM Nomina WHERE idNomina = ?";

			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);

			int filas = pst.executeUpdate();
			if (filas > 0) {
				resultado = true;
			}

		} catch (SQLException e) {
			System.err.println("Error al eliminar nómina: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, null);
		}

		return resultado;
	}

	public Nomina obtenerPorId(int id) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Nomina nomina = null;

		try {
			conn = DatabaseConnection.conectar();
			String sql = "SELECT * FROM Nomina WHERE idNomina = ?";

			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);

			rs = pst.executeQuery();
			if (rs.next()) {
				nomina = new Nomina();
				nomina.setIdNomina(rs.getInt("idNomina"));
				nomina.setFecha(rs.getString("fecha"));
				nomina.setSalarioBase(rs.getDouble("salarioBase"));
				nomina.setDeducciones(rs.getDouble("deducciones"));
				nomina.setBonificaciones(rs.getDouble("bonificaciones"));
				nomina.setIdEmpleado(rs.getInt("idEmpleado"));
			}

		} catch (SQLException e) {
			System.err.println("Error al obtener nómina: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, rs);
		}

		return nomina;
	}

	public List<Nomina> obtenerTodos() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Nomina> nominas = new ArrayList<>();

		try {
			conn = DatabaseConnection.conectar();
			String sql = "SELECT * FROM Nomina";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				Nomina nomina = new Nomina();
				nomina.setIdNomina(rs.getInt("idNomina"));
				nomina.setFecha(rs.getString("fecha"));
				nomina.setSalarioBase(rs.getDouble("salarioBase"));
				nomina.setDeducciones(rs.getDouble("deducciones"));
				nomina.setBonificaciones(rs.getDouble("bonificaciones"));
				nomina.setIdEmpleado(rs.getInt("idEmpleado"));

				nominas.add(nomina);
			}

		} catch (SQLException e) {
			System.err.println("Error al obtener todas las nóminas: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, rs);
		}

		return nominas;
	}
}
