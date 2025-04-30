package main.java.com.Gym360.util.ui;

import static main.java.com.Gym360.util.dates.Dates.formatter;
import java.awt.Image;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

import raven.datetime.component.date.DatePicker;

public class CambiarIU {

    public void setImageLabel(JLabel labelName, String path) {
        SwingUtilities.invokeLater(() -> {
            URL imageURL = getClass().getResource(path);
            if (imageURL != null) {
                ImageIcon image = new ImageIcon(imageURL);
                Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(),
                        labelName.getHeight(), Image.SCALE_SMOOTH));
                labelName.setIcon(icon);
            } else {
                System.err.println("No se encontró la imagen: " + path);
            }
        });
    }

    public static void setImageLabelSize(JLabel labelName, String root, int width, int height) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
    }

    public static void ponerTextoEtiqueta(JLabel label, String texto) {
        label.setText(texto);
    }

    public static void ponerTextoCampo(JTextField field, String texto) {
        field.setText(texto);
    }

    public static void ponerTextoArea(JTextArea txtArea, String texto) {
        txtArea.setText(texto);
    }

    public static void ponerTextoPanel(JTextPane txtPanel, String texto) {
        txtPanel.setText(texto);
    }

    public static void ponerTextoCampoContraseña(JPasswordField contraseñaField, String texto) {
        contraseñaField.setText(texto);
    }

    public static String obtenerFechaSeleccionada(DatePicker datePicker) {
        return formatter.format(datePicker.getSelectedDate());
    }

    public static void deshabilitarBotones(JButton... args) {
        for (JButton b : args) {
            b.setEnabled(false);
        }
    }

    public static void habilitarBotones(JButton... args) {
        for (JButton b : args) {
            b.setEnabled(true);
        }
    }

    // Función para vaciar el JComboBox
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void vaciarCombo(JComboBox comboBox) {
        comboBox.removeAllItems();
        comboBox.addItem("Seleccionar");
    }

    // Función para poner el índice seleccionado en el JComboBox
    public static void ponerIndiceCombo(JComboBox comboBox, int indice) {
        if (indice >= 0 && indice < comboBox.getItemCount()) {
            comboBox.setSelectedIndex(indice);
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }

    // Función para añadir un elemento al JComboBox
    public static void ponerSeleccionCombo(JComboBox comboBox, String elemento) {
        comboBox.setSelectedItem(elemento);
        comboBox.setSelectedItem(elemento);
    }
}
