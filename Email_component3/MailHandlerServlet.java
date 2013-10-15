/**
 * 
 */
package iFM;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mortbay.log.Log;

/**
 * @author Rishav
 *
 */
@SuppressWarnings("serial")
public class MailHandlerServlet extends HttpServlet {
  public void doPost(HttpServletRequest req, HttpServletResponse resp) {
	  Properties props = new Properties(); 
      Session session = Session.getDefaultInstance(props, null); 
      try {
		MimeMessage message = new MimeMessage(session, req.getInputStream());
				
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("iiitd.finance.management@gmail.com"));
		
		Transport.send(message);
		
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		Log.warn("Recieved Email Message not GOOD");
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		Log.warn("Could not recieve Email");
		e.printStackTrace();
	}
      
      
  }
}

