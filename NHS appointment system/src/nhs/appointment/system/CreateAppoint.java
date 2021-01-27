package nhs.appointment.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import static nhs.appointment.system.Main.GetMouseLocation;

public class CreateAppoint extends javax.swing.JFrame {

    public static Appointment NewAppointment;
    private static Integer ID = 0;

    public CreateAppoint() {
        initComponents();
        SortLabel.setVisible(false);
        sortBy.setVisible(false);
        try {
            showResults();
            ShowPatients();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Header = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        CreateButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Output = new javax.swing.JTextArea();
        PatientFirstNameIn = new javax.swing.JTextField();
        DateIn = new javax.swing.JTextField();
        TimeSelector = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        sortBy = new javax.swing.JComboBox<>();
        SortLabel = new javax.swing.JLabel();
        PatientSecondnameIn = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        patientTable = new javax.swing.JTable();
        Search = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Veiwappointments = new javax.swing.JMenuItem();
        Logout = new javax.swing.JMenuItem();
        Menu = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        ModifyAppointment = new javax.swing.JMenuItem();
        EnlargedView = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        Header.setText("Create an appointment");
        getContentPane().add(Header);
        Header.setBounds(290, 560, 162, 28);

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Patient 1", "20/20/20", "12:00", "PatientID"},
                {"Patient 2", "20/20/20", "12:00", "PatientID"},
                {"Patient 3", "20/20/20", "12:00", "PatientID"},
                {"Patient 4", "20/20/20", "12:00", "PatientID"},
                {"Patient 5", "20/20/20", "12:00", "PatientID"}
            },
            new String [] {
                "Patient name", "Date", "Time", "PatientID"
            }
        ));
        jScrollPane1.setViewportView(Table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(283, 33, 318, 201);

        CreateButton.setText("Create");
        CreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(CreateButton);
        CreateButton.setBounds(290, 600, 147, 39);

        Output.setColumns(20);
        Output.setRows(5);
        Output.setText("Welcome! \nThis is where appointments can be created\nPlease select a patient from the table by searching for them\nEnter a date and time, and clock create to create the appointment");
        jScrollPane2.setViewportView(Output);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 30, 220, 126);
        getContentPane().add(PatientFirstNameIn);
        PatientFirstNameIn.setBounds(40, 210, 154, 22);
        getContentPane().add(DateIn);
        DateIn.setBounds(490, 300, 179, 22);

        TimeSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00" }));
        TimeSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeSelectorActionPerformed(evt);
            }
        });
        getContentPane().add(TimeSelector);
        TimeSelector.setBounds(290, 300, 146, 22);

        jLabel2.setText("Patient second name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 250, 230, 16);

        jLabel3.setText("Patient first name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 180, 170, 16);

        jLabel4.setText("Date");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(490, 260, 45, 16);

        jLabel5.setText("Time");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(290, 260, 29, 16);

        sortBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Oldest first", "patientID", "Time", "Newest first" }));
        getContentPane().add(sortBy);
        sortBy.setBounds(371, 0, 127, 22);

        SortLabel.setText("Sort by:");
        getContentPane().add(SortLabel);
        SortLabel.setBounds(317, 4, 46, 16);
        getContentPane().add(PatientSecondnameIn);
        PatientSecondnameIn.setBounds(40, 290, 150, 22);

        patientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "PatientID", "PatientFirstName","PatientSecondName", "PatientEmail"
            }
        ));
        patientTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(patientTable);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(50, 380, 630, 160);

        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });
        getContentPane().add(Search);
        Search.setBounds(80, 340, 130, 25);

        jMenu1.setText("File");

        Veiwappointments.setText("View appointments");
        Veiwappointments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VeiwappointmentsActionPerformed(evt);
            }
        });
        jMenu1.add(Veiwappointments);

        Logout.setText("Logout");
        jMenu1.add(Logout);

        Menu.setText("back to menu");
        Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuActionPerformed(evt);
            }
        });
        jMenu1.add(Menu);

        jMenuBar1.add(jMenu1);

        Edit.setText("Edit");

        ModifyAppointment.setText("Modify appointment");
        ModifyAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyAppointmentActionPerformed(evt);
            }
        });
        Edit.add(ModifyAppointment);

        jMenuBar1.add(Edit);

        EnlargedView.setText("View");

        jMenuItem2.setText("Enlarged view");
        EnlargedView.add(jMenuItem2);

        jMenuBar1.add(EnlargedView);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VeiwappointmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VeiwappointmentsActionPerformed
        Main.ShowLargeViewer();
        this.setVisible(false);
        
    }//GEN-LAST:event_VeiwappointmentsActionPerformed

    private void ModifyAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyAppointmentActionPerformed
        Main.ShowModify(1000, 1000);
        this.setVisible(false);
    }//GEN-LAST:event_ModifyAppointmentActionPerformed

    private void TimeSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeSelectorActionPerformed

    }//GEN-LAST:event_TimeSelectorActionPerformed

    private void CreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateButtonActionPerformed

        try {
            Date Date = new SimpleDateFormat("dd/MM/yy").parse(DateIn.getText());

            if (ID == 0) {
                Output.setText("No patient Selected!");
            }

            //change this to the selected one
            LocalTime time = LocalTime.parse(TimeSelector.getSelectedItem().toString());
            //add a validity check
            System.out.println("Time is :" + time);
            NewAppointment = new Appointment(ID, Date, time);
            System.out.println(ID);
            InsertAppointmentIntoDatabase(NewAppointment);

        } catch (Exception e) {
            System.out.println("Error in Create button performed: " + e);
            DateIn.setText("Invalid date!");
        }


    }//GEN-LAST:event_CreateButtonActionPerformed

    private void MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuActionPerformed
        if (Main.type.equals("admin")) {
            Main.ShowAdminMenu();
        }else{
            Main.ShowMenu();
        }
        this.setVisible(false);
    }//GEN-LAST:event_MenuActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        ShowPatients();

    }//GEN-LAST:event_SearchActionPerformed

    private void patientTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientTableMouseClicked
        WhenSelected();
    }//GEN-LAST:event_patientTableMouseClicked

    public void WhenSelected() {
        ID = (int) patientTable.getValueAt(patientTable.getSelectedRow(), 0);;
    }
