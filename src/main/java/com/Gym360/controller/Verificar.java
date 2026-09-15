// cSpell:ignore cedula telefono ZáéíóúÁÉÍÓ ÚñÑ desencriptada
package main.java.com.Gym360.controller;

import java.util.regex.Pattern;

import main.java.com.Gym360.model.security.Desencriptar;

public class Verificar {
    // Validar correo electrónico

    public static boolean validarCorreo(String correo) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return Pattern.matches(regex, correo);
    }

    // Validar cédula colombiana (solo números, entre 6 y 10 dígitos normalmente)
    public static boolean validarCedula(String cedula) {
        String regex = "^\\d{6,10}$";
        return Pattern.matches(regex, cedula);
    }

    // Validar número telefónico colombiano (móvil: empieza por 3 y tiene 10 dígitos)
    public static boolean validarTelefono(String telefono) {
        String regex = "^3\\d{9}$";
        return Pattern.matches(regex, telefono);
    }

    // Validar nombre (solo letras, tildes y espacios)
    public static boolean validarNombre(String nombre) {
        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$";
        return Pattern.matches(regex, nombre);
    }

    // Validar edad (entre 0 y 120)
    public static boolean validarEdad(int edad) {
        return edad >= 0 && edad <= 120;
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
// Validar contraseña (mínimo 8 caracteres, al menos una mayúscula, una minúscula, un número y un carácter especial)

    public static boolean validarContraseña(char[] contraseña) {
        String contraseñaDesencriptada = Desencriptar.desencriptarContra(contraseña);
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return Pattern.matches(regex, contraseñaDesencriptada);
    }

}
