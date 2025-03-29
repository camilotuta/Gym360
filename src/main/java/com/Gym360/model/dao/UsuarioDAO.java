package main.java.com.Gym360.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import main.java.com.Gym360.model.classes.Usuario;
import main.java.com.Gym360.util.database.DatabaseConnection;

public class UsuarioDAO {

    public boolean insertar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean resultado = false;

        try {
            conn = DatabaseConnection.conectar();
            String sql = "INSERT INTO Usuarios (nombreUsuario, contraseña, cargo, idEmpleado) VALUES (?, ?, ?, ?)";

            pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, usuario.getNombreUsuario());
            pst.setString(2, usuario.getContraseña());
            pst.setString(3, usuario.getCargo());
            pst.setInt(4, usuario.getIdEmpleado());

            int filas = pst.executeUpdate();
            if (filas > 0) {
                resultado = true;
                rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    usuario.setIdUsuario(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al insertar usuario: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return resultado;
    }

    public boolean actualizar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement pst = null;
        boolean resultado = false;

        try {
            conn = DatabaseConnection.conectar();
            String sql = "UPDATE Usuarios SET nombreUsuario = ?, contraseña = ?, cargo = ?, idEmpleado = ? WHERE idUsuario = ?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, usuario.getNombreUsuario());
            pst.setString(2, usuario.getContraseña());
            pst.setString(3, usuario.getCargo());
            pst.setInt(4, usuario.getIdEmpleado());
            pst.setInt(5, usuario.getIdUsuario());

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

    public boolean eliminar(int id) {
        Connection conn = null;
        PreparedStatement pst = null;
        boolean resultado = false;

        try {
            conn = DatabaseConnection.conectar();
            String sql = "DELETE FROM Usuarios WHERE idUsuario = ?";

            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);

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

    public Usuario obtenerPorId(int id) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            conn = DatabaseConnection.conectar();
            String sql = "SELECT * FROM Usuarios WHERE idUsuario = ?";

            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);

            rs = pst.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setCargo(rs.getString("cargo"));
                usuario.setIdEmpleado(rs.getInt("idEmpleado"));
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
            String sql = "SELECT * FROM Usuarios";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setCargo(rs.getString("cargo"));
                usuario.setIdEmpleado(rs.getInt("idEmpleado"));

                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener todos los usuarios: " + e.getMessage());
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
            String sql = "SELECT * FROM Usuarios WHERE nombreUsuario = ?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, nombreUsuario);

            rs = pst.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setCargo(rs.getString("cargo"));
                usuario.setIdEmpleado(rs.getInt("idEmpleado"));
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
            String sql = "SELECT * FROM Usuarios WHERE cargo = ?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, cargo);

            rs = pst.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setCargo(rs.getString("cargo"));
                usuario.setIdEmpleado(rs.getInt("idEmpleado"));

                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener usuarios por cargo: " + e.getMessage());
        } finally {
            DatabaseConnection.cerrarConexion(conn, pst, rs);
        }

        return usuarios;
    }
}