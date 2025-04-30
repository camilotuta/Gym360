// cSpell:ignore desencriptada desencriptar
package main.java.com.Gym360.controller;

import main.java.com.Gym360.model.classes.Usuario;
import main.java.com.Gym360.model.dao.UsuarioDAO;
import main.java.com.Gym360.model.security.Desencriptar;

public class Ingresar {

    private static final UsuarioDAO usuarioDao = new UsuarioDAO();

    public static boolean UsuarioValido(String correo, char[] contraseña) {
        var usuarios = usuarioDao.obtenerTodos();

        for (Usuario u : usuarios) {
            String contraseñaDesencriptada = Desencriptar.desencriptarContra(u.getContraseña().toCharArray());
            if (u.getCorreo().equals(correo) && contraseñaDesencriptada.equals(String.valueOf(contraseña))) {
                return true;
            }
        }
        return false;
    }

    public static String obtenerCargo(String correo, char[] contraseña) {
        var usuarios = usuarioDao.obtenerTodos();

        for (Usuario u : usuarios) {
            String contraseñaDesencriptada = Desencriptar.desencriptarContra(u.getContraseña().toCharArray());
            if (u.getCorreo().equals(correo) && contraseñaDesencriptada.equals(String.valueOf(contraseña))) {
                return u.getCargo(); // <<<< Aquí obtenemos el cargo del usuario encontrado
            }
        }
        return null; // Si no encuentra al usuario válido
    }
}
