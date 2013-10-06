/**
 * 
 */
package iFM.Model;

import java.util.Date;

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
			// TODO Auto-generated catch block
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
