/**
 * 
 */
package iFM.Model;

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
public class Users {
	private static String generateToken(String roll) {
		Date now = new Date();
		return now.getTime() + roll;
	}
	
	private static void sendEmail(String email, String token) {
		String messageBody =
				"Welcome to iFM, Your account has been created.\n\n" +
				"You can confirm your account by clicking on the following link -\n" +
				"http://1.iiitdfm.appspot.com/NewUser.jsp?uid=" + token + "\n\n" +
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
	
	public static void addUser(String name, String email, String password, String instituteid, String phone, String address, String role, String designation) {
		
		String token = generateToken(instituteid);
		
		System.out.println("Generated Token for " + name + " : " + token);
		
		UserDetails newUser = new UserDetails(token, name, email, instituteid, phone, address, role, designation);
		AccountDetails newAccount = new AccountDetails(token, email, password);
		
		Entity userEntity = newUser.getEntity();
		Entity accountEntity = newAccount.getEntity();
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		datastore.put(userEntity);
		datastore.put(accountEntity);
		
		sendEmail(email, token);
	}
	
	public static Entity getProfile(String email) {
		
		Key key = KeyFactory.createKey("Account Details", email);
		try {
			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
			
			Entity entity = datastore.get(key);
			
			System.out.println(entity.getProperty("Email"));
			
			String token = (String)entity.getProperty("Token");
			
			key = KeyFactory.createKey("User Details", token);
			
			Entity userDetails = datastore.get(key);
			
			return userDetails;
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;		
	}
	
	public static String getPassword(String email) {
		
		Key key = KeyFactory.createKey("Account Details", email);
		
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
}
