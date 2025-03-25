package main.java.com.Gym360.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import main.java.com.Gym360.model.classes.User;
import main.java.com.Gym360.util.database.DatabaseConnection;

public class UsuariosDAO {

    // Retrieves all users from the Usuario table.
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM Usuario";
        Connection conn = null;
        PreparedStatement pSt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            rs = pSt.executeQuery();

            while (rs.next()) {
                User user = new User();
                // Set idUsuario as an integer (no conversion to String)
                user.setIdUsuario(rs.getInt("idUsuario"));
                user.setNombreUsuario(rs.getString("nombreUsuario"));
                user.setContraseña(rs.getString("contraseña"));
                user.setCargo(rs.getString("cargo"));
                
                // Handle idEmpleado which is nullable.
                int idEmpleado = rs.getInt("idEmpleado");
                if (rs.wasNull()) {
                    user.setIdEmpleado(null);
                } else {
                    user.setIdEmpleado(idEmpleado);
                }
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, rs);
        }
        return users;
    }

    // Retrieves a single user by its idUsuario.
    public User getUserById(String id) {
        User user = null;
        String query = "SELECT * FROM Usuario WHERE idUsuario = ?";
        Connection conn = null;
        PreparedStatement pSt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            // Parse the String id to an integer since idUsuario is INTEGER.
            pSt.setInt(1, Integer.parseInt(id));
            rs = pSt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setIdUsuario(rs.getInt("idUsuario"));
                user.setNombreUsuario(rs.getString("nombreUsuario"));
                user.setContraseña(rs.getString("contraseña"));
                user.setCargo(rs.getString("cargo"));
                
                int idEmpleado = rs.getInt("idEmpleado");
                if (rs.wasNull()) {
                    user.setIdEmpleado(null);
                } else {
                    user.setIdEmpleado(idEmpleado);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, rs);
        }
        return user;
    }

    // Inserts a new user into the Usuario table.
    // Since idUsuario is AUTOINCREMENT, it is not provided in the INSERT.
    public boolean insertUser(User user) {
        boolean inserted = false;
        String query = "INSERT INTO Usuario (nombreUsuario, contraseña, cargo, idEmpleado) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pSt = null;

        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setString(1, user.getNombreUsuario());
            pSt.setString(2, user.getContraseña());
            pSt.setString(3, user.getCargo());
            // Handle idEmpleado: if null, set as SQL NULL; otherwise, set the integer value.
            if (user.getIdEmpleado() == null) {
                pSt.setNull(4, java.sql.Types.INTEGER);
            } else {
                pSt.setInt(4, user.getIdEmpleado());
            }
            inserted = pSt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, null);
        }
        return inserted;
    }

    // Updates an existing user record.
    public boolean updateUser(User user) {
        boolean updated = false;
        String query = "UPDATE Usuario SET nombreUsuario = ?, contraseña = ?, cargo = ?, idEmpleado = ? WHERE idUsuario = ?";
        Connection conn = null;
        PreparedStatement pSt = null;

        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setString(1, user.getNombreUsuario());
            pSt.setString(2, user.getContraseña());
            pSt.setString(3, user.getCargo());
            if (user.getIdEmpleado() == null) {
                pSt.setNull(4, java.sql.Types.INTEGER);
            } else {
                pSt.setInt(4, user.getIdEmpleado());
            }
            pSt.setInt(5, user.getIdUsuario());
            updated = pSt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, null);
        }
        return updated;
    }

    // Deletes a user based on idUsuario.
    public boolean deleteUser(String id) {
        boolean deleted = false;
        String query = "DELETE FROM Usuario WHERE idUsuario = ?";
        Connection conn = null;
        PreparedStatement pSt = null;

        try {
            conn = DatabaseConnection.conectar();
            pSt = conn.prepareStatement(query);
            pSt.setInt(1, Integer.parseInt(id));
            deleted = pSt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.cerrarConexion(conn, pSt, null);
        }
        return deleted;
    }
}
