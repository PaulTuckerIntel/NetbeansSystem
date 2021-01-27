package nhs.appointment.system;

public class CreateUser extends User {

    protected String UserEmail;

    public CreateUser(String UserEmail, String UserName, String Password) {
        super(UserName, Password);
        this.UserEmail = UserEmail;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    @Override
    public String getUserName() {
        return UserName;
    }

    @Override
    public String getPassword() {
        return Password;
    }

}
