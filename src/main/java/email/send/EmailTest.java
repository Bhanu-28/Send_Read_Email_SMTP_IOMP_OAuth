package email.send;


import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailTest {
	private static final String EMAIL_FROM = "bhanupradeep123456@gmail.com";
	private static final String EMAIL_TO = "gorrebhanupradeepkumar@gmail.com";
	private static final String APP_PASSWORD = "**** **** **** ****";
	
	public static void main(String[] args) throws Exception {
		Message message = new MimeMessage(getEmailSession());
		message.setFrom(new InternetAddress(EMAIL_FROM));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(EMAIL_TO));
		message.setSubject("Email subject");
		message.setText("This is my bhanu email sent from Gmail using Java to test whether it is working");
		Transport.send(message);
		System.out.println("Email sent successfully!");
	}
	
	private static Session getEmailSession() {
		return Session.getInstance(getGmailProperties(), new Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(EMAIL_FROM, APP_PASSWORD);
		    }
		});
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