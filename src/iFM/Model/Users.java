/**
 * 
 */
package iFM.Model;

import java.util.Date;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

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
}
