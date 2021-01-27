package nhs.appointment.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import static nhs.appointment.system.CreateAppoint.UpdateTable;
import static nhs.appointment.system.Main.GetMouseLocation;
import sun.awt.SunDisplayChanger;

public class ModifyApp extends javax.swing.JFrame {
    private Integer SelectedID = null;
    public ModifyApp() {
        initComponents();
        showResults();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        DateIn = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Output = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        Displayer = new javax.swing.JLabel();
        TimeIn = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Confirm = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Menu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        AlternateMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Name,ID", "20/20/20", "12:00"},
                {"2", "Name,ID", "20/20/20", "12:00"},
                {"3", "Name,ID", "20/20/20", "12:00"},
                {"4", "Name,ID", "20/20/20", "12:00"},
                {"5", null, "20/20/20", "12:00"}
            },
            new String [] {
                "AppointmentID", "PatientID", "Date", "Time"
            }
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 20, 360, 160);

        DateIn.setText("20/20/20");
        getContentPane().add(DateIn);
        DateIn.setBounds(20, 210, 110, 30);

        Output.setColumns(20);
        Output.setRows(5);
        Output.setText("Select an appointment,and the \ncurrent details will be displayed, \nready for changing.");
        jScrollPane2.setViewportView(Output);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(390, 20, 250, 117);

        jLabel1.setText("Date");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 190, 110, 20);

        Displayer.setText("Selected appointment ID: 1");
        getContentPane().add(Displayer);
        Displayer.setBounds(405, 130, 200, 30);

        TimeIn.setText("12:00");
        getContentPane().add(TimeIn);
        TimeIn.setBounds(180, 210, 130, 22);

        jLabel3.setText("Time ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(190, 190, 45, 16);

        Confirm.setText("Confirm changes");
        Confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmActionPerformed(evt);
            }
        });
        getContentPane().add(Confirm);
        Confirm.setBounds(147, 259, 140, 40);

        jMenu1.setText("File");

        Menu.setText("Back to Menu");
        Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuActionPerformed(evt);
            }
        });
        jMenu1.add(Menu);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("View");

        AlternateMenu.setText("Alternate view");
        AlternateMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlternateMenuActionPerformed(evt);
            }
        });
        jMenu3.add(AlternateMenu);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AlternateMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlternateMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AlternateMenuActionPerformed

    private void MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuActionPerformed
        if (Main.type.equals("admin")) {
            Main.ShowAdminMenu();
        }else{
            Main.ShowMenu();
        }
        this.setVisible(false);
    }//GEN-LAST:event_MenuActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        WhenSelected();
    }//GEN-LAST:event_TableMouseClicked

    private void ConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmActionPerformed
        if (SelectedID == null) {
            Output.setText("No appointment selected!");
        }else{
            Main.Modify(DateIn.getText(), TimeIn.getText(), SelectedID);
            showResults();
        }
        
    }//GEN-LAST:event_ConfirmActionPerformed

    public static void showResults() {
        try {
            //creates a connection object 
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/NHSDatabase", "PaulTucker", "Password123");
            //Creates a statemnent object, we specifically want the concur_updatable
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //allows us to parameterise the SQL statments
            String SQL = "SELECT * FROM APP.TBL_Appointments"; //+ Selector.getSelectedItem(); USe a jselector to choose a table to display
            //creates a results set for out SQL statement
            ResultSet rs = stmt.executeQuery(SQL);
            //calls the UpdateTableMethod()
            UpdateTable(rs);
            //closes all open sets and readers
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void WhenSelected() {
        SelectedID = (int) Table.getValueAt(Table.getSelectedRow(), 0);
        String SelecetedDate = Table.getValueAt(Table.getSelectedRow(), 2).toString();
        String SelecetedTime = Table.getValueAt(Table.getSelectedRow(), 3).toString();
        Displayer.setText("Selected appointment ID: " + SelectedID);
        DateIn.setText(SelecetedDate);
        TimeIn.setText(SelecetedTime);
    }

    public static void UpdateTable(ResultSet rs) {
        try {
            //makes string array with lengths of how many columns are in the results set
            String[] Columns = new String[rs.getMetaData().getColumnCount()];

            for (int i = 0; i < Columns.length; i++) {
                Columns[i] = rs.getMetaData().getColumnLabel(i + 1);
                //for the length of the columns, creates the dimenions of the database tables and uses the label to fill the table with null data
            }

            rs.last();// moves cursor to last row
            int totalRows = rs.getRow(); // gets last number of row
            //moves to the first item in the result set
            rs.first();
            //creates a 2d array, with the data from the rows and columns already extracted from the database. This oject array can hold any type of data, so is sueful to display any data.
            Object[][] rows = new Object[totalRows][Columns.length];

            //gets infor from resulst set and stores into 2d object array
            for (int i = 0; i < totalRows; i++) {//loops through all the rows in the database
                for (int j = 0; j < Columns.length; j++) {//loops through all the columns in the database
                    rows[i][j] = rs.getObject(Columns[j]);
                }
                rs.next();//gives the next record
            }
            //creates the new model and fills with data
            Table.setModel(new javax.swing.table.DefaultTableModel(rows, Columns));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifyApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AlternateMenu;
    private javax.swing.JButton Confirm;
    private javax.swing.JTextField DateIn;
    private javax.swing.JLabel Displayer;
    private javax.swing.JMenuItem Menu;
    private javax.swing.JTextArea Output;
    private static javax.swing.JTable Table;
    private javax.swing.JTextField TimeIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
