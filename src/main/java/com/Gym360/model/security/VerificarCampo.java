package main.java.com.Gym360.model.security;

//cSpell:ignore condicion cedula ÁÉÍÓ Úáéíóú codigo

import javax.swing.JLabel;
import main.java.com.Gym360.util.ui.CambiarIU;

public class VerificarCampo {

    public static void verificarCampo(boolean condicion, JLabel labelPonerImagen, String toolTipTextSi,
            String toolTipTextNo) {

        if (!condicion) {
            ponerImagenError(labelPonerImagen, toolTipTextNo);
        } else {
            ponerImagenCheck(labelPonerImagen, toolTipTextSi);
        }
    }

    public static void ponerImagenError(JLabel labelPonerImagen, String toolTipTextNo) {
        new CambiarIU().setImageLabel(labelPonerImagen, "/main/resources/images/error.png");
        labelPonerImagen.setToolTipText(toolTipTextNo);
    }

    public static void ponerImagenCheck(JLabel labelPonerImagen, String toolTipTextSi) {
        new CambiarIU().setImageLabel(labelPonerImagen, "/main/resources/images/check.png");
        labelPonerImagen.setToolTipText(toolTipTextSi);
    }
}