/**
 * 
 */
package iFM.Model;

import com.google.appengine.api.datastore.Entity;

/**
 * @author Rishav
 *
 */
public class GroupDetails {
	
	private Entity Group;
	
	public GroupDetails(String id, String name, String description, String groupMembers, String coordinator1, String coordinator2) {
		
		this.Group = new Entity(Groups.groupDetailsKind, id);
				
		this.Group.setProperty("Name", name);
		this.Group.setProperty("Descripton", description);
		this.Group.setProperty("Group_Members", groupMembers);	
		this.Group.setProperty("Coordinator_1", coordinator1);
		this.Group.setProperty("Coordinator_2", coordinator2);
	}
	
	public GroupDetails(Entity other) {
		this.Group = other;
	}
	
	public Entity getEntity() {
		return this.Group;
	}
}
