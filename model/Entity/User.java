package com.pennant.prodmtr.model.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "s4_Users")
public class User {
	@Id
	@Column(name = "user_id")
	public int userId;

	@Column(name = "user_displayname", length = 50)
	public String userDisplayName;

	@Column(name = "user_password", length = 50)
	public String userPassword;

	@Column(name = "user_cdate")
	public Date userCreationDate;

	@Column(name = "user_empl_id", length = 12)
	public String userEmployeeId;

	@Column(name = "user_status", length = 2)
	public String userStatus;

	@Column(name = "user_ludate")
	public Date userLastUpdatedDate;

	@ManyToOne
	@JoinColumn(name = "user_role")
	private Role userRole;

	// Constructors
	public User() {
	}

	public User(String userDisplayName, String userPassword, Date userCreationDate, String userEmployeeId,
			String userStatus, Date userLastUpdatedDate, Role userRole) {
		this.userDisplayName = userDisplayName;
		this.userPassword = userPassword;
		this.userCreationDate = userCreationDate;
		this.userEmployeeId = userEmployeeId;
		this.userStatus = userStatus;
		this.userLastUpdatedDate = userLastUpdatedDate;
		this.userRole = userRole;
	}

	// Getters and Setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

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

	public void setUserCreationDate(Date userCreationDate) {
		this.userCreationDate = userCreationDate;
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

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

}
