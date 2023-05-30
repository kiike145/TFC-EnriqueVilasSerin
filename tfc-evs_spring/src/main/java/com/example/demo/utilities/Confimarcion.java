package com.example.demo.utilities;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Confimarcion {

	public static void enviarCorreoConfirmacionRegistro(String correoUsuario , String nombreUsuario) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp-mail.outlook.com"); 
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);

		String username = "correoconfirmacion1@outlook.es";
		String password = "1234.abcd_";

		Session session = Session.getInstance(props, new Authenticator() {
		    @Override
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(username, password);
		    }
		});

		try {
			MimeMessage message = new MimeMessage(session);
		    message.setFrom(new InternetAddress(username)); 
		    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correoUsuario));
		    message.setSubject("Confirmación de registro");
		    message.setText("¡Hola, " + nombreUsuario + "! \n¡Gracias por registrarte en nuestra web!");
		    
		    Transport.send(message);
		} catch (MessagingException e) {
		    e.printStackTrace();
		}
	}	
}
