
package nhs.appointment.system;


public class AdminMenu extends javax.swing.JFrame {

    
    public AdminMenu() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ViewAppointments = new javax.swing.JButton();
        ChangeUserDetails = new javax.swing.JButton();
        CreateAppointments = new javax.swing.JButton();
        AddAUser = new javax.swing.JButton();
        ModifyAppointments = new javax.swing.JButton();
        ChangePassword = new javax.swing.JButton();
        Issues = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Logout = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ViewAppointments.setText("View appointments");
        ViewAppointments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewAppointmentsActionPerformed(evt);
            }
        });

        ChangeUserDetails.setText("View user details");
        ChangeUserDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeUserDetailsActionPerformed(evt);
            }
        });

        CreateAppointments.setText("Create appointment");
        CreateAppointments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateAppointmentsActionPerformed(evt);
            }
        });

        AddAUser.setText("Add a user");
        AddAUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAUserActionPerformed(evt);
            }
        });

        ModifyAppointments.setText("Modify appointments");
        ModifyAppointments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyAppointmentsActionPerformed(evt);
            }
        });

        ChangePassword.setText("Change password");
        ChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangePasswordActionPerformed(evt);
            }
        });

        Issues.setIcon(new javax.swing.ImageIcon(getClass().getResource("/NHSLOGO.png"))); // NOI18N
        Issues.setText("Issues");
        Issues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IssuesActionPerformed(evt);
            }
        });

        jLabel1.setText("Welcome to the administrator menu!");

        jMenu1.setText("File");

        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        jMenu1.add(Logout);

        MenuBar.add(jMenu1);

        jMenu2.setText("Edit");
        MenuBar.add(jMenu2);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Issues, javax.swing.GroupLayout.PREFERRED_SIZE, 399, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ModifyAppointments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CreateAppointments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ViewAppointments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ChangeUserDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddAUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ChangePassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(77, 77, 77))
            .addGroup(layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ViewAppointments)
                    .addComponent(ChangeUserDetails))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreateAppointments)
                    .addComponent(AddAUser))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ModifyAppointments)
                    .addComponent(ChangePassword))
                .addGap(36, 36, 36)
                .addComponent(Issues)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ViewAppointmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewAppointmentsActionPerformed
        Main.ShowLargeViewer();
        this.setVisible(false);
    }//GEN-LAST:event_ViewAppointmentsActionPerformed

    private void CreateAppointmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateAppointmentsActionPerformed
        Main.ShowCreateWindow(1000, 1000);
        this.setVisible(false);
    }//GEN-LAST:event_CreateAppointmentsActionPerformed

    private void ModifyAppointmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyAppointmentsActionPerformed
        Main.ShowModify(1000, 1000);
        this.setVisible(false);
    }//GEN-LAST:event_ModifyAppointmentsActionPerformed

    private void AddAUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAUserActionPerformed
        Main.ShowRegister();
        this.setVisible(false);
    }//GEN-LAST:event_AddAUserActionPerformed

    private void ChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangePasswordActionPerformed
        Main.ShowAdminMod();
        this.setVisible(false);
    }//GEN-LAST:event_ChangePasswordActionPerformed

    private void IssuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IssuesActionPerformed
        
    }//GEN-LAST:event_IssuesActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        Main.ShowLogin();
        this.setVisible(false);
        UserLogin.AuthenticateUser = false;
        UserLogin.AuthenticatePass = false;
    }//GEN-LAST:event_LogoutActionPerformed

    private void ChangeUserDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangeUserDetailsActionPerformed
        Main.ShowUsersTable();
        this.setVisible(false);
    }//GEN-LAST:event_ChangeUserDetailsActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddAUser;
    private javax.swing.JButton ChangePassword;
    private javax.swing.JButton ChangeUserDetails;
    private javax.swing.JButton CreateAppointments;
    private javax.swing.JButton Issues;
    private javax.swing.JMenuItem Logout;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JButton ModifyAppointments;
    private javax.swing.JButton ViewAppointments;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    // End of variables declaration//GEN-END:variables
}
