/**
 * 
 */
package iFM.Model.Users;

import com.google.appengine.api.datastore.Entity;

/**
 * @author Rishav
 *
 */
public class AccountDetails {
	
	private Entity Account;
	
	public AccountDetails(String token, String email, String password) {
		
		this.Account = new Entity(Users.accountDetailsKind, email);
		
		this.Account.setProperty("Email", email);
		this.Account.setProperty("Password", password);
		this.Account.setProperty("Token", token);
		this.Account.setProperty("Verified", false);
	}
	
	public Entity getEntity() {
		return this.Account;
	}
}
