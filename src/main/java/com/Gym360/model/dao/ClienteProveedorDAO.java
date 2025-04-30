// cSpell:ignore telefono
package main.java.com.Gym360.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import main.java.com.Gym360.model.classes.ClienteProveedor;
import main.java.com.Gym360.util.database.DatabaseConnection;

public class ClienteProveedorDAO {

	public boolean insertar(ClienteProveedor clienteProveedor) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean resultado = false;

		try {
			conn = DatabaseConnection.conectar();
			String sql = "INSERT INTO ClienteProveedor (nombre, apellido, telefono, email, tipo, saldo) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";

			pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, clienteProveedor.getNombre());
			pst.setString(2, clienteProveedor.getApellido());
			pst.setString(3, clienteProveedor.getTelefono());
			pst.setString(4, clienteProveedor.getEmail());
			pst.setString(5, clienteProveedor.getTipo());
			pst.setDouble(6, clienteProveedor.getSaldo());

			int filas = pst.executeUpdate();
			if (filas > 0) {
				resultado = true;
				rs = pst.getGeneratedKeys();
				if (rs.next()) {
					clienteProveedor.setId(rs.getInt(1));
				}
			}

		} catch (SQLException e) {
			System.err.println("Error al insertar cliente/proveedor: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, rs);
		}

		return resultado;
	}

	public boolean actualizar(ClienteProveedor clienteProveedor) {
		Connection conn = null;
		PreparedStatement pst = null;
		boolean resultado = false;

		try {
			conn = DatabaseConnection.conectar();
			String sql = "UPDATE ClienteProveedor SET nombre = ?, apellido = ?, telefono = ?, "
				+ "email = ?, tipo = ?, saldo = ? WHERE id = ?";

			pst = conn.prepareStatement(sql);
			pst.setString(1, clienteProveedor.getNombre());
			pst.setString(2, clienteProveedor.getApellido());
			pst.setString(3, clienteProveedor.getTelefono());
			pst.setString(4, clienteProveedor.getEmail());
			pst.setString(5, clienteProveedor.getTipo());
			pst.setDouble(6, clienteProveedor.getSaldo());
			pst.setInt(7, clienteProveedor.getId());

			int filas = pst.executeUpdate();
			if (filas > 0) {
				resultado = true;
			}

		} catch (SQLException e) {
			System.err.println("Error al actualizar cliente/proveedor: " + e.getMessage());
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
			String sql = "DELETE FROM ClienteProveedor WHERE id = ?";

			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);

			int filas = pst.executeUpdate();
			if (filas > 0) {
				resultado = true;
			}

		} catch (SQLException e) {
			System.err.println("Error al eliminar cliente/proveedor: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, null);
		}

		return resultado;
	}

	public ClienteProveedor obtenerPorId(int id) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ClienteProveedor clienteProveedor = null;

		try {
			conn = DatabaseConnection.conectar();
			String sql = "SELECT * FROM ClienteProveedor WHERE id = ?";

			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);

			rs = pst.executeQuery();
			if (rs.next()) {
				clienteProveedor = new ClienteProveedor();
				clienteProveedor.setId(rs.getInt("id"));
				clienteProveedor.setNombre(rs.getString("nombre"));
				clienteProveedor.setApellido(rs.getString("apellido"));
				clienteProveedor.setTelefono(rs.getString("telefono"));
				clienteProveedor.setEmail(rs.getString("email"));
				clienteProveedor.setTipo(rs.getString("tipo"));
				clienteProveedor.setSaldo(rs.getDouble("saldo"));
			}

		} catch (SQLException e) {
			System.err.println("Error al obtener cliente/proveedor: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, rs);
		}

		return clienteProveedor;
	}

	public List<ClienteProveedor> obtenerTodos() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<ClienteProveedor> clientesProveedores = new ArrayList<>();

		try {
			conn = DatabaseConnection.conectar();
			String sql = "SELECT * FROM ClienteProveedor";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				ClienteProveedor clienteProveedor = new ClienteProveedor();
				clienteProveedor.setId(rs.getInt("id"));
				clienteProveedor.setNombre(rs.getString("nombre"));
				clienteProveedor.setApellido(rs.getString("apellido"));
				clienteProveedor.setTelefono(rs.getString("telefono"));
				clienteProveedor.setEmail(rs.getString("email"));
				clienteProveedor.setTipo(rs.getString("tipo"));
				clienteProveedor.setSaldo(rs.getDouble("saldo"));

				clientesProveedores.add(clienteProveedor);
			}

		} catch (SQLException e) {
			System.err.println("Error al obtener todos los clientes/proveedores: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, rs);
		}

		return clientesProveedores;
	}

	public List<ClienteProveedor> obtenerPorTipo(String tipo) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<ClienteProveedor> resultado = new ArrayList<>();

		try {
			conn = DatabaseConnection.conectar();
			String sql = "SELECT * FROM ClienteProveedor WHERE tipo = ?";

			pst = conn.prepareStatement(sql);
			pst.setString(1, tipo);

			rs = pst.executeQuery();
			while (rs.next()) {
				ClienteProveedor clienteProveedor = new ClienteProveedor();
				clienteProveedor.setId(rs.getInt("id"));
				clienteProveedor.setNombre(rs.getString("nombre"));
				clienteProveedor.setApellido(rs.getString("apellido"));
				clienteProveedor.setTelefono(rs.getString("telefono"));
				clienteProveedor.setEmail(rs.getString("email"));
				clienteProveedor.setTipo(rs.getString("tipo"));
				clienteProveedor.setSaldo(rs.getDouble("saldo"));

				resultado.add(clienteProveedor);
			}

		} catch (SQLException e) {
			System.err.println("Error al obtener clientes/proveedores por tipo: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, rs);
		}

		return resultado;
	}
}
