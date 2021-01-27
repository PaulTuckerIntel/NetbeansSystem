package nhs.appointment.system;

import java.util.ArrayList;

public class CreateAdmin extends User implements IssuesList {

    ArrayList<Issue> Issues = new ArrayList();

    public CreateAdmin(String UserName, String Password) {
        super(UserName, Password);
    }

    @Override
    public String getUserName() {
        return UserName;
    }

    @Override
    public String getPassword() {
        return Password;
    }

    @Override
    public ArrayList<Issue> IssuesList() {
        return Issues;
    }

    public void AddIssue(Issue Issue) {
        Issues.add(Issue);
    }

}
