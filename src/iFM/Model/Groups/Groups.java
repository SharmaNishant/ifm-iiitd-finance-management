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
public class Groups {
	public static String groupDetailsKind = "Group_Details";
	
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
	 * Add new group to database
	 * 
	 * @param name
	 * @param description
	 */
	public static void addGroup(String name, String description) {
			
		GroupDetails newGroup = new GroupDetails(name, description);
		
		Entity groupEntity = newGroup.getEntity();
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		datastore.put(groupEntity);
		
//		sendEmail(email, token);
	}
	
	/**
	 * Returns Entity of kind "Group Details", containing the group details (name, description, no. of coords/members)
	 * 
	 * @param name - Group Name
	 * @return Entity if found, null otherwise
	 * @author Rishav
	 */
	public static Entity getGroupDetails(String name) {
		
		Key key = KeyFactory.createKey(groupDetailsKind, name);
		try {
			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
			
			Entity entity = datastore.get(key);
			
			return entity;
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;		
	}
	
	/**
	 * Checks if the provided group already exists in the database
	 * 
	 * @param name
	 * @return true if exists, false otherwise
	 * @author Rishav
	 */
	public static boolean checkExistingGroup(String name) {
		Key key = KeyFactory.createKey(groupDetailsKind, name);
		
		try {
			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
			
			Entity entity = datastore.get(key);

			System.out.println(entity);
			
			return true;
			
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * increases the no. of coordinators for a group
	 * 
	 * @param name
	 * @return true if added, false if coordinator cannot be added
	 */
	static boolean addCoordinator(String name) {
		
		Key key = KeyFactory.createKey(groupDetailsKind, name);
		
		try {
			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
			
			Entity entity = datastore.get(key);

			int num_coords = (int) entity.getProperty("No_of_Coordinators");
			
			if(num_coords <= 5) {
				num_coords++;
				
				entity.setProperty("No_of_Coordinators", num_coords);
				
				datastore.put(entity);
				
				return true;
			}			
			
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
