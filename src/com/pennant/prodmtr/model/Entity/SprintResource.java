package com.pennant.prodmtr.model.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pm_SprintResources")
public class SprintResource {
	@Id
	@Column(name = "sprn_res_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sprnresid;

	@Column(name = "sprn_id")
	private int sprintId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User masterId;

	private String role;

	public int getSprintId() {
		return sprintId;
	}

	public void setSprintId(int sprintId) {
		this.sprintId = sprintId;
	}

	public User getMasterId() {
		return masterId;
	}

	public void setMasterId(User masterId) {
		this.masterId = masterId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getSprnresid() {
		return sprnresid;
	}

	public void setSprnresid(int sprnresid) {
		this.sprnresid = sprnresid;
	}

	// Constructors

}