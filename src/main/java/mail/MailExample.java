package mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailExample {

	public static void main(String[] args) throws Exception, MessagingException
	{
		String host="demeter.silanis.com";
		String from="zhanqing_luo@silanis.com";
		String to="zhanqing_luo@silanis.com";
//		String cc="jinsong_tao@silanis.com";
		
		// Get System properties
		Properties props=System.getProperties();
		
		// Setup mail server
		props.put("mail.smtp.host", host);
		
		// Get Session
        Session session = Session.getDefaultInstance(props,null);
        
		// Define Message
		MimeMessage message = new MimeMessage(session);
		
		// Set the from address
		message.setFrom(new InternetAddress(from));

		// Set the to address
		message.addRecipient(Message.RecipientType.TO ,new InternetAddress(to));
//		message.addRecipient(Message.RecipientType.CC ,new InternetAddress(cc));
		
		// Set the subject
		message.setSubject("xxx");
		
		// Set the content
		message.setText("xxx ");
		
		// Send message
		Transport.send(message);
		
		System.out.println("-------The End-------");
		
	}
	
	
	
}
