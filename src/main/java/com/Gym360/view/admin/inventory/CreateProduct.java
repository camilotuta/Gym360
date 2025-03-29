/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.java.com.Gym360.view.admin.inventory;

import main.java.com.Gym360.view.admin.users.*;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.UIManager;

/**
 *
 * @author tutaa
 */
public class CreateProduct extends javax.swing.JFrame {

	/**
	 * Creates new form ManageUsersScreen
	 */
	public CreateProduct() {
		initComponents();
		this.setTitle("Registrar Producto");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/resources/images/logo.png")));
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                panelCrearProducto = new javax.swing.JPanel();
                pMenu = new javax.swing.JPanel();
                lbBackButton = new javax.swing.JLabel();
                lbCrearProducto = new javax.swing.JLabel();
                lbNombre = new javax.swing.JLabel();
                tfNombre = new javax.swing.JTextField();
                lbDescripcion = new javax.swing.JLabel();
                spDescripcion = new javax.swing.JScrollPane();
                taDescripcion = new javax.swing.JTextArea();
                lbPrecioUnidad = new javax.swing.JLabel();
                tfPrecioUnidad = new javax.swing.JTextField();
                lbStock = new javax.swing.JLabel();
                tfStock = new javax.swing.JTextField();
                lbCategoria = new javax.swing.JLabel();
                cbCategoria = new javax.swing.JComboBox<>();
                imgCrearProducto = new javax.swing.JLabel();
                btnCrearProducto = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                panelCrearProducto.setBackground(new java.awt.Color(245, 245, 245));
                panelCrearProducto.setMaximumSize(new java.awt.Dimension(1467, 800));
                panelCrearProducto.setMinimumSize(new java.awt.Dimension(1467, 800));
                panelCrearProducto.setPreferredSize(new java.awt.Dimension(1467, 800));
                panelCrearProducto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                pMenu.setBackground(new java.awt.Color(93, 0, 0));
                pMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                lbBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resources/images/back.png"))); // NOI18N
                lbBackButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                lbBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                lbBackButtonMouseClicked(evt);
                        }
                });
                pMenu.add(lbBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 40));

                lbCrearProducto.setBackground(new java.awt.Color(0, 0, 0));
                lbCrearProducto.setFont(new java.awt.Font("Inter", 1, 36)); // NOI18N
                lbCrearProducto.setForeground(new java.awt.Color(245, 245, 245));
                lbCrearProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lbCrearProducto.setText("REGISTRAR PRODUCTO");
                lbCrearProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                pMenu.add(lbCrearProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 60));

                panelCrearProducto.add(pMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 60));

                lbNombre.setBackground(new java.awt.Color(0, 0, 0));
                lbNombre.setFont(new java.awt.Font("Inter", 1, 24)); // NOI18N
                lbNombre.setForeground(new java.awt.Color(20, 20, 20));
                lbNombre.setText("Nombre:");
                panelCrearProducto.add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, 40));

                tfNombre.setBackground(new java.awt.Color(231, 231, 231));
                tfNombre.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
                tfNombre.setForeground(new java.awt.Color(20, 20, 20));
                tfNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                panelCrearProducto.add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 280, 40));

                lbDescripcion.setBackground(new java.awt.Color(0, 0, 0));
                lbDescripcion.setFont(new java.awt.Font("Inter", 1, 24)); // NOI18N
                lbDescripcion.setForeground(new java.awt.Color(20, 20, 20));
                lbDescripcion.setText("Descripción:");
                panelCrearProducto.add(lbDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, 40));

                taDescripcion.setBackground(new java.awt.Color(231, 231, 231));
                taDescripcion.setColumns(20);
                taDescripcion.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
                taDescripcion.setForeground(new java.awt.Color(20, 20, 20));
                taDescripcion.setLineWrap(true);
                taDescripcion.setRows(5);
                spDescripcion.setViewportView(taDescripcion);

                panelCrearProducto.add(spDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 280, -1));

                lbPrecioUnidad.setBackground(new java.awt.Color(0, 0, 0));
                lbPrecioUnidad.setFont(new java.awt.Font("Inter", 1, 24)); // NOI18N
                lbPrecioUnidad.setForeground(new java.awt.Color(20, 20, 20));
                lbPrecioUnidad.setText("Precio Unidad:");
                panelCrearProducto.add(lbPrecioUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, 40));

                tfPrecioUnidad.setBackground(new java.awt.Color(231, 231, 231));
                tfPrecioUnidad.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
                tfPrecioUnidad.setForeground(new java.awt.Color(20, 20, 20));
                tfPrecioUnidad.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                panelCrearProducto.add(tfPrecioUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 280, 40));

                lbStock.setBackground(new java.awt.Color(0, 0, 0));
                lbStock.setFont(new java.awt.Font("Inter", 1, 24)); // NOI18N
                lbStock.setForeground(new java.awt.Color(20, 20, 20));
                lbStock.setText("Stock:");
                panelCrearProducto.add(lbStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, -1, 40));

                tfStock.setBackground(new java.awt.Color(231, 231, 231));
                tfStock.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
                tfStock.setForeground(new java.awt.Color(20, 20, 20));
                tfStock.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                panelCrearProducto.add(tfStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, 50, 40));

                lbCategoria.setBackground(new java.awt.Color(0, 0, 0));
                lbCategoria.setFont(new java.awt.Font("Inter", 1, 24)); // NOI18N
                lbCategoria.setForeground(new java.awt.Color(20, 20, 20));
                lbCategoria.setText("Categoria:");
                panelCrearProducto.add(lbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, -1, 40));

                cbCategoria.setBackground(new java.awt.Color(231, 231, 231));
                cbCategoria.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
                cbCategoria.setForeground(new java.awt.Color(20, 20, 20));
                cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
                panelCrearProducto.add(cbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 520, 280, 40));

                imgCrearProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resources/images/plus.png"))); // NOI18N
                panelCrearProducto.add(imgCrearProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 670, 40, 60));

                btnCrearProducto.setBackground(new java.awt.Color(93, 0, 0));
                btnCrearProducto.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
                btnCrearProducto.setForeground(new java.awt.Color(200, 200, 200));
                btnCrearProducto.setText("      Registrar Producto");
                btnCrearProducto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                btnCrearProducto.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCrearProductoActionPerformed(evt);
                        }
                });
                panelCrearProducto.add(btnCrearProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 670, 300, 60));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelCrearProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelCrearProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btnCrearProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearProductoActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_btnCrearProductoActionPerformed

        private void lbBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBackButtonMouseClicked
                // TODO add your handling code here:
		ManageInventoryScreen mi = new ManageInventoryScreen();
		mi.setVisible(true);
		this.setVisible(false);
        }//GEN-LAST:event_lbBackButtonMouseClicked


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnCrearProducto;
        private javax.swing.JComboBox<String> cbCategoria;
        private javax.swing.JLabel imgCrearProducto;
        private javax.swing.JLabel lbBackButton;
        private javax.swing.JLabel lbCategoria;
        private javax.swing.JLabel lbCrearProducto;
        private javax.swing.JLabel lbDescripcion;
        private javax.swing.JLabel lbNombre;
        private javax.swing.JLabel lbPrecioUnidad;
        private javax.swing.JLabel lbStock;
        private javax.swing.JPanel pMenu;
        private javax.swing.JPanel panelCrearProducto;
        private javax.swing.JScrollPane spDescripcion;
        private javax.swing.JTextArea taDescripcion;
        private javax.swing.JTextField tfNombre;
        private javax.swing.JTextField tfPrecioUnidad;
        private javax.swing.JTextField tfStock;
        // End of variables declaration//GEN-END:variables
}
