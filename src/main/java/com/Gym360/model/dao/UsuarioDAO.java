package main.java.com.Gym360.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import main.java.com.Gym360.model.classes.Usuario;
import main.java.com.Gym360.util.database.DatabaseConnection;

public class UsuarioDAO {

    public boolean insertar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement pst = null;
        boolean resultado = false;

        try {
            conn = DatabaseConnection.conectar();
            // La clave primaria ahora es idEmpleado y no hay idUsuario como campo separado
            String sql = "INSERT INTO Usuario (idEmpleado, nombreUsuario, contraseña, cargo, correo) VALUES (?, ?, ?, ?, ?)";

            pst = conn.prepareStatement(sql);
            pst.setInt(1, usuario.getIdEmpleado());
            pst.setString(2, usuario.getNombreUsuario());
            pst.setString(3, usuario.getContraseña());
            pst.setString(4, usuario.getCargo());
            pst.setString(5, usuario.getCorreo());

            int filas = pst.executeUpdate();
            if (filas > 0) {
                resultado = true;
                // Ya no necesitamos recuperar un ID generado, ya que usamos idEmpleado
                // existente
            }

        } catch (SQLException e) {
            System.err.println("Error al insertar usuario: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, null);
        }

        return resultado;
    }

    public boolean actualizar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement pst = null;
        boolean resultado = false;

        try {
            conn = DatabaseConnection.conectar();
            // Actualización usando idEmpleado como identificador
            String sql = "UPDATE Usuario SET nombreUsuario = ?, contraseña = ?, cargo = ?, correo = ? WHERE idEmpleado = ?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, usuario.getNombreUsuario());
            pst.setString(2, usuario.getContraseña());
            pst.setString(3, usuario.getCargo());
            pst.setString(4, usuario.getCorreo());
            pst.setInt(5, usuario.getIdEmpleado());

            int filas = pst.executeUpdate();
            if (filas > 0) {
                resultado = true;
            }

        } catch (SQLException e) {
            System.err.println("Error al actualizar usuario: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, null);
        }

        return resultado;
    }

    public boolean eliminar(int idEmpleado) {
        Connection conn = null;
        PreparedStatement pst = null;
        boolean resultado = false;

        try {
            conn = DatabaseConnection.conectar();
            // Eliminación usando idEmpleado como identificador
            String sql = "DELETE FROM Usuario WHERE idEmpleado = ?";

            pst = conn.prepareStatement(sql);
            pst.setInt(1, idEmpleado);

            int filas = pst.executeUpdate();
            if (filas > 0) {
                resultado = true;
            }

        } catch (SQLException e) {
            System.err.println("Error al eliminar usuario: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, null);
        }

        return resultado;
    }

    public Usuario obtenerPorIdEmpleado(int idEmpleado) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            conn = DatabaseConnection.conectar();
            // Búsqueda por idEmpleado en lugar de idUsuario
            String sql = "SELECT * FROM Usuario WHERE idEmpleado = ?";

            pst = conn.prepareStatement(sql);
            pst.setInt(1, idEmpleado);

            rs = pst.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdEmpleado(rs.getInt("idEmpleado"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setCargo(rs.getString("cargo"));
                usuario.setCorreo(rs.getString("correo"));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener usuario: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return usuario;
    }

    public List<Usuario> obtenerTodos() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            conn = DatabaseConnection.conectar();
            String sql = "SELECT * FROM Usuario";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdEmpleado(rs.getInt("idEmpleado"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setCargo(rs.getString("cargo"));
                usuario.setCorreo(rs.getString("correo"));

                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener todos los usuarios: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return usuarios;
    }

    public List<Usuario> obtenerPorNombreUsuarioFiltro(String filtro) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            conn = DatabaseConnection.conectar();
            // Usamos LIKE para hacer una búsqueda parcial en el nombre de usuario
            String sql = "SELECT * FROM Usuario WHERE nombreUsuario LIKE ?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + filtro + "%"); // Agregamos % para buscar el filtro en cualquier parte del nombre

            rs = pst.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdEmpleado(rs.getInt("idEmpleado"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setCargo(rs.getString("cargo"));
                usuario.setCorreo(rs.getString("correo"));

                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener usuarios por filtro de nombre: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return usuarios;
    }

    public Usuario obtenerPorNombreUsuario(String nombreUsuario) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            conn = DatabaseConnection.conectar();
            String sql = "SELECT * FROM Usuario WHERE nombreUsuario = ?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, nombreUsuario);

            rs = pst.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdEmpleado(rs.getInt("idEmpleado"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setCargo(rs.getString("cargo"));
                usuario.setCorreo(rs.getString("correo"));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener usuario por nombre: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return usuario;
    }

    public List<Usuario> obtenerPorCargo(String cargo) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            conn = DatabaseConnection.conectar();
            String sql = "SELECT * FROM Usuario WHERE cargo = ?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, cargo);

            rs = pst.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdEmpleado(rs.getInt("idEmpleado"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setCargo(rs.getString("cargo"));
                usuario.setCorreo(rs.getString("correo"));

                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener usuarios por cargo: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return usuarios;
    }

    public Usuario obtenerPorCorreo(String correo) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            conn = DatabaseConnection.conectar();
            String sql = "SELECT * FROM Usuario WHERE correo = ?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, correo);

            rs = pst.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdEmpleado(rs.getInt("idEmpleado"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setCargo(rs.getString("cargo"));
                usuario.setCorreo(rs.getString("correo"));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener usuario por correo: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return usuario;
    }
}