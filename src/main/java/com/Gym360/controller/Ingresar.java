<<<<<<< HEAD
package main.java.com.Gym360.controller;

import main.java.com.Gym360.model.classes.Usuario;
import main.java.com.Gym360.model.dao.UsuarioDAO;
import main.java.com.Gym360.model.security.Desencriptar;
=======
// cSpell:ignore desencriptada desencriptar
package main.java.com.Gym360.controller;

import main.java.com.Gym360.model.classes.Cliente;
import main.java.com.Gym360.model.classes.Usuario;
import main.java.com.Gym360.model.dao.ClienteDAO;
import main.java.com.Gym360.model.dao.UsuarioDAO;
import main.java.com.Gym360.model.security.Desencriptar;
import main.java.com.Gym360.view.Login;
>>>>>>> 70a63f6aa761c84ebea74d562a15e606472b20a3

public class Ingresar {

    private static final UsuarioDAO usuarioDao = new UsuarioDAO();
<<<<<<< HEAD
=======
    private static final ClienteDAO clienteDao = new ClienteDAO();
>>>>>>> 70a63f6aa761c84ebea74d562a15e606472b20a3

    public static boolean UsuarioValido(String correo, char[] contraseña) {
        var usuarios = usuarioDao.obtenerTodos();

        for (Usuario u : usuarios) {
            String contraseñaDesencriptada = Desencriptar.desencriptarContra(u.getContraseña().toCharArray());
            if (u.getCorreo().equals(correo) && contraseñaDesencriptada.equals(String.valueOf(contraseña))) {
<<<<<<< HEAD
=======
                Login.idGuardar = String.valueOf(u.getIdEmpleado());
                return true;
            }
        }
        return false;
    }

    public static boolean ClienteValido(String correo, char[] contraseña) {
        var clientes = clienteDao.obtenerTodos();

        for (Cliente u : clientes) {
            System.out.println(u);
            String contraseñaDesencriptada = Desencriptar.desencriptarContra(u.getContraseña().toCharArray());
            if (u.getEmail().equals(correo) && contraseñaDesencriptada.equals(String.valueOf(contraseña))) {
>>>>>>> 70a63f6aa761c84ebea74d562a15e606472b20a3
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
<<<<<<< HEAD
		return u.getCargo(); // <<<< Aquí obtenemos el cargo del usuario encontrado
=======
                return u.getCargo().toLowerCase(); // <<<< Aquí obtenemos el cargo del usuario encontrado
>>>>>>> 70a63f6aa761c84ebea74d562a15e606472b20a3
            }
        }
        return null; // Si no encuentra al usuario válido
    }
}
