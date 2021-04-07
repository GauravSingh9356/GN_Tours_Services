package traveltourism;

import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.mail.internet.InternetAddress;
import javax.mail.Transport;

public class EmailSenders {

    public void setupProperties(String recipient, int OTP) {
        try {
            Properties properties = new Properties();
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.starttls.enable", "true"); // port 547 requires tls to enabled

            String myAccountEmail = "youremail";
            String password = "yourpassword";
            Random ran = new Random();

            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    // <editor-fold defaultstate="collapsed" desc="Compiled Code">
                    /*
                     * 0: aconst_null 1: areturn
                     */
                    // </editor-fold
                    return new PasswordAuthentication(myAccountEmail, password);
                }
            });
            Message message = prepareMessage(session, myAccountEmail, recipient, OTP);
            Transport.send(message);
            JOptionPane.showMessageDialog(null, "OTP send successfully to your email!", "OTP",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (MessagingException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recipient, int OTP) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("OTPCode@GNTours", "GN Tours and Services"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("OTP Verification Code");

            message.setContent("<h5>Thank you for Signing up!</h5>. Your OTP code is " + OTP, "text/html");
            return message;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    /*
     * public void draftEmail() { String emailRecipient = "gs885693@gmail.com";
     * String emailSubject = "Text Mail"; String emailBody = "Text body of mail"; }
     */

    public static void main(String[] args) {
        // try{
        // Email email = new Email("gs935688@gmail.com", "spectrum12345#####");
        // email.setFrom("gs935688@gmail.com", "GN Tours and Services");
        // email.setSubject("This email is for testing");
        // email.setContent("<h1>This is content</h1>", "text/html");
        // email.addRecipient("gs885693@gmail.com");
        // email.send();
        // }
        // catch(Exception e)
        // {
        // System.out.println(e.getMessage());
        // }

        EmailSenders emailsender = new EmailSenders();
        emailsender.setupProperties("gs885693@gmail.com", 12345);
    }
}
