// cSpell:ignore descripcion categoria codigo telefono contratacion
package main.java.com.Gym360.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.java.com.Gym360.model.classes.Producto;
import main.java.com.Gym360.util.database.DatabaseConnection;

public class ProductoDAO {

	public List<Producto> obtenerProductosConFiltro(String filtro) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Producto> listaProductos = new ArrayList<>();

		try {
			conn = DatabaseConnection.conectar();
			String sql = "SELECT * FROM Producto WHERE nombre LIKE ? OR descripcion LIKE ?"; // Filtrar por nombre o
																								// descripción

			pst = conn.prepareStatement(sql);
			pst.setString(1, "%" + filtro + "%"); // Filtro para nombre
			pst.setString(2, "%" + filtro + "%"); // Filtro para descripción
			rs = pst.executeQuery();

			while (rs.next()) {
				Producto producto = new Producto();
				producto.setIdProducto(rs.getInt("idProducto"));
				producto.setNombre(rs.getString("nombre"));
				producto.setDescripcion(rs.getString("descripcion"));
				producto.setPrecioUnitario(rs.getDouble("precioUnitario"));
				producto.setStock(rs.getInt("stock"));
				producto.setCategoria(rs.getString("categoria"));
				producto.setCodigoBarras(rs.getString("codigoBarras"));

				listaProductos.add(producto);
			}

		} catch (SQLException e) {
			System.err.println("Error al obtener los productos con filtro: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, rs);
		}

		return listaProductos;
	}

	public boolean insertar(Producto producto) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean resultado = false;

		try {
			conn = DatabaseConnection.conectar();
			String sql = "INSERT INTO Producto (nombre, descripcion, precioUnitario, stock, categoria, codigoBarras) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";

			pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, producto.getNombre());
			pst.setString(2, producto.getDescripcion());
			pst.setDouble(3, producto.getPrecioUnitario());
			pst.setInt(4, producto.getStock());
			pst.setString(5, producto.getCategoria());
			pst.setString(6, producto.getCodigoBarras());