//    public static ResultSet GetpatientID() {
//        int PatientID = 0;
//        ResultSet rs = null;
//        try {
//
//            String FirstName = PatientFirstNameIn.getText();
//            String SecondName = PatientSecondnameIn.getText();
//            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/NHSDatabase", "PaulTucker", "Password123");
//
//            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//
//            String SQL = "SELECT * FROM APP.TBL_Patients WHERE PATIENTFIRSTNAME = '" + FirstName + "' and patientlastname ='" + SecondName + "'";
//
//            rs = stmt.executeQuery(SQL);
//
//            while (rs.next()) {
//                PatientID = rs.getInt("PATIENTID");
//                System.out.println(PatientID);
//
//            }
//            
//            rs.close();
//            stmt.close();
//            con.close();
//            
//        } catch (Exception e) {
//            System.out.println("Error in Get aptientID: " + e);
//        }
//        return rs;
//
//    }

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

    public static void UpdatePatients(ResultSet rs) {
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
            patientTable.setModel(new javax.swing.table.DefaultTableModel(rows, Columns));

        } catch (Exception e) {
            System.out.println("Error in updatePatientstable: " + e);
        }
    }

    public static void InsertAppointmentIntoDatabase(Appointment NewAppointment) {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/NHSDatabase", "PaulTucker", "Password123");

            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String SQL = "SELECT MAX(AppointmentID) AS maxID FROM APP.TBL_Appointments";
            ResultSet rs = stmt.executeQuery(SQL);

            rs.next();
            int id = rs.getInt("maxID") + 1;

            System.out.println("Patient ID" + NewAppointment.getPatientID());
            System.out.println("Date: " + NewAppointment.getDate());
            System.out.println("Time is: " + NewAppointment.getTime());
//some .get methods return a char!!!!!
            SQL = "insert into APP.TBL_appointments Values(" + id + "," + NewAppointment.getPatientID() + ",'" + NewAppointment.getDate() + "','" + NewAppointment.getTime() + "')";
            stmt.executeUpdate(SQL);
            SQL = "SELECT * FROM APP.TBL_appointments";
            rs = stmt.executeQuery(SQL);
            //LargeViewer.UpdateTable(rs);
            UpdateTable(rs);

            //housekeeping
            rs.close();
            con.close();
            stmt.close();

        } catch (Exception e) {
            System.out.println("Error in insert : " + e);
        }

    }

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
            System.out.println("Error in showResults: " + e);
        }
    }

    public static void ShowPatients() {
        int PatientID = 0;

        try {

            String FirstName = PatientFirstNameIn.getText();
            String SecondName = PatientSecondnameIn.getText();
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/NHSDatabase", "PaulTucker", "Password123");

            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String SQL = "SELECT * FROM APP.TBL_Patients WHERE PATIENTFIRSTNAME = '" + FirstName + "' and patientlastname ='" + SecondName + "'";

            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                PatientID = rs.getInt("PATIENTID");

            }
            UpdatePatients(rs);

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error in Get aptientID: " + e);
        }

    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new CreateAppoint().setVisible(true);

            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateButton;
    private javax.swing.JTextField DateIn;
    private javax.swing.JMenu Edit;
    private javax.swing.JMenu EnlargedView;
    private javax.swing.JLabel Header;
    private javax.swing.JMenuItem Logout;
    private javax.swing.JMenuItem Menu;
    private javax.swing.JMenuItem ModifyAppointment;
    private javax.swing.JTextArea Output;
    private static javax.swing.JTextField PatientFirstNameIn;
    private static javax.swing.JTextField PatientSecondnameIn;
    private javax.swing.JButton Search;
    private javax.swing.JLabel SortLabel;
    private static javax.swing.JTable Table;
    private javax.swing.JComboBox<String> TimeSelector;
    private javax.swing.JMenuItem Veiwappointments;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private static javax.swing.JTable patientTable;
    private javax.swing.JComboBox<String> sortBy;
    // End of variables declaration//GEN-END:variables
}
