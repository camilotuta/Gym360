/*
cSpell:ignore identificacion 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.java.com.Gym360.view.admin.users;

import java.awt.Toolkit;

import javax.swing.JOptionPane;

import main.java.com.Gym360.controller.Verificar;
import main.java.com.Gym360.model.classes.Producto;
import main.java.com.Gym360.model.classes.Usuario;
import main.java.com.Gym360.model.dao.ProductoDAO;
import main.java.com.Gym360.model.dao.UsuarioDAO;
import main.java.com.Gym360.model.security.VerificarCampo;
import main.java.com.Gym360.util.ui.CambiarIU;
import main.java.com.Gym360.util.ui.ObtenerIU;
import main.java.com.Gym360.view.admin.inventory.ManageInventoryScreen;

/**
 *
 * @author tutaa
 */
// TODO: enviar un correo con la modificación y mostrarle el usuario y contraseña
public class EditUser extends javax.swing.JFrame {

        /**
         * Creates new form ManageUsersScreen
         */
        public EditUser() {
                initComponents();
                this.setTitle("Editar Usuario");
                this.setResizable(false);
                this.setLocationRelativeTo(null);
                this.setIconImage(Toolkit.getDefaultToolkit()
                                .getImage(getClass().getResource("/main/resources/images/logo.png")));

                cargarDatosUsuario(ManageUsersScreen.idUsuarioSeleccionado);

                btnEditarUsuario.setEnabled(datosValidos());
                mostrarErrores();
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                panelEditarUsuario = new javax.swing.JPanel();
                pMenu = new javax.swing.JPanel();
                lbBackButton = new javax.swing.JLabel();
                lbCrearUsuario = new javax.swing.JLabel();
                lbIdentificacion = new javax.swing.JLabel();
                tfIdentificacion = new javax.swing.JTextField();
                imgValidarIdentificacion = new javax.swing.JLabel();
                lbNombre = new javax.swing.JLabel();
                tfNombre = new javax.swing.JTextField();
                imgValidarNombre = new javax.swing.JLabel();
                lbCorreo = new javax.swing.JLabel();
                tfCorreo = new javax.swing.JTextField();
                imgValidarCorreo = new javax.swing.JLabel();
                lbCargo = new javax.swing.JLabel();
                cbCargo = new javax.swing.JComboBox<>();
                imgValidarCargo = new javax.swing.JLabel();
                lbContraseña = new javax.swing.JLabel();
                tfContraseña = new javax.swing.JTextField();
                imgValidarContraseña = new javax.swing.JLabel();
                imgEditarUsuario = new javax.swing.JLabel();
                btnEditarUsuario = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                panelEditarUsuario.setBackground(new java.awt.Color(245, 245, 245));
                panelEditarUsuario.setMaximumSize(new java.awt.Dimension(1467, 800));
                panelEditarUsuario.setMinimumSize(new java.awt.Dimension(1467, 800));
                panelEditarUsuario.setPreferredSize(new java.awt.Dimension(1467, 800));
                panelEditarUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                pMenu.setBackground(new java.awt.Color(93, 0, 0));
                pMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                lbBackButton.setIcon(
                                new javax.swing.ImageIcon(getClass().getResource("/main/resources/images/back.png"))); // NOI18N
                lbBackButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                lbBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                lbBackButtonMouseClicked(evt);
                        }
                });
                pMenu.add(lbBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 40));

                lbCrearUsuario.setBackground(new java.awt.Color(0, 0, 0));
                lbCrearUsuario.setFont(new java.awt.Font("Inter", 1, 36)); // NOI18N
                lbCrearUsuario.setForeground(new java.awt.Color(245, 245, 245));
                lbCrearUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lbCrearUsuario.setText("EDITAR USUARIO");
                lbCrearUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                pMenu.add(lbCrearUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 60));

                panelEditarUsuario.add(pMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 60));

                lbIdentificacion.setBackground(new java.awt.Color(0, 0, 0));
                lbIdentificacion.setFont(new java.awt.Font("Inter", 1, 24)); // NOI18N
                lbIdentificacion.setForeground(new java.awt.Color(20, 20, 20));
                lbIdentificacion.setText("Identificación:");
                panelEditarUsuario.add(lbIdentificacion,
                                new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, 40));

                tfIdentificacion.setBackground(new java.awt.Color(231, 231, 231));
                tfIdentificacion.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
                tfIdentificacion.setForeground(new java.awt.Color(20, 20, 20));
                tfIdentificacion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                tfIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyReleased(java.awt.event.KeyEvent evt) {
                                tfIdentificacionKeyReleased(evt);
                        }
                });
                panelEditarUsuario.add(tfIdentificacion,
                                new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 280, 40));

                imgValidarIdentificacion.setIcon(
                                new javax.swing.ImageIcon(getClass().getResource("/main/resources/images/error.png"))); // NOI18N
                panelEditarUsuario.add(imgValidarIdentificacion,
                                new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 30, 30));

                lbNombre.setBackground(new java.awt.Color(0, 0, 0));
                lbNombre.setFont(new java.awt.Font("Inter", 1, 24)); // NOI18N
                lbNombre.setForeground(new java.awt.Color(20, 20, 20));
                lbNombre.setText("Nombre:");
                panelEditarUsuario.add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, 40));

                tfNombre.setBackground(new java.awt.Color(231, 231, 231));
                tfNombre.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
                tfNombre.setForeground(new java.awt.Color(20, 20, 20));
                tfNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                tfNombre.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyReleased(java.awt.event.KeyEvent evt) {
                                tfNombreKeyReleased(evt);
                        }
                });
                panelEditarUsuario.add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 280, 40));

                imgValidarNombre.setIcon(
                                new javax.swing.ImageIcon(getClass().getResource("/main/resources/images/error.png"))); // NOI18N
                panelEditarUsuario.add(imgValidarNombre,
                                new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, 30, 30));

                lbCorreo.setBackground(new java.awt.Color(0, 0, 0));
                lbCorreo.setFont(new java.awt.Font("Inter", 1, 24)); // NOI18N
                lbCorreo.setForeground(new java.awt.Color(20, 20, 20));
                lbCorreo.setText("Correo:");
                panelEditarUsuario.add(lbCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, 40));

                tfCorreo.setBackground(new java.awt.Color(231, 231, 231));
                tfCorreo.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
                tfCorreo.setForeground(new java.awt.Color(20, 20, 20));
                tfCorreo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                tfCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyReleased(java.awt.event.KeyEvent evt) {
                                tfCorreoKeyReleased(evt);
                        }
                });
                panelEditarUsuario.add(tfCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 280, 40));

                imgValidarCorreo.setIcon(
                                new javax.swing.ImageIcon(getClass().getResource("/main/resources/images/error.png"))); // NOI18N
                panelEditarUsuario.add(imgValidarCorreo,
                                new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, 30, 30));

                lbCargo.setBackground(new java.awt.Color(0, 0, 0));
                lbCargo.setFont(new java.awt.Font("Inter", 1, 24)); // NOI18N
                lbCargo.setForeground(new java.awt.Color(20, 20, 20));
                lbCargo.setText("Cargo:");
                panelEditarUsuario.add(lbCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, -1, 40));

                cbCargo.setBackground(new java.awt.Color(231, 231, 231));
                cbCargo.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
                cbCargo.setForeground(new java.awt.Color(20, 20, 20));
                cbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(
                                new String[] { "Seleccionar", "Admin", "Empleado", "Cliente" }));
                cbCargo.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                cbCargoActionPerformed(evt);
                        }
                });
                panelEditarUsuario.add(cbCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 280, 40));

                imgValidarCargo.setIcon(
                                new javax.swing.ImageIcon(getClass().getResource("/main/resources/images/error.png"))); // NOI18N
                panelEditarUsuario.add(imgValidarCargo,
                                new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 300, 30, 30));

                lbContraseña.setBackground(new java.awt.Color(0, 0, 0));
                lbContraseña.setFont(new java.awt.Font("Inter", 1, 24)); // NOI18N
                lbContraseña.setForeground(new java.awt.Color(20, 20, 20));
                lbContraseña.setText("Contraseña:");
                panelEditarUsuario.add(lbContraseña,
                                new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, -1, 40));

                tfContraseña.setBackground(new java.awt.Color(231, 231, 231));
                tfContraseña.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
                tfContraseña.setForeground(new java.awt.Color(20, 20, 20));
                tfContraseña.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                tfContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyReleased(java.awt.event.KeyEvent evt) {
                                tfContraseñaKeyReleased(evt);
                        }
                });
                panelEditarUsuario.add(tfContraseña,
                                new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 280, 40));

                imgValidarContraseña.setIcon(
                                new javax.swing.ImageIcon(getClass().getResource("/main/resources/images/error.png"))); // NOI18N
                panelEditarUsuario.add(imgValidarContraseña,
                                new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 370, 30, 30));

                imgEditarUsuario.setIcon(
                                new javax.swing.ImageIcon(getClass().getResource("/main/resources/images/editar.png"))); // NOI18N
                panelEditarUsuario.add(imgEditarUsuario,
                                new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 500, 40, 60));

                btnEditarUsuario.setBackground(new java.awt.Color(93, 0, 0));
                btnEditarUsuario.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
                btnEditarUsuario.setForeground(new java.awt.Color(200, 200, 200));
                btnEditarUsuario.setText("      Editar Usuario");
                btnEditarUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                btnEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnEditarUsuarioActionPerformed(evt);
                        }
                });
                panelEditarUsuario.add(btnEditarUsuario,
                                new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 500, 300, 60));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(panelEditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 675,
                                                javax.swing.GroupLayout.PREFERRED_SIZE));
                layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(panelEditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 589,
                                                javax.swing.GroupLayout.PREFERRED_SIZE));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void tfIdentificacionKeyReleased(java.awt.event.KeyEvent evt) {
                btnEditarUsuario.setEnabled(datosValidos());
                mostrarErrores();
        }

        private void tfNombreKeyReleased(java.awt.event.KeyEvent evt) {
                btnEditarUsuario.setEnabled(datosValidos());
                mostrarErrores();
        }

        private void tfCorreoKeyReleased(java.awt.event.KeyEvent evt) {
                btnEditarUsuario.setEnabled(datosValidos());
                mostrarErrores();
        }

        private void tfContraseñaKeyReleased(java.awt.event.KeyEvent evt) {
                btnEditarUsuario.setEnabled(datosValidos());
                mostrarErrores();
        }

        private void cbCargoActionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarUsuario.setEnabled(datosValidos());
                mostrarErrores();
        }

        private void btnEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {
                actualizarUsuario();
        }

        private void lbBackButtonMouseClicked(java.awt.event.MouseEvent evt) {

                ManageUsersScreen mu = new ManageUsersScreen();
                mu.setVisible(true);
                this.setVisible(false);
        }

        private void actualizarUsuario() {
                UsuarioDAO usuarioDAO = new UsuarioDAO();

                // Obtener datos desde los campos del formulario
                String nombreUsuario = ObtenerIU.obtenerTextoCampo(tfNombre);
                String correo = ObtenerIU.obtenerTextoCampo(tfCorreo);
                String cargo = ObtenerIU.obtenerSeleccionCombo(cbCargo);
                String contraseña = ObtenerIU.obtenerTextoCampo(tfContraseña);
                int idEmpleado = Integer.parseInt(ObtenerIU.obtenerTextoCampo(tfIdentificacion));

                try {
                        // Actualizar el usuario en la base de datos
                        usuarioDAO.actualizar(new Usuario(idEmpleado, nombreUsuario, contraseña, cargo, correo));
                        JOptionPane.showMessageDialog(this, "El usuario se actualizó correctamente.",
                                        "Actualización exitosa", JOptionPane.INFORMATION_MESSAGE);

                        // Redirigir o refrescar vista
                        ManageUsersScreen mu = new ManageUsersScreen();
                        mu.setVisible(true);
                        this.setVisible(false);

                } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Ocurrió un error al actualizar el usuario.", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                }
        }

        public void cargarDatosUsuario(int idEmpleado) {
                // Crear una instancia del DAO para obtener el usuario por su ID (idEmpleado)
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario usuario = usuarioDAO.obtenerPorIdEmpleado(idEmpleado);

                // Si el usuario existe, cargar los datos en los campos
                if (usuario != null) {
                        CambiarIU.ponerTextoCampo(tfNombre, usuario.getNombreUsuario());
                        CambiarIU.ponerTextoCampo(tfCorreo, usuario.getCorreo());
                        CambiarIU.ponerSeleccionCombo(cbCargo, usuario.getCargo());
                        CambiarIU.ponerTextoCampo(tfContraseña, usuario.getContraseña());
                        CambiarIU.ponerTextoCampo(tfIdentificacion, String.valueOf(usuario.getIdEmpleado()));
                } else {
                        System.out.println("Usuario no encontrado.");
                }
        }

        private boolean datosValidos() {
                return Verificar.validarNombre(ObtenerIU.obtenerTextoCampo(tfNombre))
                                && Verificar.validarYVerificarCedulaSeleccionada(
                                                (ObtenerIU.obtenerTextoCampo(tfIdentificacion)),
                                                ManageUsersScreen.idUsuarioSeleccionado)
                                && Verificar.validarCorreo(ObtenerIU.obtenerTextoCampo(tfCorreo))
                                && Verificar.validarComboBox((ObtenerIU.obtenerSeleccionCombo(cbCargo)))
                                && Verificar.validarContraseña(
                                                (ObtenerIU.obtenerTextoCampo(tfContraseña)).toCharArray());

        }

        private void mostrarErrores() {

                // tfNombre
                VerificarCampo.verificarCampo(Verificar.validarNombre(ObtenerIU.obtenerTextoCampo(tfNombre)),
                                imgValidarNombre, "El nombre es válido.", "El nombre no es válido.");

                // tfIdentificacion
                VerificarCampo.verificarCampo(
                                Verificar.validarYVerificarCedulaSeleccionada(
                                                ObtenerIU.obtenerTextoCampo(tfIdentificacion),
                                                ManageUsersScreen.idUsuarioSeleccionado),
                                imgValidarIdentificacion, "La identificación no es válida.",
                                "La identificación es válida.");
                // tfCorreo
                VerificarCampo.verificarCampo(Verificar.validarCorreo((ObtenerIU.obtenerTextoCampo(tfCorreo))),
                                imgValidarCorreo, "El correo es válido.", "El correo no es válido.");
                // tfContraseña
                VerificarCampo.verificarCampo(
                                Verificar.validarContraseña((ObtenerIU.obtenerTextoCampo(tfContraseña)).toCharArray()),
                                imgValidarContraseña, "La contraseña es válida.", "La contraseña no es válida.");
                // cbCargo
                VerificarCampo.verificarCampo(Verificar.validarComboBox(ObtenerIU.obtenerSeleccionCombo(cbCargo)),
                                imgValidarCargo, "Ha seleccionado un cargo.", "Debe seleccionar un cargo.");

        }

        /**
         * @param args the command line arguments
         */

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnEditarUsuario;
        private javax.swing.JComboBox<String> cbCargo;
        private javax.swing.JLabel imgEditarUsuario;
        private javax.swing.JLabel imgValidarCargo;
        private javax.swing.JLabel imgValidarContraseña;
        private javax.swing.JLabel imgValidarCorreo;
        private javax.swing.JLabel imgValidarIdentificacion;
        private javax.swing.JLabel imgValidarNombre;
        private javax.swing.JLabel lbBackButton;
        private javax.swing.JLabel lbCargo;
        private javax.swing.JLabel lbContraseña;
        private javax.swing.JLabel lbCorreo;
        private javax.swing.JLabel lbCrearUsuario;
        private javax.swing.JLabel lbIdentificacion;
        private javax.swing.JLabel lbNombre;
        private javax.swing.JPanel pMenu;
        private javax.swing.JPanel panelEditarUsuario;
        private javax.swing.JTextField tfContraseña;
        private javax.swing.JTextField tfCorreo;
        private javax.swing.JTextField tfIdentificacion;
        private javax.swing.JTextField tfNombre;
        // End of variables declaration//GEN-END:variables
}
