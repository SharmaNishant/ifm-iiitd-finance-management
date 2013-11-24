/**
 * 
 */
package iFM.Model.Groups;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

/**
 * @author Rishav
 *
 */
public class GroupCoordinators {
	public static String groupCoordinatorsKind = "Group_Coordinators";
	
	private static void sendEmail(String email, String token) {
		String messageBody =
				"Welcome to iFM, Your account has been created.\n\n" +
				"You can confirm your account by clicking on the following link -\n" +
				"http://iiitdfm.appspot.com/NewUser?uid=" + token + "\n\n" +
				"The iFM Team\n";
		
		Properties props = new Properties(); 
        Session session = Session.getDefaultInstance(props, null); 
		Message message = new MimeMessage(session);
		
		try {
			message.setFrom(new InternetAddress("no-reply@iiitdfm.appspotmail.com", "iFM TEAM"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject("Welcome to iFM");
			message.setText(messageBody);
			Transport.send(message);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Add new coordinator for a group to database
	 * 
	 * @param email
	 * @param group
	 */
	public static void addCoordinator(String group, String email) {
			
		GroupCoordinatorsDetails newGroup = new GroupCoordinatorsDetails(group, email);
		
		Entity groupEntity = newGroup.getEntity();
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		datastore.put(groupEntity);
		
//		sendEmail(email, token);
	}	
}
