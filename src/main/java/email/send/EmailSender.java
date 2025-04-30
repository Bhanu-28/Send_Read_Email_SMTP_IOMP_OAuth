package email.send;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.util.Properties;

public class EmailSender {
	private static final String EMAIL_FROM = "bhanupradeep123456@gmail.com";
	private static final String EMAIL_TO = "gorrebhanupradeepkumar@gmail.com";
	private static final String APP_PASSWORD = "**** **** **** ****";
    public static void main(String[] args) {
        // Sender's email credentials
        final String senderEmail = "bhanupradeep123456gmail.com";
        final String senderPassword = "**** **** **** ****";

        // Receiver's email
        String recipientEmail = "gorrebhanupradeepkumar@gmail.com";

		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        // Create a session with an authenticator
        Session session = Session.getInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_FROM, APP_PASSWORD);
            }
        });

        try {
            // Create the email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_FROM));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(EMAIL_TO));
            message.setSubject("Test Email from Java");
            message.setText("This is a test email sent using Jakarta Mail By Bhanu.");

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
	private static Properties getGmailProperties() {
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		return prop;
	}
}

