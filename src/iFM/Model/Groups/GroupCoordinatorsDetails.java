/**
 * 
 */
package iFM.Model.Groups;

import com.google.appengine.api.datastore.Entity;

/**
 * @author Rishav
 *
 */
public class GroupCoordinatorsDetails {
	
	private Entity Coordinator;
	
	public GroupCoordinatorsDetails(String groupName, String email) {
		
		this.Coordinator = new Entity(GroupCoordinators.groupCoordinatorsKind, email);
				
		this.Coordinator.setProperty("Group", groupName);
		this.Coordinator.setProperty("Email", email);
	}
	
	public GroupCoordinatorsDetails(Entity other) {
		this.Coordinator = other;
	}
	
	public Entity getEntity() {
		return this.Coordinator;
	}
}
