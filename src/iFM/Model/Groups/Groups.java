/**
 * 
 */
package iFM.Model.Groups;

import java.io.UnsupportedEncodingException;
import java.util.Date;
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
	 * Returns Entity of kind "User Details", containing the profile parameters for the user with the provided email
	 * 
	 * @param email
	 * @return Entity if found, null otherwise
	 * @author Rishav
	 */
	public static Entity getGroupDetails(String name) {
		
		Key key = KeyFactory.createKey(groupDetailsKind, name);
		try {
			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
			
			Entity entity = datastore.get(key);
			
			System.out.println(entity.getProperty("Email"));
			
			String token = (String)entity.getProperty("Token");
			
			key = KeyFactory.createKey(userDetailsKind, token);
			
			Entity userDetails = datastore.get(key);
			
			return userDetails;
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;		
	}
	
	/**
	 * Returns Entity of kind "User Details", containing the profile parameters for the user with the provided token
	 * 
	 * @param token
	 * @return Entity if found, null otherwise
	 * @author Rishav
	 */
	public static Entity getProfileByToken(String token) {
		
		Key key = KeyFactory.createKey(userDetailsKind, token);
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
	
	
	public static String getNameByToken(String token) {
		Key key = KeyFactory.createKey(userDetailsKind, token);
		try {
			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
			
			Entity entity = datastore.get(key);
			
			return (String) entity.getProperty("Name");
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Returns the password for the user with provided email
	 * @param email
	 * @return password if found, null otherwise
	 * @author Rishav
	 */
	public static String getPassword(String email) {
		
		Key key = KeyFactory.createKey(accountDetailsKind, email);
		
		try {
			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
			
			Entity entity = datastore.get(key);
			
			System.out.println(entity.getProperty("Email"));
			
			String password = (String)entity.getProperty("Password");
			
			return password;
			
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;		
	}
	
	/**
	 * Returns the system-generated token for the user with provided email
	 * @param email
	 * @return token if found, null otherwise
	 * @author Rishav
	 */
	public static String getToken(String email) {
		
		Key key = KeyFactory.createKey(accountDetailsKind, email);
		
		try {
			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
			
			Entity entity = datastore.get(key);
			
			System.out.println(entity.getProperty("Email"));
			
			String token = (String)entity.getProperty("Token");
			
			return token;
			
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;		
	}

	/**
	 * Returns whether the provided email is verified or not
	 * 
	 * @param email
	 * @return true if verified, false otherwise
	 * @author Rishav
	 */
	public static boolean getVerified(String email) {
		Key key = KeyFactory.createKey(accountDetailsKind, email);
		
		try {
			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
			
			Entity entity = datastore.get(key);
			
			System.out.println(entity.getProperty("Verified"));
			
			boolean verified = (boolean)entity.getProperty("Verified");
			
			return verified;
			
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	/**
	 * Sets the email account as Verified
	 * 
	 * @param email
	 * @return true if successful, false otherwise
	 * @author Rishav
	 */
	public static boolean setVerified(String email) {
		
		Key key = KeyFactory.createKey(accountDetailsKind, email);
		
		try {
			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
			
			Entity entity = datastore.get(key);
			
			System.out.println(entity.getProperty("Verified"));
			
			entity.setProperty("Verified", true);
			
			datastore.put(entity);
			
			return true;
			
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	/**
	 * Checks if the provided email already exists in the database
	 * 
	 * @param email
	 * @return true if exists, false otherwise
	 * @author Rishav
	 */
	public static boolean checkExistingUser(String email) {
		Key key = KeyFactory.createKey(accountDetailsKind, email);
		
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
}
