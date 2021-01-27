package nhs.appointment.system;
//List of imported libraries
import java.awt.MouseInfo;
import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    //Global Variables declaration, do not modify
    //Used within RandomNumberGen method and GetMouseLocation Method
    protected static Integer XLocation;
    protected static Integer YLocation;
    protected static Integer CodeLength;

    // Used within "GetLocalTime" method
    protected static Integer currentHour;
    protected static Integer currentMin;
    protected static Integer currentSec;

    //Global object declaration
    protected static UserLogin UserLog;

    //globaly acessible temporary variables
    public static String TempString;
    public static Date TempDate;
    public static Integer securityCode = null;
    public static boolean sent;
    public static String type = null;

    //Globally acessible ArrayList for sorting
    public static ArrayList<Integer> array = new ArrayList<>();

    public static void main(String[] args) {
        //Starts the program, ensures there are no formatting errors
       boolean Init = InitComponents();
       //prints to console the result of program boot
       System.out.println("System booted with no errors: " + Init);
       
       //AlgorithmTimer();

    }
    //method used for testing the Check email method -- redundant now
    public static void temp(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an email");
        String inp = input.next();
        System.out.println(EmailCheck(inp));
        temp();
    }

    //initialises the forms used within the program
    public static Boolean InitComponents() {
        //try catch needed to return a true or false value for the init of components
        try {
            //Creates a new login form and makes it visible
            ShowLogin();
            //If the above line creates the form, returns the result as true
            return true;

        } catch (Exception e) {
            //printing error message to help with error handling and squash bugs
            System.out.println("Error loading modules, please contact a developer!");
            System.out.println("Error :"+e);
            // if the statement was to fail, enters the catch block and returns a false value
            return false;
        }
    }

    //Gets the current house, minutes and seconds
    public static void GetLocalTime() {
        //Gets the current local time and stores value within a string
        String Time = java.time.LocalTime.now().toString();

        //parses the substrings of the local time to exclude any formatting characters such as ":"
        currentHour = Integer.parseInt(Time.substring(0, 2));
        currentMin = Integer.parseInt(Time.substring(3, 5));
        currentSec = currentMin = Integer.parseInt(Time.substring(6, 8));
    }

    //Gets three random inputs and generates a random number
    public static Integer RandomNumberGen() {
        //runs the method, putting values into predefined global variables.
        GetMouseLocation();
        //Runs the GetLocalTime method, to allow for more random generation
        GetLocalTime();
        //initialises the final result variable.
        int Result = 0;

        //Generation goes through a series of if statments to completley randomise the generation of the number
        if (XLocation >= 100 && YLocation >= 100) {
            Result = ((XLocation * YLocation) / 4 + currentMin) + currentHour;
        }
        if (XLocation >= 500 && YLocation >= 500) {
            Result = ((YLocation * XLocation) / (1 + currentMin)) + currentHour;
        }
        if (XLocation >= 1000 && YLocation >= 1000) {
            Result = ((XLocation * YLocation) / (15 + currentHour)) + currentMin;
        } else {
            //Failsafe to generate random number, prevents user from exploiting mouse position to generate 0 as the security code
            Result = ((currentSec + 45) * currentHour);
        }
        //The result is doubled top give an appropriate length of security code
        Result = (Result * 2);
        //The code is converted to a string with the same value, and the length is stroed in a global variable
        CodeLength = String.valueOf(Result).length();
        //Stores result in the method
        return Result;
    }

    //Grabs position of the mouse on the screen and places the X and Y values into two integer variables
    public static void GetMouseLocation() {
        //Locates the current location of the mose, with .awt language surrounding the statment
        Point pos = MouseInfo.getPointerInfo().getLocation();

        //Grabs the integer values of the cursor location, stores them in global variables.
        XLocation = pos.x;
        YLocation = pos.y;
    }

    //unfinished, lloking to try and resisze all components and the panel itself
    public void Enlarge() {
        UserLog.setSize(1000, 900);
        UserLog.pack();
//        int x = c.height +100;
//        UserLogin.Label1.setSize(400, 60);
//        UserLogin.ForgotPassword.setSize(250,60);
//        UserLogin.Login.setSize(250, 60);
//        UserLogin.PasswordIn.setSize(250, 60);
//        UserLogin.UsernameIn.setSize(250,250);
//        UserLogin.jLabel1.setSize(250,250);
//        UserLogin.jLabel2.setSize(x,250);
    }

    //a basic method to call all other methods. To use this method, the object to be checked must be put into the variable tempstring
    public void ValidityCheck() {
        if (DateCheck(TempString) == true) {
            //if the input is a date, this if will run. USe reg expression to make sure its a valid date, and not 31/34/00 etc
        }
    }

    public static boolean TimeCheck() {
        return true;

    }

    //method to determine whther the string entered is a date or not
    private static boolean DateCheck(String input) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        try {
            Date d = dateFormat.parse(input);
            return true;
        } catch (ParseException e) {
            return false;

        }

    }

    //Method to determine if the string entered is a string Replace with regualr expression
    public static boolean EmailCheck(String input) {
        boolean a = true;
        //try catch means that any errors that arise here will result in the email being rejected, instead of the program crashing
        try{
            //Regular expression from https://emailregex.com/
            Pattern Regex = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
            //creates a matcher object, allows me to use the methods within that object
            Matcher matcher = Regex.matcher(input);
            //if-then statment used to ddetermine result of a regex matcher
            if (matcher.matches()) {
                //return true
                a = true;
            }else{
                //retuns false, email didnt match
                a = false;
            }
        //basic error handling    
        }catch(Exception e){
            System.out.println("Error in method \"Email check\": "+e);
            //returns false if an error occurs to maintian system security
            a = false;
        }
        //returns the boolean value of A
        return a;
    }
    
    //method to determine the occurance of a space character within an input
    public static boolean SpaceCheck(String input) {
        //constant local varaiable used by the method 
        boolean a = false;
        //try catch ensure proper error handling
        try {
            //replace with pattern matcher
            if (input.contains(" ")) {
                a = true;
            }
        } catch (Exception e) {
            System.out.println("Error in SpaceCheck: "+ e);
            a = false;
        }
        return a;

    }

