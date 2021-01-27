package nhs.appointment.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import static nhs.appointment.system.Main.GetMouseLocation;

public class UserLogin extends javax.swing.JFrame {

    public static boolean AuthenticateUser = false;
    public static boolean AuthenticatePass = false;
    public static String Currentuser = "Noone";
    public static boolean flag;

    public UserLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Label1 = new javax.swing.JLabel();
        UsernameIn = new javax.swing.JTextField();
        USERLABEL = new javax.swing.JLabel();
        PassLabel = new javax.swing.JLabel();
        Login = new javax.swing.JButton();
        ForgotPassword = new javax.swing.JButton();
        PassIn = new javax.swing.JPasswordField();
        Register = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        EnlargedView = new javax.swing.JMenuItem();
        Other = new javax.swing.JMenu();
        ADMIN = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(500,400);

        Label1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        Label1.setText("Please enter your login details");

        USERLABEL.setText("Username");

        PassLabel.setText("Password");

        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        ForgotPassword.setText("Forgot password");
        ForgotPassword.setMaximumSize(new java.awt.Dimension(400, 90));
        ForgotPassword.setPreferredSize(new java.awt.Dimension(149, 29));
        ForgotPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ForgotPasswordActionPerformed(evt);
            }
        });

        Register.setText("New user?");
        Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterActionPerformed(evt);
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

        ADMIN.setText("AdministratorLogin");
        ADMIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADMINActionPerformed(evt);
            }
        });
        Other.add(ADMIN);

        jMenuBar1.add(Other);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(Login)
                        .addGap(53, 53, 53)
                        .addComponent(ForgotPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(PassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(USERLABEL))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(UsernameIn, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(PassIn)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(Register, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(244, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(USERLABEL)
                .addGap(18, 18, 18)
                .addComponent(UsernameIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PassLabel)
                .addGap(18, 18, 18)
                .addComponent(PassIn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Login)
                    .addComponent(ForgotPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Register)
                .addContainerGap(16, Short.MAX_VALUE))
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
            String SQL = "SELECT * FROM APP.TBL_USERDATA"; //+ Selector.getSelectedItem(); USe a jselector to choose a table to display
            //creates a results set for out SQL statement
            ResultSet rs = stmt.executeQuery(SQL);
            String InputtedUserName = UsernameIn.getText();
            String InputtedPassword = new String(PassIn.getPassword());
            System.out.println("The inputted passwor is: "+InputtedPassword);
            String Username = new String();
            String Pass = new String();
            while (rs.next()) {
                Username = rs.getString("USERNAME");
                if (Username.equals(InputtedUserName)) {
                    AuthenticateUser = true;
                }
                Pass = rs.getString("PASSWORD");
                if (Pass.equals(InputtedPassword)) {
                    AuthenticatePass = true;
                }
//                if (UserLogin.AuthenticateUser && UserLogin.AuthenticatePass == true) {
//                    break;
//                }
            }
            rs.close();
            con.close();
            stmt.close();
            if (AuthenticateUser == false) {
                UsernameIn.setText("Invalid username ");
            } 
            if (AuthenticatePass == false) {
                UsernameIn.setText("Invalid Password ");
                PassIn.setText("");
            }
            if (UserLogin.AuthenticateUser == true && UserLogin.AuthenticatePass == true) {
                Main.type = "user";
                System.out.println("Login successful");
                Currentuser = InputtedUserName;
                FlagMesageText();
                try {
                    Main.ShowMenu();
                    Main.type = "user";
                    this.setVisible(false);
                } catch (Exception e) {
                    System.out.println("Error loading modules");
                }

            }

        } catch (Exception e) {
            System.out.println("Error In Login: " + e);
        }

    }//GEN-LAST:event_LoginActionPerformed
    public static void FlagMesageText() {
        flag = true;
    }

    private void EnlargedViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnlargedViewActionPerformed
        //use enlarge method

    }//GEN-LAST:event_EnlargedViewActionPerformed

    private void RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterActionPerformed
        Main.ShowRegister();
        Main.type = "user";
        this.setVisible(false);
        AuthenticateUser = false;
        AuthenticatePass = false;
    }//GEN-LAST:event_RegisterActionPerformed

    private void ADMINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADMINActionPerformed
        Main.ShowAdmin();
        this.setVisible(false);
    }//GEN-LAST:event_ADMINActionPerformed

    private void ForgotPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ForgotPasswordActionPerformed
        Main.ShowForgot();
        this.setVisible(false);
    }//GEN-LAST:event_ForgotPasswordActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ADMIN;
    private javax.swing.JMenuItem EnlargedView;
    private javax.swing.JMenu File;
    public static javax.swing.JButton ForgotPassword;
    public static javax.swing.JLabel Label1;
    public static javax.swing.JButton Login;
    private javax.swing.JMenu Other;
    public static javax.swing.JPasswordField PassIn;
    public static javax.swing.JLabel PassLabel;
    public static javax.swing.JButton Register;
    public static javax.swing.JLabel USERLABEL;
    public static javax.swing.JTextField UsernameIn;
    public static javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
