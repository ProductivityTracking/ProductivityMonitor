package com.pennant.prodmtr.model.Entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pm_Projects")
public class Project {
	@Id
	@Column(name = "proj_id")
	private short projectId;

	@Column(name = "proj_name", length = 100)
	private String projectName;

	@Column(name = "proj_desc", length = 255)
	private String projectDescription;

	@Column(name = "proj_stdate")
	private Date projectStartDate;

	@ManyToOne
	@JoinColumn(name = "proj_manager")
	private User projectManager;

	@Column(name = "proj_status", length = 2)
	private String projectStatus;

	@Column(name = "proj_ludate")
	private Date projectLastUpdatedDate;

	// Constructors
	public Project() {
	}

	public Project(String projectName, String projectDescription, Date projectStartDate, User projectManager,
			String projectStatus, Timestamp projectLastUpdatedDate) {
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.projectStartDate = projectStartDate;
		this.projectManager = projectManager;
		this.projectStatus = projectStatus;
		this.projectLastUpdatedDate = projectLastUpdatedDate;
	}

	// Getters and Setters
	public short getProjectId() {
		return projectId;
	}

	public void setProjectId(short projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public Date getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public User getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(User projectManager) {
		this.projectManager = projectManager;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public Date getProjectLastUpdatedDate() {
		return projectLastUpdatedDate;
	}

	public void setProjectLastUpdatedDate(java.sql.Date projectLastUpdatedDate2) {
		this.projectLastUpdatedDate = projectLastUpdatedDate2;
	}
}
