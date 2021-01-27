package nhs.appointment.system;

import static nhs.appointment.system.Main.GetMouseLocation;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        if (UserLogin.flag == true) {
            LoginMesage.setText("Logged in as: " + UserLogin.Currentuser);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Header = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        CreateAppointment = new javax.swing.JButton();
        ModifyAppointment = new javax.swing.JButton();
        VeiwAppointments = new javax.swing.JButton();
        ChangePassword = new javax.swing.JButton();
        LogoButton = new javax.swing.JButton();
        LoginMesage = new javax.swing.JLabel();
        Text = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        EnlargedView = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        LogOut = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        Header.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        Header.setForeground(new java.awt.Color(0, 0, 255));
        Header.setText("NHS OFFICE WORKSPACE MENU");
        getContentPane().add(Header);
        Header.setBounds(52, 12, 396, 32);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(148, 6, 0, 0);

        CreateAppointment.setText("Create appointment");
        CreateAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateAppointmentActionPerformed(evt);
            }
        });
        getContentPane().add(CreateAppointment);
        CreateAppointment.setBounds(36, 73, 156, 46);

        ModifyAppointment.setText("Modify appointment");
        ModifyAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyAppointmentActionPerformed(evt);
            }
        });
        getContentPane().add(ModifyAppointment);
        ModifyAppointment.setBounds(36, 151, 156, 49);

        VeiwAppointments.setText("View appointments");
        VeiwAppointments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VeiwAppointmentsActionPerformed(evt);
            }
        });
        getContentPane().add(VeiwAppointments);
        VeiwAppointments.setBounds(272, 73, 176, 46);

        ChangePassword.setText("Change password");
        ChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangePasswordActionPerformed(evt);
            }
        });
        getContentPane().add(ChangePassword);
        ChangePassword.setBounds(272, 151, 176, 49);

        LogoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/NHSLOGO.png"))); // NOI18N
        LogoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(LogoButton);
        LogoButton.setBounds(80, 260, 367, 145);

        LoginMesage.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        LoginMesage.setForeground(new java.awt.Color(204, 102, 0));
        LoginMesage.setText("Logged in as:");
        getContentPane().add(LoginMesage);
        LoginMesage.setBounds(480, 50, 240, 60);

        Text.setText("Report an issue");
        getContentPane().add(Text);
        Text.setBounds(190, 230, 170, 30);

        EnlargedView.setText("File");

        jMenuItem2.setText("Enlarged view");
        EnlargedView.add(jMenuItem2);

        LogOut.setText("Logout");
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });
        EnlargedView.add(LogOut);

        jMenuBar1.add(EnlargedView);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        Main.ShowLogin();
        LoginMesage.setText("Logged in as: ");
        this.setVisible(false);
        UserLogin.AuthenticateUser = false;
        UserLogin.AuthenticatePass = false;
    }//GEN-LAST:event_LogOutActionPerformed

    private void VeiwAppointmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VeiwAppointmentsActionPerformed
        Main.ShowLargeViewer();
        this.setVisible(false);
    }//GEN-LAST:event_VeiwAppointmentsActionPerformed

    private void ModifyAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyAppointmentActionPerformed
        Main.ShowModify(1000, 1000);
        this.setVisible(false);
    }//GEN-LAST:event_ModifyAppointmentActionPerformed

    private void CreateAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateAppointmentActionPerformed
        Main.ShowCreateWindow(1000, 1000);
        this.setVisible(false);
    }//GEN-LAST:event_CreateAppointmentActionPerformed

    private void LogoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoButtonActionPerformed
        // Asks the user to input their issue into a text field, package it into a variable, add to an arraylist from an interface within the create admin class. Appears to the admin as a list of issues to be dealt with
    }//GEN-LAST:event_LogoButtonActionPerformed

    private void ChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangePasswordActionPerformed
        Main.ShowAdminMod();
        this.setVisible(false);
    }//GEN-LAST:event_ChangePasswordActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ChangePassword;
    private javax.swing.JButton CreateAppointment;
    private javax.swing.JMenu EnlargedView;
    public javax.swing.JLabel Header;
    private javax.swing.JMenuItem LogOut;
    public static javax.swing.JLabel LoginMesage;
    private javax.swing.JButton LogoButton;
    private javax.swing.JButton ModifyAppointment;
    private javax.swing.JLabel Text;
    private javax.swing.JButton VeiwAppointments;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
}
