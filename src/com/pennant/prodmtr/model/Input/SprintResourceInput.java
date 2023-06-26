package com.pennant.prodmtr.model.Input;

import com.pennant.prodmtr.model.Entity.SprintResource;
import com.pennant.prodmtr.model.Entity.User;

public class SprintResourceInput {

	private int sprintId;
	private int masterId;
	private String role;

	

	@Override
	public String toString() {
		return "SprintResourceInput [sprintId=" + sprintId + ", masterId=" + masterId + ", role=" + role + "]";
	}

	// Constructors
	public SprintResourceInput() {
	}

	public SprintResourceInput(int sprintId, int masterId, String role) {
		this.sprintId = sprintId;
		this.masterId = masterId;
		this.role = role;
	}

	// Getters and Setters
	public int getSprintId() {
		return sprintId;
	}

	public void setSprintId(int sprintId) {
		this.sprintId = sprintId;
	}

	public int getMasterId() {
		return masterId;
	}

	public void setMasterId(int masterId) {
		this.masterId = masterId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	// Conversion method from SprintResourceInput to SprintResource
	public SprintResource toEntity() {
		SprintResource sprintResource = new SprintResource();
		
		// Assuming you have a method to fetch the User object by masterId, e.g., fetchUserById()
		User user = new User();
		user.setUserId(masterId); // Assuming masterId is the ID of the User

		sprintResource.setMasterId(user);

		sprintResource.setRole(role);
		return sprintResource;
	}
}