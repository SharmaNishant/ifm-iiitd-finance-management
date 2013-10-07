/**
 * 
 */
package iFM.Model;

import com.google.appengine.api.datastore.Entity;

/**
 * @author Rishav
 *
 */
public class UserDetails {
	
	private Entity User;
	
	public UserDetails(String token, String name, String email, String instituteid, String phone, String address, String role, String designation) {
		
		this.User = new Entity("User Details", token);
				
		this.User.setProperty("Name", name);
		this.User.setProperty("Email", email);
		this.User.setProperty("Institute ID", instituteid);	
		this.User.setProperty("Phone", phone);
		this.User.setProperty("Address", address);
		this.User.setProperty("Role", role);
		this.User.setProperty("Designation", designation);
	}
	
	public UserDetails(Entity other) {
		this.User = other;
	}
	
	public Entity getEntity() {
		return this.User;
	}
}
