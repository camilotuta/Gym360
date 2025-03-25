/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.java.com.Gym360.view.admin;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import main.java.com.Gym360.util.ui.CambiarIU;

import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.UIManager;

/**
 *
 * @author tutaa
 */
public class DashboardAdminScreen extends javax.swing.JFrame {

    /**
     * Creates new form DashboardAdminScreen
     */
    public DashboardAdminScreen() {
        initComponents();
        this.setTitle("Dashboard Admin");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/resources/images/logo.png")));
        new CambiarIU().setImageLabel(imgGrafica1, "/main/resources/images/ventasEgresosEjemplo.png");
        new CambiarIU().setImageLabel(imgGrafica2, "/main/resources/images/distribucionMembresiasEjemplo.png");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDashboard = new javax.swing.JPanel();
        pMenu = new javax.swing.JPanel();
        lbContraseña2 = new javax.swing.JLabel();
        lbContraseña5 = new javax.swing.JLabel();
        lbContraseña6 = new javax.swing.JLabel();
        lbContraseña7 = new javax.swing.JLabel();
        lbContraseña8 = new javax.swing.JLabel();
        lbContraseña9 = new javax.swing.JLabel();
        lbContraseña10 = new javax.swing.JLabel();
        pMembresiasActivas = new javax.swing.JPanel();
        lbCorreo5 = new javax.swing.JLabel();
        lbCorreo6 = new javax.swing.JLabel();
        lbCorreo9 = new javax.swing.JLabel();
        lbCorreo10 = new javax.swing.JLabel();
        pIngresosMes = new javax.swing.JPanel();
        lbCorreo2 = new javax.swing.JLabel();
        lbCorreo1 = new javax.swing.JLabel();
        lbCorreo11 = new javax.swing.JLabel();
        pClientesActivos = new javax.swing.JPanel();
        lbCorreo3 = new javax.swing.JLabel();
        lbCorreo4 = new javax.swing.JLabel();
        lbCorreo12 = new javax.swing.JLabel();
        lbCorreo13 = new javax.swing.JLabel();
        pInventarioFaltante = new javax.swing.JPanel();
        lbCorreo = new javax.swing.JLabel();
        lbCorreo7 = new javax.swing.JLabel();
        lbCorreo8 = new javax.swing.JLabel();
        lbCorreo14 = new javax.swing.JLabel();
        pGrafica1 = new javax.swing.JPanel();
        imgGrafica1 = new javax.swing.JLabel();
        pGrafica2 = new javax.swing.JPanel();
        imgGrafica2 = new javax.swing.JLabel();
        lbAccionesRapidas = new javax.swing.JLabel();
        imgRegistrarVenta = new javax.swing.JLabel();
        imgGenerarReporte = new javax.swing.JLabel();
        imgAgregarUsuario = new javax.swing.JLabel();
        btnRegistrarVenta = new javax.swing.JButton();
        btnAgregarUsuario = new javax.swing.JButton();
        btnGenerarReporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1467, 800));

        panelDashboard.setBackground(new java.awt.Color(245, 245, 245));
        panelDashboard.setMaximumSize(new java.awt.Dimension(1467, 800));
        panelDashboard.setMinimumSize(new java.awt.Dimension(1467, 800));
        panelDashboard.setPreferredSize(new java.awt.Dimension(1467, 800));
        panelDashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pMenu.setBackground(new java.awt.Color(93, 0, 0));
        pMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbContraseña2.setBackground(new java.awt.Color(0, 0, 0));
        lbContraseña2.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        lbContraseña2.setForeground(new java.awt.Color(245, 245, 245));
        lbContraseña2.setText("Inventario");
        lbContraseña2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pMenu.add(lbContraseña2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, -1, -1));

        lbContraseña5.setBackground(new java.awt.Color(0, 0, 0));
        lbContraseña5.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        lbContraseña5.setForeground(new java.awt.Color(245, 245, 245));
        lbContraseña5.setText("Gestión de Usuarios");
        lbContraseña5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pMenu.add(lbContraseña5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        lbContraseña6.setBackground(new java.awt.Color(0, 0, 0));
        lbContraseña6.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        lbContraseña6.setForeground(new java.awt.Color(245, 245, 245));
        lbContraseña6.setText("Reportes");
        lbContraseña6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pMenu.add(lbContraseña6, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, -1, -1));

        lbContraseña7.setBackground(new java.awt.Color(0, 0, 0));
        lbContraseña7.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        lbContraseña7.setForeground(new java.awt.Color(245, 245, 245));
        lbContraseña7.setText("Nómina");
        lbContraseña7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pMenu.add(lbContraseña7, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, -1, -1));

        lbContraseña8.setBackground(new java.awt.Color(0, 0, 0));
        lbContraseña8.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        lbContraseña8.setForeground(new java.awt.Color(245, 245, 245));
        lbContraseña8.setText("Alertas");
        lbContraseña8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pMenu.add(lbContraseña8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 20, -1, -1));

        lbContraseña9.setBackground(new java.awt.Color(0, 0, 0));
        lbContraseña9.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        lbContraseña9.setForeground(new java.awt.Color(245, 245, 245));
        lbContraseña9.setText("Contraseña");
        lbContraseña9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pMenu.add(lbContraseña9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 20, -1, -1));

        lbContraseña10.setBackground(new java.awt.Color(0, 0, 0));
        lbContraseña10.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        lbContraseña10.setForeground(new java.awt.Color(245, 245, 245));
        lbContraseña10.setText("Dashboard");
        lbContraseña10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pMenu.add(lbContraseña10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        panelDashboard.add(pMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1470, 60));

        pMembresiasActivas.setBackground(new java.awt.Color(245, 245, 245));
        pMembresiasActivas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(200, 200, 200), 1, true));
        pMembresiasActivas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbCorreo5.setBackground(new java.awt.Color(0, 0, 0));
        lbCorreo5.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        lbCorreo5.setForeground(new java.awt.Color(0, 209, 130));
        lbCorreo5.setText("activos");
        pMembresiasActivas.add(lbCorreo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        lbCorreo6.setBackground(new java.awt.Color(0, 0, 0));
        lbCorreo6.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        lbCorreo6.setForeground(new java.awt.Color(20, 20, 20));
        lbCorreo6.setText("Membresías Activas");
        pMembresiasActivas.add(lbCorreo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lbCorreo9.setBackground(new java.awt.Color(0, 0, 0));
        lbCorreo9.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        lbCorreo9.setForeground(new java.awt.Color(20, 20, 20));
        lbCorreo9.setText("clientes");
        pMembresiasActivas.add(lbCorreo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        lbCorreo10.setBackground(new java.awt.Color(0, 0, 0));
        lbCorreo10.setFont(new java.awt.Font("Inter", 1, 30)); // NOI18N
        lbCorreo10.setForeground(new java.awt.Color(20, 20, 20));
        lbCorreo10.setText("325");
        pMembresiasActivas.add(lbCorreo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        panelDashboard.add(pMembresiasActivas, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 250, 110));

        pIngresosMes.setBackground(new java.awt.Color(245, 245, 245));
        pIngresosMes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(200, 200, 200), 1, true));
        pIngresosMes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbCorreo2.setBackground(new java.awt.Color(0, 0, 0));
        lbCorreo2.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        lbCorreo2.setForeground(new java.awt.Color(20, 20, 20));
        lbCorreo2.setText("Ingresos del mes");
        pIngresosMes.add(lbCorreo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lbCorreo1.setBackground(new java.awt.Color(0, 0, 0));
        lbCorreo1.setFont(new java.awt.Font("Inter", 1, 30)); // NOI18N
        lbCorreo1.setForeground(new java.awt.Color(20, 20, 20));
        lbCorreo1.setText("$8,000");
        pIngresosMes.add(lbCorreo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        lbCorreo11.setBackground(new java.awt.Color(0, 0, 0));
        lbCorreo11.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        lbCorreo11.setForeground(new java.awt.Color(20, 20, 20));
        lbCorreo11.setText("En el mes de Marzo");
        pIngresosMes.add(lbCorreo11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        panelDashboard.add(pIngresosMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 250, 110));

        pClientesActivos.setBackground(new java.awt.Color(245, 245, 245));
        pClientesActivos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(200, 200, 200), 1, true));
        pClientesActivos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbCorreo3.setBackground(new java.awt.Color(0, 0, 0));
        lbCorreo3.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        lbCorreo3.setForeground(new java.awt.Color(20, 20, 20));
        lbCorreo3.setText("hoy");
        pClientesActivos.add(lbCorreo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        lbCorreo4.setBackground(new java.awt.Color(0, 0, 0));
        lbCorreo4.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        lbCorreo4.setForeground(new java.awt.Color(20, 20, 20));
        lbCorreo4.setText("Clientes activos");
        pClientesActivos.add(lbCorreo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lbCorreo12.setBackground(new java.awt.Color(0, 0, 0));
        lbCorreo12.setFont(new java.awt.Font("Inter", 1, 30)); // NOI18N
        lbCorreo12.setForeground(new java.awt.Color(20, 20, 20));
        lbCorreo12.setText("30%");
        pClientesActivos.add(lbCorreo12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        lbCorreo13.setBackground(new java.awt.Color(0, 0, 0));
        lbCorreo13.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        lbCorreo13.setForeground(new java.awt.Color(20, 20, 20));
        lbCorreo13.setText("98 clientes");
        pClientesActivos.add(lbCorreo13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        panelDashboard.add(pClientesActivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 250, 110));

        pInventarioFaltante.setBackground(new java.awt.Color(245, 245, 245));
        pInventarioFaltante.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(200, 200, 200), 1, true));
        pInventarioFaltante.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbCorreo.setBackground(new java.awt.Color(0, 0, 0));
        lbCorreo.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        lbCorreo.setForeground(new java.awt.Color(20, 20, 20));
        lbCorreo.setText("Inventario faltante");
        pInventarioFaltante.add(lbCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lbCorreo7.setBackground(new java.awt.Color(0, 0, 0));
        lbCorreo7.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        lbCorreo7.setForeground(new java.awt.Color(20, 20, 20));
        lbCorreo7.setText("Guantes de entrenamiento: -5 unidades");
        pInventarioFaltante.add(lbCorreo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 250, -1));

        lbCorreo8.setBackground(new java.awt.Color(0, 0, 0));
        lbCorreo8.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        lbCorreo8.setForeground(new java.awt.Color(20, 20, 20));
        lbCorreo8.setText("Cinturón de levantammiento: -4 unidades");
        pInventarioFaltante.add(lbCorreo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 250, -1));

        lbCorreo14.setBackground(new java.awt.Color(0, 0, 0));
        lbCorreo14.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        lbCorreo14.setForeground(new java.awt.Color(20, 20, 20));
        lbCorreo14.setText("Magnesio en polvo: -1 unidades");
        pInventarioFaltante.add(lbCorreo14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 250, -1));

        panelDashboard.add(pInventarioFaltante, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 250, 110));

        pGrafica1.setBackground(new java.awt.Color(245, 245, 245));
        pGrafica1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        pGrafica1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pGrafica1.add(imgGrafica1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 270));

        panelDashboard.add(pGrafica1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 140, 540, 270));

        pGrafica2.setBackground(new java.awt.Color(245, 245, 245));
        pGrafica2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        pGrafica2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pGrafica2.add(imgGrafica2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 340));

        panelDashboard.add(pGrafica2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 440, 430, 340));

        lbAccionesRapidas.setBackground(new java.awt.Color(0, 0, 0));
        lbAccionesRapidas.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        lbAccionesRapidas.setForeground(new java.awt.Color(20, 20, 20));
        lbAccionesRapidas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAccionesRapidas.setText("Acciones Rápidas");
        panelDashboard.add(lbAccionesRapidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, 400, -1));

        imgRegistrarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resources/images/registrarVenta.png"))); // NOI18N
        panelDashboard.add(imgRegistrarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 490, 40, 80));

        imgGenerarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resources/images/generarReporte.png"))); // NOI18N
        panelDashboard.add(imgGenerarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 690, -1, 80));

        imgAgregarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resources/images/agregarUsuario.png"))); // NOI18N
        panelDashboard.add(imgAgregarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 590, -1, 80));

        btnRegistrarVenta.setBackground(new java.awt.Color(93, 0, 0));
        btnRegistrarVenta.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        btnRegistrarVenta.setForeground(new java.awt.Color(200, 200, 200));
        btnRegistrarVenta.setText("      Registrar Venta");
        btnRegistrarVenta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarVentaActionPerformed(evt);
            }
        });
        panelDashboard.add(btnRegistrarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 540, 80));

        btnAgregarUsuario.setBackground(new java.awt.Color(93, 0, 0));
        btnAgregarUsuario.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        btnAgregarUsuario.setForeground(new java.awt.Color(200, 200, 200));
        btnAgregarUsuario.setText("      Agregar Usuario");
        btnAgregarUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAgregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUsuarioActionPerformed(evt);
            }
        });
        panelDashboard.add(btnAgregarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 590, 540, 80));

        btnGenerarReporte.setBackground(new java.awt.Color(93, 0, 0));
        btnGenerarReporte.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        btnGenerarReporte.setForeground(new java.awt.Color(200, 200, 200));
        btnGenerarReporte.setText("      Generar Reporte");
        btnGenerarReporte.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });
        panelDashboard.add(btnGenerarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 690, 540, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarVentaActionPerformed

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerarReporteActionPerformed

    private void btnAgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarUsuarioActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (Exception e) {
            System.err.println("No se pudo aplicar FlatMacDarkLaf: " + e.getMessage());
        }
        EventQueue.invokeLater(() -> new DashboardAdminScreen().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarUsuario;
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JButton btnRegistrarVenta;
    private javax.swing.JLabel imgAgregarUsuario;
    private javax.swing.JLabel imgGenerarReporte;
    private javax.swing.JLabel imgGrafica1;
    private javax.swing.JLabel imgGrafica2;
    private javax.swing.JLabel imgRegistrarVenta;
    private javax.swing.JLabel lbAccionesRapidas;
    private javax.swing.JLabel lbContraseña10;
    private javax.swing.JLabel lbContraseña2;
    private javax.swing.JLabel lbContraseña5;
    private javax.swing.JLabel lbContraseña6;
    private javax.swing.JLabel lbContraseña7;
    private javax.swing.JLabel lbContraseña8;
    private javax.swing.JLabel lbContraseña9;
    private javax.swing.JLabel lbCorreo;
    private javax.swing.JLabel lbCorreo1;
    private javax.swing.JLabel lbCorreo10;
    private javax.swing.JLabel lbCorreo11;
    private javax.swing.JLabel lbCorreo12;
    private javax.swing.JLabel lbCorreo13;
    private javax.swing.JLabel lbCorreo14;
    private javax.swing.JLabel lbCorreo2;
    private javax.swing.JLabel lbCorreo3;
    private javax.swing.JLabel lbCorreo4;
    private javax.swing.JLabel lbCorreo5;
    private javax.swing.JLabel lbCorreo6;
    private javax.swing.JLabel lbCorreo7;
    private javax.swing.JLabel lbCorreo8;
    private javax.swing.JLabel lbCorreo9;
    private javax.swing.JPanel pClientesActivos;
    private javax.swing.JPanel pGrafica1;
    private javax.swing.JPanel pGrafica2;
    private javax.swing.JPanel pIngresosMes;
    private javax.swing.JPanel pInventarioFaltante;
    private javax.swing.JPanel pMembresiasActivas;
    private javax.swing.JPanel pMenu;
    private javax.swing.JPanel panelDashboard;
    // End of variables declaration//GEN-END:variables
}
