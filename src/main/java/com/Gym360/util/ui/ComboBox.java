// cspell:ignore rawtypes seleccion
package main.java.com.Gym360.util.ui;

import javax.swing.JComboBox;

public class ComboBox {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void vaciarCombo(JComboBox comboBox) {
        comboBox.removeAllItems();
        comboBox.addItem("Seleccionar");
    }
}