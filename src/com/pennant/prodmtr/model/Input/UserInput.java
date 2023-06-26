package com.pennant.prodmtr.model.Input;

import java.util.Date;

import com.pennant.prodmtr.model.Entity.Role;
import com.pennant.prodmtr.model.Entity.User;

public class UserInput {

	private int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	private String userDisplayName;
	private String userPassword;
	private Date userCreationDate;
	private String userEmployeeId;
	private String userStatus;
	private Date userLastUpdatedDate;
	private short userRole;

	public String getUserDisplayName() {
		return userDisplayName;
	}

	public void setUserDisplayName(String userDisplayName) {
		this.userDisplayName = userDisplayName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Date getUserCreationDate() {
		return userCreationDate;
	}

	public void setUserCreationDate(Date date) {
		this.userCreationDate = date;
	}

	public String getUserEmployeeId() {
		return userEmployeeId;
	}

	public void setUserEmployeeId(String userEmployeeId) {
		this.userEmployeeId = userEmployeeId;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public Date getUserLastUpdatedDate() {
		return userLastUpdatedDate;
	}

	public void setUserLastUpdatedDate(Date userLastUpdatedDate) {
		this.userLastUpdatedDate = userLastUpdatedDate;
	}

	public short getUserRole() {
		return userRole;
	}

	public void setUserRole(short userRole) {
		this.userRole = userRole;
	}

	public User toEntity() {
		User user = new User();
		user.setUserId(this.userId);
		user.setUserCreationDate(this.userCreationDate);
		user.setUserDisplayName(this.userDisplayName);
		user.setUserEmployeeId(this.userEmployeeId);
		user.setUserLastUpdatedDate(this.userLastUpdatedDate);
		user.setUserCreationDate(this.userCreationDate);
		Role role = new Role();
		role.setRoleId(this.userRole);
		user.setUserRole(role);
		return user;

	}

}
