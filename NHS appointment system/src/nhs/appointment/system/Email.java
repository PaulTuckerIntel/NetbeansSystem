package nhs.appointment.system;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

    //send an email with these three strings as parameters
    public static void sendEmail(String Email, String Subject, String Contents) {
        String host = "smtp.gmail.com";

        final String user = "javatestingpaul@gmail.com";//change accordingly  
        final String password = "Paul1985tucker";//change accordingly  

        String to = Email;//change accordingly  

        //Get the session object  
        Properties props = new Properties();
        //add nessecerry information from the program into the props object
        props.put("mail.smtp.host", host);
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.debug", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        //creates a session object containg all the details needed for authentification, e.g. port name, username and password etc. 
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            //alters method to authenticate the password, this uses code written in the javax.mail.Authenticator class
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
                //line that returns the username and password
            }
        });

        //Compose the message  
        try {
            //creates a nime message to induce better error handling, acts as a virtual message, preventing long error from the smtp server
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(Subject);
            message.setText(Contents);

            //send the message using the transport object
            Transport.send(message);

            System.out.println("message sent successfully...");

            //error handling
        } catch (MessagingException e) {
            UserRegister.Emailin.setText("Email is not a valid email, cannot send message there");
        }
    }

}