//delete this methjod, was for leaning purposes. Method creates a database connection, creates a statement, and takes the results from the result set and puts them into local variables.
    public static void DatabaseTrial() {
        //placing my code in a try catch ensures that the procedure will not crash the system
        try {
            //Creates a connection object, which uses the drivermanager class to establish a connection with my local database. It takes the location of the database, the username and password.
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/NHSDatabase", "PaulTucker", "Password123");
            //This creates a statement object, and sets the croll typ and editing permissions
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //I have delcared a string that i want to use to create a new stament. Makes me a new SQL statment to fire at the database
            String sql = "Select * From app.tbl_Users";
            //Creates a new results set from the SQL query, which holds the result of my statement
            ResultSet rs = statement.executeQuery(sql);
            
            
            //While loop running off of the dependancy of the result set
            while (rs.next()) {
                //fills the variables with the currently held data within the results set
                int AppointmentID = rs.getInt("AppointmentID");
                int PatientID = rs.getInt("PatientID");
                Date date = rs.getDate("date");
                Time time = rs.getTime("time");
                //prints out the results?
                System.out.println(AppointmentID + " " + PatientID + " " + date + " " + time);
            }

            //close all inputstreams, prevents problems when accessing larger data values.
            rs.close();
            con.close();
            statement.close();

        } catch (Exception e) {
            //Error handling
            System.out.println("Error in DatabaseTrial: "+e);
        }

    }
    
    //method to delete the 
    public static void DeleteAppointment(javax.swing.JTable table) {
        int SelectedID = (int) table.getValueAt(table.getSelectedRow(), 0);

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/NHSDatabase", "PaulTucker", "Password123");

            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String SQL = "DELETE FROM APP.TBL_Appointments WHERE AppointmentID = " + SelectedID;

            stmt.executeUpdate(SQL);

            //inserts new record
            SQL = "SELECT * FROM APP.TBL_Appointments";
            ResultSet rs = stmt.executeQuery(SQL);

            LargeViewer.UpdateTable(rs);

            //housekeeping
            rs.close();
            con.close();
            stmt.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void DeleteUser(javax.swing.JTable table) {
        int SelectedID = (int) table.getValueAt(table.getSelectedRow(), 0);

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/NHSDatabase", "PaulTucker", "Password123");

            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String SQL = "DELETE FROM APP.TBL_userdata WHERE userID = " + SelectedID;

            stmt.executeUpdate(SQL);

            //inserts new record
            SQL = "SELECT * FROM APP.TBL_userdata";
            ResultSet rs = stmt.executeQuery(SQL);

            UserViewer.UpdateTable(rs);

            //housekeeping
            rs.close();
            con.close();
            stmt.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void ShowLargeViewer() {
        LargeViewer TableImage = new LargeViewer();
        TableImage.setVisible(true);
        TableImage.setSize(1000, 1000);
        TableImage.setResizable(true);
        //Gets the mouse location and sets the panel at these coordanites
        GetMouseLocation();
        TableImage.setLocation(Main.XLocation, Main.YLocation);
    }

    public static void ShowModify(int x, int y) {
        ModifyApp ModifyAppointmentWindow = new ModifyApp();
        ModifyAppointmentWindow.setVisible(true);
        ModifyAppointmentWindow.setSize(x, y);
        ModifyAppointmentWindow.setResizable(true);
        //Gets the mouse location and sets the panel at these coordanites
        GetMouseLocation();
        ModifyAppointmentWindow.setLocation(Main.XLocation, Main.YLocation);
    }

    public static void ShowCreateWindow(int x, int y) {
        CreateAppoint CreateAppointmentWindow = new CreateAppoint();
        CreateAppointmentWindow.setVisible(true);
        CreateAppointmentWindow.setSize(x, y);
        CreateAppointmentWindow.setResizable(true);
        CreateAppointmentWindow.setLocationRelativeTo(null);
        //Gets the mouse location and sets the panel at these coordanites
        GetMouseLocation();
        CreateAppointmentWindow.setLocation(Main.XLocation, Main.YLocation);
    }

    public static void ShowUneditView(Integer id) {
        UneditView UEView = new UneditView();
        UEView.setVisible(true);
        UEView.setSize(1000, 750);
        UEView.setResizable(true);
        //Gets the mouse location and sets the panel at these coordanites
        GetMouseLocation();
        UEView.setLocation(Main.XLocation, Main.YLocation);
        GetValues(id);
    }

    public static void ShowLogin() {
        UserLog = new UserLogin();
        UserLog.setVisible(true);
        UserLog.setSize(500, 500);
        UserLog.setResizable(true);
        //Gets the mouse location and sets the panel at these coordanites
        GetMouseLocation();
        UserLog.setLocation(XLocation, YLocation);
    }

    public static void ShowRegister() {
        UserRegister register = new UserRegister();
        register.setVisible(true);
        register.setSize(750, 750);
        register.setResizable(true);
        //Gets the mouse location and sets the panel at these coordanites
        GetMouseLocation();
        register.setLocation(XLocation, YLocation);
    }

    public static void GetValues(Integer id) {
        try {
            //Creates a connection object, which uses the drivermanager class to establish a connection with my local database. It takes the location of the database, the username and password.
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/NHSDatabase", "PaulTucker", "Password123");
            //This creates a statement object, and sets the croll typ and editing permissions
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //I have delcared a string that i want to use to create a new stament. Makes me a new SQL statment to fire at the database
            String sql = "Select * From app.tbl_appointments where AppointmentID =" + id + "";
            //Creates a new results set from the SQL query, which holds the result of my statement
            ResultSet rs = statement.executeQuery(sql);

            //values from the appintments table
            if (rs.next()) {

                String AppID = String.valueOf(rs.getInt("AppointmentID"));
                String PatientID = String.valueOf(rs.getInt("patientID"));
                String Date = rs.getString("Date");
                String Time = rs.getString("Time");
                UneditView.AppointmentIDOUT.setText("Appointment ID:" + AppID);
                UneditView.PatientIDOUT.setText("Patient ID:" + PatientID);
                UneditView.AppointmentDateOUT.setText("Appointment date:" + Date);
                UneditView.AppointmentTimeOUT.setText("Appointment Time:" + Time);
            }

            // need to do this for all of the values on the viewer
            rs.close();
            statement.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error in GetVlaues(): " + e);

        }
    }

    public static void MergeSort(ArrayList array) {
        MergeSort.fillArray(array);
        System.out.println("Given Array");
        MergeSort.printArrayList(array);
        MergeSort ob = new MergeSort();
        ob.sort(array, 0, array.size() - 1);
        System.out.println("\nSorted array");
        MergeSort.printArrayList(array);
    }

    public static void AlgorithmTimer() {
        int numTries = 1000000;
        long begTime = System.currentTimeMillis();
        for (int i = 0; i < numTries; ++i) {
            MergeSort(array);
        }
        long endTime = System.currentTimeMillis();
        //System.currentTimeMillis();
        System.out.printf("Total time for %10d tries: %d ms\n", numTries, (endTime - begTime));
    }

    public static void NewUser(String Email, String Username, String password) {
        CreateUser user = new CreateUser(Email, Username, password);
        try {
            //Creates a new connection object with the values required for the connection to the local database to start
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/NHSDatabase", "PaulTucker", "Password123");
            //makea  reuslt set that is UPDATABLE, which is essential for taking values out of the database, but is not neccessery here. 
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String SQL = "SELECT MAX(UserID) AS maxID FROM APP.TBL_UserData";
            ResultSet rs = stmt.executeQuery(SQL);

            rs.next();
            int id = rs.getInt("maxID") + 1;

//            SQL = "insert into APP.TBL_Userdata Values(" + id + ",'" + user.getUserEmail() + "','" + user.getUserName() + "','" + user.getPassword() + "')";
//            stmt.executeUpdate(SQL);
            String sqlQuery = " INSERT INTO APP.TBL_Userdata (Userid, useremail, username, password)"
                    + " VALUES(?,?,?,?)";
            PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
            //block of setting the values within the perpared statement
            prepStmt.setInt(1, id);
            //the "2" is the column in the table that needs to be inserted into
            prepStmt.setString(2, user.getUserName());
            prepStmt.setString(3, user.getUserEmail());
            prepStmt.setString(4, user.getPassword());
            //Exectutes the statement, inserting the record into the database
            prepStmt.executeUpdate();

            //rs = stmt.executeQuery(SQL);
            //housekeeping
            rs.close();
            con.close();
            stmt.close();
            prepStmt.close();

        } catch (Exception e) {
            System.out.println("Error in newuser: " + e);
        }

    }

    public static void TestEmail(String email, String username) {

        try {
            sent = true;
            securityCode = RandomNumberGen();
            String subject = "Please confirm your email address";
            String Contents = "Hello" + username + ", \n Welcome to the NHS appointment system! please enter your code to the system to confirm your email \n Your code is: " + securityCode;
            Email.sendEmail(email, subject, Contents);
            
        } catch (Exception e) {
            sent = false;
            System.out.println("Exception in testemail");
        }

    }

    public static void ShowVarify() {
        VarifyEmail Varify = new VarifyEmail();
        Varify.setVisible(true);
        Varify.setSize(750, 750);
        Varify.setResizable(true);
        //Gets the mouse location and sets the panel at these coordanites
        GetMouseLocation();
        Varify.setLocation(XLocation, YLocation);
    }

    public static void ShowAdmin() {
        AdminLogin AdminLogin = new AdminLogin();
        AdminLogin.setVisible(true);
        AdminLogin.setSize(750, 750);
        AdminLogin.setResizable(true);
        //Gets the mouse location and sets the panel at these coordanites
        GetMouseLocation();
        AdminLogin.setLocation(XLocation, YLocation);
    }

    public static boolean InputCode() {
        int textIn = Integer.parseInt(VarifyEmail.In.getText());
        if (textIn == Main.securityCode) {
            //hide the varify email window
            return true;
        } else {
            return false;
        }

    }

    public static void ShowMenu() {
        Menu MainMenu = new Menu();
        MainMenu.setVisible(true);
        MainMenu.setSize(1000, 750);
        MainMenu.setResizable(true);
        //Gets the mouse location and sets the panel at these coordanites
        GetMouseLocation();
        MainMenu.setLocation(Main.XLocation, Main.YLocation);
    }

    public static void ShowAdminMenu() {
        AdminMenu AdminMenu = new AdminMenu();
        AdminMenu.setVisible(true);
        AdminMenu.setSize(750, 750);
        AdminMenu.setResizable(true);
        //Gets the mouse location and sets the panel at these coordanites
        GetMouseLocation();
        AdminMenu.setLocation(Main.XLocation, Main.YLocation);
    }

    public static void ShowForgot() {
        ForgotPass forgotPassword = new ForgotPass();
        forgotPassword.setVisible(true);
        forgotPassword.setSize(750, 750);
        forgotPassword.setResizable(true);
        //Gets the mouse location and sets the panel at these coordanites
        GetMouseLocation();
        forgotPassword.setLocation(Main.XLocation, Main.YLocation);
    }

    public static void ForgotPassword(String email) {
        try {
            boolean found = false;
            //compare username and password to database, then set GUI to be visible if its valid.
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/NHSDatabase", "PaulTucker", "Password123");
            //Creates a statemnent object, we specifically want the concur_updatable
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //allows us to parameterise the SQL statments
            String SQL = "SELECT UserEmail FROM APP.TBL_USERDATA"; //+ Selector.getSelectedItem(); USe a jselector to choose a table to display
            //creates a results set for out SQL statement
            ResultSet rs = stmt.executeQuery(SQL);
            String DatEmail = new String();

            while (rs.next()) {
                DatEmail = rs.getString("UserEmail");
                System.out.println("The rs currently has : " + DatEmail);
                if (DatEmail.equals(email)) {
                    found = true;
                }

            }
            if (found == true) {
                securityCode = RandomNumberGen();
                HideButton();
                System.out.println("Hiding buttons");
                Email.sendEmail(email, "Your forgotten password code", "Hello there, we noticed that youve lost your password! \n To help recover it, please enter your security code into the system to change your password \n Yyour security code is: " + securityCode);

            } else {
                ForgotPass.EmailIn.setText("Your email was not found, please contact an administrator");
                System.out.println("Showing buttons");
                ShowButton();
            }
            con.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Error in forgot: " + e);

        }
    }

    public static void HideButton() {
        ForgotPass.Confirm.setVisible(false);
        ForgotPass.CodeConfirm.setVisible(true);
        ForgotPass.Label.setText("Please enter the code");
        ForgotPass.EmailIn.setText("");
    }

    public static void ShowPassButton() {
        ForgotPass.Confirm.setVisible(false);
        ForgotPass.CodeConfirm.setVisible(false);
        ForgotPass.EmailIn.setText("");
        ForgotPass.ConfirmPass.setVisible(true);
        ForgotPass.ConfirmField.setVisible(true);
        ForgotPass.Label.setText("Please enter a new password");
    }

    public static void HidePassButton() {
        ForgotPass.Confirm.setVisible(true);
        ForgotPass.CodeConfirm.setVisible(true);
        ForgotPass.EmailIn.setText("");
        ForgotPass.ConfirmPass.setVisible(false);
        ForgotPass.ConfirmField.setVisible(false);
    }

    public static void ShowButton() {
        ForgotPass.Confirm.setVisible(true);
        ForgotPass.CodeConfirm.setVisible(false);
        ForgotPass.Label.setText("Please enter the email linked to your account");
    }

    public static void Code(Integer code) {
        if (Objects.equals(code, securityCode)) {
            ShowPassButton();

        } else {
            ForgotPass.EmailIn.setText("Sorry, your code wasnt right!");

        }
    }

    public static void ChangePassword(String username, String Password) {
        try {
            //Creates a new connection object with the values required for the connection to the local database to start
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/NHSDatabase", "PaulTucker", "Password123");
            String sqlQuery = ("UPDATE app.TBL_Userdata SET Password = ? WHERE Username = ?");
            PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
//block of setting the values within the perpared statement
            prepStmt.setString(1, Password);
//the "2" is the column in the table that needs to be inserted into
            prepStmt.setString(2, username);
            
//Exectutes the statement, inserting the record into the database
            prepStmt.executeUpdate();
            AdminMod.OUT.setText("password of the account: "+username+" changed");
            prepStmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in change pass");

        }

    }
    
    public static void ChangeUsername(String username, String Password) {
        try {
            //Creates a new connection object with the values required for the connection to the local database to start
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/NHSDatabase", "PaulTucker", "Password123");
            String sqlQuery = ("UPDATE app.TBL_Userdata SET Username = ? WHERE password = ?");
            PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
//block of setting the values within the perpared statement
            prepStmt.setString(1, username);
//the "2" is the column in the table that needs to be inserted into
            prepStmt.setString(2, Password);

//Exectutes the statement, inserting the record into the database
            prepStmt.executeUpdate();
            AdminMod.OUT.setText("username of the account changed to: "+ username);
            prepStmt.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in chage user");

        }

    }

    public static void AdaptPass() {
        try {
            //Creates a new connection object with the values required for the connection to the local database to start
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/NHSDatabase", "PaulTucker", "Password123");
            String sqlQuery = ("UPDATE app.TBL_Userdata SET Password = ? WHERE Useremail = ?");
            PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
//block of setting the values within the perpared statement
            prepStmt.setString(1, ForgotPass.ConfirmField.getText());
//the "2" is the column in the table that needs to be inserted into
            prepStmt.setString(2, ForgotPass.INPUTTEDEMAIL);

//Exectutes the statement, inserting the record into the database
            prepStmt.executeUpdate();
            
            prepStmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in adapt pass");

        }
    }
    
    public static void Modify(String date, String time, Integer id){
        try{
        //Creates a new connection object with the values required for the connection to the local database to start
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/NHSDatabase", "PaulTucker", "Password123");
            String sqlQuery = ("UPDATE app.TBL_Appointments SET Date = ?, Time = ? WHERE appointmentid = ?");
            PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
//block of setting the values within the perpared statement
            prepStmt.setString(1, date);
//the "2" is the column in the table that needs to be inserted into
            prepStmt.setString(2, time);
            prepStmt.setInt(3, id);

//Exectutes the statement, inserting the record into the database
            prepStmt.executeUpdate();
            prepStmt.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in modify");

        }
    }
    
    public static void ShowAdminMod(){
        AdminMod passChanger = new AdminMod();
        passChanger.setVisible(true);
        passChanger.setSize(750, 750);
        passChanger.setResizable(true);
        //Gets the mouse location and sets the panel at these coordanites
        GetMouseLocation();
        passChanger.setLocation(Main.XLocation, Main.YLocation);
    }
    
    public static void ShowUsersTable(){
        UserViewer usertable = new UserViewer();
        usertable.setVisible(true);
        usertable.setSize(750, 750);
        usertable.setResizable(true);
        //Gets the mouse location and sets the panel at these coordanites
        GetMouseLocation();
        usertable.setLocation(Main.XLocation, Main.YLocation);
    }

}
//(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])