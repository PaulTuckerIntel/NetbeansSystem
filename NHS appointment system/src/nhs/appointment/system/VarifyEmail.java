
package nhs.appointment.system;


public class VarifyEmail extends javax.swing.JFrame {

    public static boolean FLAG = false;
    public VarifyEmail() {
        initComponents();
        Main.TestEmail(UserRegister.Emailin.getText(), UserRegister.UsernameIn.getText());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        In = new javax.swing.JTextField();
        Check = new javax.swing.JButton();
        resend = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        In.setText("Enter your code:");
        In.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InActionPerformed(evt);
            }
        });

        Check.setText("Check");
        Check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckActionPerformed(evt);
            }
        });

        resend.setText("Resend email");

        Back.setText("Back");

        jLabel1.setText("PLease confirm your email by enterimg the security code sent to:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(In, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(resend)
                            .addComponent(Check)
                            .addComponent(Back)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(In, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(Check)
                .addGap(18, 18, 18)
                .addComponent(resend)
                .addGap(18, 18, 18)
                .addComponent(Back)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InActionPerformed

    private void CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckActionPerformed
        
        if (Main.EmailCheck(UserRegister.Emailin.getText())&&Main.SpaceCheck(UserRegister.UsernameIn.getText())) {
            if (Main.sent = true) {
                System.out.println("Got to stage 2");
                if (Main.InputCode()) {
                    System.out.println("Here");
                    char[] inp = UserRegister.PasswordIn.getPassword();
                    String pass = new String(inp);
                    Main.NewUser(UserRegister.Emailin.getText(), UserRegister.UsernameIn.getText(), pass);
                    Email.sendEmail(UserRegister.Emailin.getText(), "Password successfully changed", "Your new account has been created, with the email : "+UserRegister.Emailin.getText());
                    Main.ShowLogin();
                    this.setVisible(false);
                }
            }
        }
    }//GEN-LAST:event_CheckActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VarifyEmail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Check;
    public static javax.swing.JTextField In;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton resend;
    // End of variables declaration//GEN-END:variables
}
