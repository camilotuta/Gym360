package main.java.com.Gym360.model.security;

//cSpell:ignore condicion cedula ÁÉÍÓ Úáéíóú codigo

import java.util.regex.Pattern;

import javax.swing.JLabel;
import main.java.com.Gym360.util.ui.CambiarIU;


public class VerificarDato {

    public static void verificarCampo(boolean condicion, JLabel labelPonerImagen, String toolTipTextSi,
            String toolTipTextNo) {

        if (condicion) {
            ponerImagenError(labelPonerImagen, toolTipTextNo);
        } else {
            ponerImagenCheck(labelPonerImagen, toolTipTextSi);
        }
    }

    public static void ponerImagenError(JLabel labelPonerImagen, String toolTipTextNo) {
        new CambiarIU().setImageLabel(labelPonerImagen,
                "/main/resources/assets/img/error.png");
        labelPonerImagen.setToolTipText(toolTipTextNo);
    }

    public static void ponerImagenCheck(JLabel labelPonerImagen, String toolTipTextSi) {
        new CambiarIU().setImageLabel(labelPonerImagen,
                "/main/resources/assets/img/check.png");
        labelPonerImagen.setToolTipText(toolTipTextSi);
    }

    public static boolean nombreValido(String nombre) {
        return Pattern.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]{10,50}$", nombre);
    }

    public static boolean codigoPromocionalValido(String codigoPromocional) {
        return Pattern.matches("^[A-Za-z0-9-]{5,20}$", codigoPromocional);
    }

    public static boolean correoValido(String correo) {
        return Pattern.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$", correo);

    }

    public static boolean cedulaValida(String cedula) {
        return Pattern.matches("^\\d{6,10}$", cedula);

    }

    public static boolean contraseñaValida(String contraseña) {
        return Pattern.matches(
                "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[.@$!%*?&,+\\-_{}\\/])[A-Za-z\\d.@$!%*?&,+\\-_{}\\/]{8,}$",
                contraseña);
    }

    public static boolean codigoValido(String codigo) {

        return Pattern.matches("^\\d{6}$", codigo);

    }

    public static boolean confirmarContraseñaValida(String contraseña, String confirmarContraseña) {
        return contraseñaValida(contraseña) && contraseñaValida(confirmarContraseña)
                && confirmarContraseña.equals(contraseña);

    }
}