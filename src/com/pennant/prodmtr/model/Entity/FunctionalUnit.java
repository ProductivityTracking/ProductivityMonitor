package com.pennant.prodmtr.model.Entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pm_functional_units")
public class FunctionalUnit {
	@EmbeddedId
	private FunctionalUnitId id;

	@Column(name = "funit_desc")
	private String description;

	@ManyToOne
	@JoinColumn(name = "proj_id")
	private Project projectId;

	@Column(name = "fun_status")
	private String funStatus;

	public FunctionalUnit() {
		// Default constructor required by JPA
	}

	// Getters and setters

	public FunctionalUnitId getId() {
		return id;
	}

	public void setId(FunctionalUnitId id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Project getProjectId() {
		return projectId;
	}

	public void setProjectId(Project projectId) {
		this.projectId = projectId;
	}

	public String getFunStatus() {
		return funStatus;
	}

	public void setFunStatus(String funStatus) {
		this.funStatus = funStatus;
	}

	@Override
	public String toString() {
		return "FunctionalUnit [id=" + id + ", description=" + description + ", projectId=" + projectId + ", funStatus="
				+ funStatus + "]";
	}
}