			int filas = pst.executeUpdate();
			if (filas > 0) {
				resultado = true;
				rs = pst.getGeneratedKeys();
				if (rs.next()) {
					producto.setIdProducto(rs.getInt(1));
				}
			}

		} catch (SQLException e) {
			System.err.println("Error al insertar producto: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, rs);
		}

		return resultado;
	}

	public boolean actualizar(Producto producto) {
		Connection conn = null;
		PreparedStatement pst = null;
		boolean resultado = false;

		try {
			conn = DatabaseConnection.conectar();
			String sql = "UPDATE Producto SET nombre = ?, descripcion = ?, precioUnitario = ?, "
					+ "stock = ?, categoria = ?, codigoBarras = ? WHERE idProducto = ?";

			pst = conn.prepareStatement(sql);
			pst.setString(1, producto.getNombre());
			pst.setString(2, producto.getDescripcion());
			pst.setDouble(3, producto.getPrecioUnitario());
			pst.setInt(4, producto.getStock());
			pst.setString(5, producto.getCategoria());
			pst.setString(6, producto.getCodigoBarras());
			pst.setInt(7, producto.getIdProducto());

			int filas = pst.executeUpdate();
			if (filas > 0) {
				resultado = true;
			}

		} catch (SQLException e) {
			System.err.println("Error al actualizar producto: " + e.getMessage());
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
			String sql = "DELETE FROM Producto WHERE idProducto = ?";

			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);

			int filas = pst.executeUpdate();
			if (filas > 0) {
				resultado = true;
			}

		} catch (SQLException e) {
			System.err.println("Error al eliminar producto: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, null);
		}

		return resultado;
	}

	public Producto obtenerPorId(int id) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Producto producto = null;

		try {
			conn = DatabaseConnection.conectar();
			String sql = "SELECT * FROM Producto WHERE idProducto = ?";

			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);

			rs = pst.executeQuery();
			if (rs.next()) {
				producto = new Producto();
				producto.setIdProducto(rs.getInt("idProducto"));
				producto.setNombre(rs.getString("nombre"));
				producto.setDescripcion(rs.getString("descripcion"));
				producto.setPrecioUnitario(rs.getDouble("precioUnitario"));
				producto.setStock(rs.getInt("stock"));
				producto.setCategoria(rs.getString("categoria"));
				producto.setCodigoBarras(rs.getString("codigoBarras"));
			}

		} catch (SQLException e) {
			System.err.println("Error al obtener producto: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, rs);
		}

		return producto;
	}

	public List<Producto> obtenerTodos() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Producto> productos = new ArrayList<>();

		try {
			conn = DatabaseConnection.conectar();
			String sql = "SELECT * FROM Producto";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				Producto producto = new Producto();
				producto.setIdProducto(rs.getInt("idProducto"));
				producto.setNombre(rs.getString("nombre"));
				producto.setDescripcion(rs.getString("descripcion"));
				producto.setPrecioUnitario(rs.getDouble("precioUnitario"));
				producto.setStock(rs.getInt("stock"));
				producto.setCategoria(rs.getString("categoria"));
				producto.setCodigoBarras(rs.getString("codigoBarras"));

				productos.add(producto);
			}

		} catch (SQLException e) {
			System.err.println("Error al obtener todos los productos: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, rs);
		}

		return productos;
	}

	public List<Producto> obtenerPorCategoria(String categoria) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Producto> productos = new ArrayList<>();

		try {
			conn = DatabaseConnection.conectar();
			String sql = "SELECT * FROM Producto WHERE categoria = ?";

			pst = conn.prepareStatement(sql);
			pst.setString(1, categoria);

			rs = pst.executeQuery();
			while (rs.next()) {
				Producto producto = new Producto();
				producto.setIdProducto(rs.getInt("idProducto"));
				producto.setNombre(rs.getString("nombre"));
				producto.setDescripcion(rs.getString("descripcion"));
				producto.setPrecioUnitario(rs.getDouble("precioUnitario"));
				producto.setStock(rs.getInt("stock"));
				producto.setCategoria(rs.getString("categoria"));
				producto.setCodigoBarras(rs.getString("codigoBarras"));

				productos.add(producto);
			}

		} catch (SQLException e) {
			System.err.println("Error al obtener productos por categoría: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, rs);
		}

		return productos;
	}

	public Producto obtenerPorCodigoBarras(String codigoBarras) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Producto producto = null;

		try {
			conn = DatabaseConnection.conectar();
			String sql = "SELECT * FROM Producto WHERE codigoBarras = ?";

			pst = conn.prepareStatement(sql);
			pst.setString(1, codigoBarras);

			rs = pst.executeQuery();
			if (rs.next()) {
				producto = new Producto();
				producto.setIdProducto(rs.getInt("idProducto"));
				producto.setNombre(rs.getString("nombre"));
				producto.setDescripcion(rs.getString("descripcion"));
				producto.setPrecioUnitario(rs.getDouble("precioUnitario"));
				producto.setStock(rs.getInt("stock"));
				producto.setCategoria(rs.getString("categoria"));
				producto.setCodigoBarras(rs.getString("codigoBarras"));
			}

		} catch (SQLException e) {
			System.err.println("Error al obtener producto por código de barras: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, rs);
		}

		return producto;
	}

	public boolean actualizarStock(int idProducto, int nuevoStock) {
		Connection conn = null;
		PreparedStatement pst = null;
		boolean resultado = false;

		try {
			conn = DatabaseConnection.conectar();
			String sql = "UPDATE Producto SET stock = ? WHERE idProducto = ?";

			pst = conn.prepareStatement(sql);
			pst.setInt(1, nuevoStock);
			pst.setInt(2, idProducto);

			int filas = pst.executeUpdate();
			if (filas > 0) {
				resultado = true;
			}

		} catch (SQLException e) {
			System.err.println("Error al actualizar stock: " + e.getMessage());
		} finally {
			DatabaseConnection.cerrarConexion(conn, pst, null);
		}

		return resultado;
	}
}
