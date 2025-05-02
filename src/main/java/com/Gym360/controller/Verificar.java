// cSpell:ignore cedula telefono ZáéíóúÁÉÍÓ ÚñÑ desencriptada desencriptar seleccion descripcion codigo minimo smlv
package main.java.com.Gym360.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

import main.java.com.Gym360.model.classes.Empleado;
import main.java.com.Gym360.model.classes.Producto;
import main.java.com.Gym360.model.classes.Usuario;
import main.java.com.Gym360.model.dao.EmpleadoDAO;
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
        try {
            return Integer.parseInt(cedula) == idSeleccionado;

        } catch (Exception e) {
            return false;
        }
    }

    public static boolean validarYVerificarCedulaUsuario(String cedula) {
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

    public static boolean validarYVerificarCedulaEmpleado(String cedula) {
        // Validar formato: solo números, entre 6 y 10 dígitos
        String regex = "^\\d{6,10}$";
        if (!Pattern.matches(regex, cedula)) {
            return false;
        }

        // Verificar unicidad en la base de datos
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        Empleado empleadoExistente = empleadoDAO.obtenerPorId(Integer.parseInt(cedula)); // Asumiendo que existe
                                                                                         // este

        if (empleadoExistente == null) {
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

    public static boolean validarSalario(String salario) {
        try {
            Double salarioD = Double.parseDouble(salario);
            final double SALARIO_MINIMO_2025 = 1_423_500.0; // Valor sin auxilio de transporte
            return salarioD > SALARIO_MINIMO_2025;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean validarFechaMenorIgualHoy(String fechaStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate fechaIngresada = LocalDate.parse(fechaStr, formatter);
            LocalDate fechaActual = LocalDate.now();
            return !fechaIngresada.isAfter(fechaActual); // Retorna true si la fecha ingresada es hoy o anterior
        } catch (DateTimeParseException e) {
            return false; // La fecha no tiene el formato correcto o es inválida
        }
    }

}
