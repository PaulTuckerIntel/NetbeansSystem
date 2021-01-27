
package nhs.appointment.system;


public class ForgotPass extends javax.swing.JFrame {

    public static String INPUTTEDEMAIL = null;
    public ForgotPass() {
        initComponents();
        CodeConfirm.setVisible(false);
        ConfirmField.setVisible(false);
        ConfirmPass.setVisible(false);
        Resend.setVisible(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Label = new javax.swing.JLabel();
        Confirm = new javax.swing.JButton();
        EmailIn = new javax.swing.JTextField();
        CodeConfirm = new javax.swing.JButton();
        ConfirmPass = new javax.swing.JButton();
        Resend = new javax.swing.JButton();
        ConfirmField = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        BackToLogin = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        Label.setText("Enter the email associated with your account");
        getContentPane().add(Label);
        Label.setBounds(48, 20, 295, 36);

        Confirm.setText("Confirm");
        Confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmActionPerformed(evt);
            }
        });
        getContentPane().add(Confirm);
        Confirm.setBounds(100, 140, 160, 25);
        getContentPane().add(EmailIn);
        EmailIn.setBounds(100, 70, 173, 22);

        CodeConfirm.setText("Confirm Code");
        CodeConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodeConfirmActionPerformed(evt);
            }
        });
        getContentPane().add(CodeConfirm);
        CodeConfirm.setBounds(100, 170, 160, 25);

        ConfirmPass.setText("Confirm password");
        ConfirmPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmPassActionPerformed(evt);
            }
        });
        getContentPane().add(ConfirmPass);
        ConfirmPass.setBounds(100, 200, 160, 25);

        Resend.setText("Resend email");
        Resend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResendActionPerformed(evt);
            }
        });
        getContentPane().add(Resend);
        Resend.setBounds(100, 240, 160, 25);

        ConfirmField.setText("Confirm password");
        ConfirmField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmFieldActionPerformed(evt);
            }
        });
        getContentPane().add(ConfirmField);
        ConfirmField.setBounds(100, 110, 170, 22);

        jMenu1.setText("File");

        BackToLogin.setText("Return to Login");
        BackToLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToLoginActionPerformed(evt);
            }
        });
        jMenu1.add(BackToLogin);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmActionPerformed
        INPUTTEDEMAIL = EmailIn.getText();
        Resend.setVisible(false);
        Main.ForgotPassword(INPUTTEDEMAIL);
        
    }//GEN-LAST:event_ConfirmActionPerformed

    private void CodeConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodeConfirmActionPerformed
//        System.out.println("Security Code is:"+ Main.securityCode);
//        System.out.println(Integer.parseInt(EmailIn.getText()));
        Main.Code(Integer.parseInt(EmailIn.getText()));
        
    }//GEN-LAST:event_CodeConfirmActionPerformed

    private void ResendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResendActionPerformed
        Main.ForgotPassword(INPUTTEDEMAIL);
    }//GEN-LAST:event_ResendActionPerformed

    private void BackToLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToLoginActionPerformed
        Main.ShowLogin();
        this.setVisible(false);
    }//GEN-LAST:event_BackToLoginActionPerformed

    private void ConfirmPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmPassActionPerformed
        if (EmailIn.getText().equals(ConfirmField.getText())) {
            Main.AdaptPass();
            Email.sendEmail(INPUTTEDEMAIL, "Password successfully changed", "Your new password is :"+ConfirmField.getText());
            Main.ShowLogin();
            this.setVisible(false);
        }else{
            EmailIn.setText("passwordws must match");
        }
    }//GEN-LAST:event_ConfirmPassActionPerformed

    private void ConfirmFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfirmFieldActionPerformed

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ForgotPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem BackToLogin;
    public static javax.swing.JButton CodeConfirm;
    public static javax.swing.JButton Confirm;
    public static javax.swing.JTextField ConfirmField;
    public static javax.swing.JButton ConfirmPass;
    public static javax.swing.JTextField EmailIn;
    public static javax.swing.JLabel Label;
    private javax.swing.JButton Resend;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
