/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.java.com.Gym360.view.employee;

import java.awt.Toolkit;

/**
 *
 * @author tutaa
 */
public class ClientManagementScreen extends javax.swing.JFrame {

	/**
	 * Creates new form ClientManagementScreen
	 */
	public ClientManagementScreen() {
		initComponents();

		this.setTitle("Gestión de Clientes");
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

                panelClientManagementScreen = new javax.swing.JPanel();
                pMenu = new javax.swing.JPanel();
                lbBackButton = new javax.swing.JLabel();
                lbBuscar = new javax.swing.JLabel();
                tfBuscar = new javax.swing.JTextField();
                lbClientes = new javax.swing.JLabel();
                spTablaClientes = new javax.swing.JScrollPane();
                tTablaClientes = new javax.swing.JTable();
                imgAgregarCliente = new javax.swing.JLabel();
                btnAgregarCliente = new javax.swing.JButton();
                imgEditarCliente = new javax.swing.JLabel();
                btnEditarCliente = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                panelClientManagementScreen.setBackground(new java.awt.Color(245, 245, 245));
                panelClientManagementScreen.setMaximumSize(new java.awt.Dimension(1467, 800));
                panelClientManagementScreen.setMinimumSize(new java.awt.Dimension(1467, 800));
                panelClientManagementScreen.setPreferredSize(new java.awt.Dimension(1467, 800));
                panelClientManagementScreen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

                lbBuscar.setBackground(new java.awt.Color(0, 0, 0));
                lbBuscar.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
                lbBuscar.setForeground(new java.awt.Color(245, 245, 245));
                lbBuscar.setText("Buscar:");
                lbBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                pMenu.add(lbBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, -1, 30));

                tfBuscar.setBackground(new java.awt.Color(231, 231, 231));
                tfBuscar.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
                tfBuscar.setForeground(new java.awt.Color(20, 20, 20));
                tfBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                pMenu.add(tfBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 330, 30));

                panelClientManagementScreen.add(pMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1470, 60));

                lbClientes.setBackground(new java.awt.Color(0, 0, 0));
                lbClientes.setFont(new java.awt.Font("Inter", 1, 36)); // NOI18N
                lbClientes.setForeground(new java.awt.Color(93, 0, 0));
                lbClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lbClientes.setText("Clientes");
                lbClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                panelClientManagementScreen.add(lbClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1470, 50));

                tTablaClientes.setBackground(new java.awt.Color(232, 232, 232));
                tTablaClientes.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
                tTablaClientes.setForeground(new java.awt.Color(20, 20, 20));
                tTablaClientes.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                                {"Juan Pérez", "juan@email.com", " Administrador", "Activo"},
                                {"María López ", "maria@email.com", "Empleado", "Inactivo"},
                                {"Carlos Ruiz", "carlos@email.com", "Cliente", "Activo"},
                                {null, null, null, null}
                        },
                        new String [] {
                                "Nombre", "Correo", "Rol", "Estado"
                        }
                ));
                tTablaClientes.setShowGrid(false);
                spTablaClientes.setViewportView(tTablaClientes);

                panelClientManagementScreen.add(spTablaClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 1050, 480));

                imgAgregarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resources/images/agregarUsuario.png"))); // NOI18N
                panelClientManagementScreen.add(imgAgregarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 670, -1, 60));

                btnAgregarCliente.setBackground(new java.awt.Color(93, 0, 0));
                btnAgregarCliente.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
                btnAgregarCliente.setForeground(new java.awt.Color(200, 200, 200));
                btnAgregarCliente.setText("      Agregar Cliente");
                btnAgregarCliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnAgregarClienteActionPerformed(evt);
                        }
                });
                panelClientManagementScreen.add(btnAgregarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 670, 300, 60));

                imgEditarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/resources/images/editar.png"))); // NOI18N
                panelClientManagementScreen.add(imgEditarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 670, -1, 60));

                btnEditarCliente.setBackground(new java.awt.Color(93, 0, 0));
                btnEditarCliente.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
                btnEditarCliente.setForeground(new java.awt.Color(200, 200, 200));
                btnEditarCliente.setText("      Editar Cliente");
                btnEditarCliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnEditarClienteActionPerformed(evt);
                        }
                });
                panelClientManagementScreen.add(btnEditarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 670, 330, 60));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelClientManagementScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelClientManagementScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void lbBackButtonMouseClicked(java.awt.event.MouseEvent evt) {
		
		DashboardEmployeeScreen dashboard = new DashboardEmployeeScreen();
		dashboard.setVisible(true);
		this.setVisible(false);
        }

        private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {
		CreateClient cc = new CreateClient();
		cc.setVisible(true);
		this.setVisible(false);
        }

        private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {
		EditClient ec = new EditClient();
		ec.setVisible(true);
		this.setVisible(false);
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnAgregarCliente;
        private javax.swing.JButton btnEditarCliente;
        private javax.swing.JLabel imgAgregarCliente;
        private javax.swing.JLabel imgEditarCliente;
        private javax.swing.JLabel lbBackButton;
        private javax.swing.JLabel lbBuscar;
        private javax.swing.JLabel lbClientes;
        private javax.swing.JPanel pMenu;
        private javax.swing.JPanel panelClientManagementScreen;
        private javax.swing.JScrollPane spTablaClientes;
        private javax.swing.JTable tTablaClientes;
        private javax.swing.JTextField tfBuscar;
        // End of variables declaration//GEN-END:variables
}
