package com.pennant.prodmtr.model.Entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pm_sprints")
public class Sprint {
	@Id
	@Column(name = "sprn_id")
	private int sprintId;

	@ManyToOne
	@JoinColumn(name = "sprn_modl_id")
	private Module moduleId;

	@ManyToOne
	@JoinColumn(name = "sprn_master")
	private User masterId;

	@Column(name = "sprn_stdate")
	private Timestamp startDate;

	@Column(name = "sprn_enddate")
	private Timestamp endDate;

	@ManyToOne
	@JoinColumn(name = "proj_id")
	private Project projectId;

	@Column(name = "sprint_name")
	private String sprintName;

	@Column(name = "sprint_status")
	private String sprintStatus;

	// Constructors, getters, and setters

	public Sprint() {
	}

	public Sprint(Module moduleId, User masterId, Timestamp startDate, Timestamp endDate, Project projectId,
			String sprintName, String sprintStatus) {
		this.moduleId = moduleId;
		this.masterId = masterId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.projectId = projectId;
		this.sprintName = sprintName;
		this.sprintStatus = sprintStatus;
	}

	public int getSprintId() {
		return sprintId;
	}

	public void setSprintId(int sprintId) {
		this.sprintId = sprintId;
	}

	public Module getModuleId() {
		return moduleId;
	}

	public void setModuleId(Module moduleId) {
		this.moduleId = moduleId;
	}

	public User getMasterId() {
		return masterId;
	}

	public void setMasterId(User masterId) {
		this.masterId = masterId;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Project getProjectId() {
		return projectId;
	}

	public void setProjectId(Project projectId) {
		this.projectId = projectId;
	}

	public String getSprintName() {
		return sprintName;
	}

	public void setSprintName(String sprintName) {
		this.sprintName = sprintName;
	}

	public String getSprintStatus() {
		return sprintStatus;
	}

	public void setSprintStatus(String sprintStatus) {
		this.sprintStatus = sprintStatus;
	}

	@Override
	public String toString() {
		return "Sprint [sprintId=" + sprintId + ", moduleId=" + moduleId + ", masterId=" + masterId + ", startDate="
				+ startDate + ", endDate=" + endDate + ", projectId=" + projectId + ", sprintName=" + sprintName
				+ ", sprintStatus=" + sprintStatus + "]";
	}
}
