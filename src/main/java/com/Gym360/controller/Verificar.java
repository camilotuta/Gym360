// cSpell:ignore cedula telefono ZáéíóúÁÉÍÓ ÚñÑ desencriptada desencriptar seleccion descripcion codigo
package main.java.com.Gym360.controller;

import java.util.regex.Pattern;

import main.java.com.Gym360.model.classes.Producto;
import main.java.com.Gym360.model.classes.Usuario;
import main.java.com.Gym360.model.dao.ProductoDAO;
import main.java.com.Gym360.model.dao.UsuarioDAO;
import main.java.com.Gym360.model.security.Desencriptar;

public class Verificar {
    // Validar correo electrónico

    public static boolean validarCorreo(String correo) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return Pattern.matches(regex, correo);
    }

    public static boolean validarYVerificarCedulaSeleccionada(String cedula, int idSeleccionado) {
        return Integer.parseInt(cedula) == idSeleccionado;
    }

    public static boolean validarYVerificarCedula(String cedula) {
        // Validar formato: solo números, entre 6 y 10 dígitos
        String regex = "^\\d{6,10}$";
        if (!Pattern.matches(regex, cedula)) {
            return false;
        }

        // Verificar unicidad en la base de datos
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioExistente = usuarioDAO.obtenerPorIdEmpleado(Integer.parseInt(cedula)); // Asumiendo que existe
                                                                                              // este

        if (usuarioExistente == null) {
            return true;
        }

        return false;
    }

    // Validar número telefónico colombiano (móvil: empieza por 3 y tiene 10
    // dígitos)
    public static boolean validarTelefono(String telefono) {
        String regex = "^3\\d{9}$";
        return Pattern.matches(regex, telefono);
    }

    // Validar nombre (solo letras, tildes y espacios)
    public static boolean validarNombre(String nombre) {
        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$";
        return Pattern.matches(regex, nombre);
    }

    public static boolean validarDescripcion(String descripcion) {
        String regex = "^[0-9a-zA-ZáéíóúÁÉÍÓÚñÑ\\s.,;:!?\"'()\\-]+$";
        return Pattern.matches(regex, descripcion);
    }

    // Validar edad (entre 0 y 120)
    public static boolean validarEdad(int edad) {
        return edad >= 0 && edad <= 120;
    }

    public static boolean validarPrecio(String precio) {
        try {
            return Double.parseDouble(precio) >= 0;

        } catch (Exception e) {
            return false;
        }
    }

    public static boolean validarComboBox(String seleccion) {
        return !seleccion.equals("Seleccionar");
    }

    public static boolean validarStock(String stock) {

        try {
            return Integer.parseInt(stock) >= 0 && Integer.parseInt(stock) < 10_000;

        } catch (Exception e) {
            return false;
        }
    }

    // Sobrecarga para edad ingresada como String
    public static boolean validarEdad(String edad) {
        try {
            int e = Integer.parseInt(edad);
            return validarEdad(e);
        } catch (NumberFormatException e) {
            return false;
        }
    }
    // Validar contraseña (mínimo 8 caracteres, al menos una mayúscula, una
    // minúscula, un número y un carácter especial)

    public static boolean validarContraseña(char[] contraseña) {
        String contraseñaDesencriptada = Desencriptar.desencriptarContra(contraseña);
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return Pattern.matches(regex, contraseñaDesencriptada);
    }

    public static boolean validarYVerificarCodigoBarras(String codigoBarras, int idProducto) {
        // Validar formato: solo números, entre 8 y 13 dígitos
        String regex = "^\\d{8,13}$";
        if (!Pattern.matches(regex, codigoBarras)) {
            return false;
        }

        // Verificar unicidad en la base de datos
        ProductoDAO productoDAO = new ProductoDAO();
        Producto productoExistente = productoDAO.obtenerPorCodigoBarras(codigoBarras);

        if (productoExistente == null) {
            return true;
        }
        if (idProducto == productoExistente.getIdProducto()) {
            return true;
        }

        return false;
    }

}
