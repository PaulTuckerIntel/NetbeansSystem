package nhs.appointment.system;

abstract class User {

    protected String UserName;
    protected String Password;

    public User(String UserName, String Password) {
        this.UserName = UserName;
        this.Password = Password;
    }

    abstract String getUserName();

    abstract String getPassword();
}
