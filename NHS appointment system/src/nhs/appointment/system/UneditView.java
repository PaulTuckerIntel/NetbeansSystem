package nhs.appointment.system;

public class UneditView extends javax.swing.JFrame {

    public UneditView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        PatientDetailsOUT = new javax.swing.JTextArea();
        PatientIDOUT = new javax.swing.JLabel();
        PatientFirstNameOUT = new javax.swing.JLabel();
        PatientSecondNameOUT = new javax.swing.JLabel();
        AppointmentIDOUT = new javax.swing.JLabel();
        PatientEmailOUT = new javax.swing.JLabel();
        AppointmentDateOUT = new javax.swing.JLabel();
        AppointmentTimeOUT = new javax.swing.JLabel();
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        PatientDetailsOUT.setColumns(20);
        PatientDetailsOUT.setRows(5);
        PatientDetailsOUT.setText("Patient details");
        jScrollPane1.setViewportView(PatientDetailsOUT);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(470, 20, 360, 180);

        PatientIDOUT.setBackground(new java.awt.Color(0, 204, 204));
        PatientIDOUT.setText("Patient iD:");
        PatientIDOUT.setBorder(new javax.swing.border.MatteBorder(null));
        getContentPane().add(PatientIDOUT);
        PatientIDOUT.setBounds(20, 20, 200, 44);

        PatientFirstNameOUT.setText("Patient first name:");
        PatientFirstNameOUT.setBorder(new javax.swing.border.MatteBorder(null));
        getContentPane().add(PatientFirstNameOUT);
        PatientFirstNameOUT.setBounds(20, 100, 200, 40);

        PatientSecondNameOUT.setText("Patient second name:");
        PatientSecondNameOUT.setBorder(new javax.swing.border.MatteBorder(null));
        getContentPane().add(PatientSecondNameOUT);
        PatientSecondNameOUT.setBounds(240, 100, 210, 40);

        AppointmentIDOUT.setText("Appointment ID:");
        AppointmentIDOUT.setBorder(new javax.swing.border.MatteBorder(null));
        getContentPane().add(AppointmentIDOUT);
        AppointmentIDOUT.setBounds(240, 20, 210, 44);

        PatientEmailOUT.setText("Patient Email:");
        PatientEmailOUT.setBorder(new javax.swing.border.MatteBorder(null));
        getContentPane().add(PatientEmailOUT);
        PatientEmailOUT.setBounds(21, 161, 200, 40);

        AppointmentDateOUT.setBackground(new java.awt.Color(0, 204, 204));
        AppointmentDateOUT.setText("Appointment date:");
        AppointmentDateOUT.setBorder(new javax.swing.border.MatteBorder(null));
        getContentPane().add(AppointmentDateOUT);
        AppointmentDateOUT.setBounds(240, 160, 210, 40);

        AppointmentTimeOUT.setText("Appointment Time:");
        AppointmentTimeOUT.setBorder(new javax.swing.border.MatteBorder(null));
        getContentPane().add(AppointmentTimeOUT);
        AppointmentTimeOUT.setBounds(20, 220, 200, 40);

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back);
        Back.setBounds(260, 220, 290, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        this.setVisible(false);
        Main.ShowLargeViewer();
    }//GEN-LAST:event_BackActionPerformed

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
            java.util.logging.Logger.getLogger(UneditView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UneditView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UneditView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UneditView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UneditView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel AppointmentDateOUT;
    public static javax.swing.JLabel AppointmentIDOUT;
    public static javax.swing.JLabel AppointmentTimeOUT;
    private javax.swing.JButton Back;
    public javax.swing.JTextArea PatientDetailsOUT;
    public static javax.swing.JLabel PatientEmailOUT;
    public static javax.swing.JLabel PatientFirstNameOUT;
    public static javax.swing.JLabel PatientIDOUT;
    public static javax.swing.JLabel PatientSecondNameOUT;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
