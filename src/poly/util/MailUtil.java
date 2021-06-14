package poly.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import poly.domain.Email;

public class MailUtil {
	private static String _email = "huamanhhung13@gmail.com";
	private static String _password = "hung18052000";
	private static String _name = "Admin";

	public static void send(Email email) throws Exception {
		Properties properties = new Properties();
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.auth", "true");
		// **
		properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.setProperty("mail.smtp.socketFactory.fallback", "false");

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(_email, _password);
			}
		});
		MimeMessage message = new MimeMessage(session);
		Multipart multipart = new MimeMultipart();

		MimeBodyPart textPart = new MimeBodyPart();
		textPart.setContent(email.getContent(), "text/html; charset=utf-8");

		multipart.addBodyPart(textPart);

		message.setFrom(new InternetAddress(_email, _name, "utf-8"));
		message.setRecipients(Message.RecipientType.TO, email.getToEmail());
		message.setSubject(email.getSubject(), "utf-8");
		message.setReplyTo(message.getFrom());
		message.setSentDate(new Date());
		message.setContent(multipart);
		Transport.send(message);

	}
}
