package nhs.appointment.system;

public class Issue {

    protected String Issue;
    protected String UsersID;

    public Issue(String Issue, String UsersID) {
        this.Issue = Issue;
        this.UsersID = UsersID;
    }

    public String getIssue() {
        return Issue;
    }

    public void setIssue(String Issue) {
        this.Issue = Issue;
    }

    public String getUsersID() {
        return UsersID;
    }

    public void setUsersID(String UsersID) {
        this.UsersID = UsersID;
    }

}
