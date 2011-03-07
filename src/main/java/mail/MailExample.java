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
		message.setSubject("Hello JavaMail 按照国家统计局的安排", "UTF-8");
		
		// Set the content
		message.setText("Welcome to JavaMail 中广网北京2月15日消息（记者周晋竹）据经济之声报道，国家统计局今天 ");
		
		// Send message
		Transport.send(message);
		
		System.out.println("-------The End-------");
		
	}
	
	
	
}
