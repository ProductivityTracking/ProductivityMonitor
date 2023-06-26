package com.pennant.prodmtr.model.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pm_Roles")
public class Role {
	@Id
	@Column(name = "role_id")
	private Short roleId;

	@Column(name = "role_name", length = 50)
	private String roleName;

	@Column(name = "role_desc", length = 255)
	private String roleDesc;

	// Constructors
	public Role() {
	}

	public Role(short roleId, String roleName, String roleDesc) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDesc = roleDesc;
	}

	// Getters and Setters
	public Short getRoleId() {
		return roleId;
	}

	public void setRoleId(Short roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
}
