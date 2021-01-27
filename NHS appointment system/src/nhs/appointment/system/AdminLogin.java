package nhs.appointment.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import static nhs.appointment.system.Main.GetMouseLocation;
import static nhs.appointment.system.UserLogin.Currentuser;
import static nhs.appointment.system.UserLogin.FlagMesageText;

public class AdminLogin extends javax.swing.JFrame {
    
    public boolean AdminUser;
    public boolean AdminPass;
    
    public AdminLogin() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Label1 = new javax.swing.JLabel();
        UsernameIn = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Login = new javax.swing.JButton();
        PasswordIn = new javax.swing.JPasswordField();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        EnlargedView = new javax.swing.JMenuItem();
        Other = new javax.swing.JMenu();
        UserLogin = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Label1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        Label1.setText("Please enter your login details");

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        File.setText("File");

        EnlargedView.setText("EnlargedView");
        EnlargedView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnlargedViewActionPerformed(evt);
            }
        });
        File.add(EnlargedView);

        jMenuBar1.add(File);

        Other.setText("Other");

        UserLogin.setText("User Login");
        UserLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserLoginActionPerformed(evt);
            }
        });
        Other.add(UserLogin);

        jMenuBar1.add(Other);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(UsernameIn, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(PasswordIn)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(Login)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(UsernameIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Login)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        try {

            //compare username and password to database, then set GUI to be visible if its valid.
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/NHSDatabase", "PaulTucker", "Password123");
            //Creates a statemnent object, we specifically want the concur_updatable
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //allows us to parameterise the SQL statments
            String SQL = "SELECT * FROM APP.TBL_Administratordetails"; //+ Selector.getSelectedItem(); USe a jselector to choose a table to display
            //creates a results set for out SQL statement
            ResultSet rs = stmt.executeQuery(SQL);
            String InputtedUserName = UsernameIn.getText();
            String InputtedPassword = new String(PasswordIn.getPassword());
            String Username = new String();
            String Pass = new String();
            while (rs.next()) {
                Username = rs.getString("USERNAME");
                if (Username.equals(InputtedUserName)) {
                    AdminUser = true;
                }
                Pass = rs.getString("PASSWORD");
                if (Pass.equals(InputtedPassword)) {
                    AdminPass = true;
                }
//                if (UserLogin.AuthenticateUser && UserLogin.AuthenticatePass == true) {
//                    break;
//                }
            }
            rs.close();
            con.close();
            stmt.close();
            if (AdminUser == false) {
                UsernameIn.setText("Invalid username ");
            } 
            if (AdminPass == false) {
                UsernameIn.setText("Invalid Password ");
                PasswordIn.setText("");
            }
            if (AdminUser == true && AdminPass == true) {
                System.out.println("Login successful");
                Currentuser = InputtedUserName;
                FlagMesageText();
                try {
                    Main.ShowAdminMenu();
                    Main.type = "admin";
                    this.setVisible(false);
                } catch (Exception e) {
                    System.out.println("Error loading modules");
                }
                
            }
            
        } catch (Exception e) {
            System.out.println("Error In Login: " + e);
        }
    }//GEN-LAST:event_LoginActionPerformed

    private void EnlargedViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnlargedViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnlargedViewActionPerformed

    private void UserLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserLoginActionPerformed
        Main.ShowLogin();
        this.setVisible(false);
    }//GEN-LAST:event_UserLoginActionPerformed
    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem EnlargedView;
    private javax.swing.JMenu File;
    private javax.swing.JLabel Label1;
    private javax.swing.JButton Login;
    private javax.swing.JMenu Other;
    private javax.swing.JPasswordField PasswordIn;
    private javax.swing.JMenuItem UserLogin;
    private javax.swing.JTextField UsernameIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
