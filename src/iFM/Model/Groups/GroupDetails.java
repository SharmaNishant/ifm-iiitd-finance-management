/**
 * 
 */
package iFM.Model.Groups;

import com.google.appengine.api.datastore.Entity;

/**
 * @author Rishav
 *
 */
public class GroupDetails {
	
	private Entity Group;
	
	public GroupDetails(String name, String description) {
		
		this.Group = new Entity(Groups.groupDetailsKind, name);
				
		this.Group.setProperty("Name", name);
		this.Group.setProperty("Descripton", description);
		this.Group.setProperty("No_of_Coordinators", 0);
		this.Group.setProperty("No_of_Members", 0);
	}
	
	public GroupDetails(Entity other) {
		this.Group = other;
	}
	
	public Entity getEntity() {
		return this.Group;
	}
}
