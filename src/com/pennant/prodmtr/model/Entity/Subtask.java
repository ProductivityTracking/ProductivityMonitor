package com.pennant.prodmtr.model.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pm_subtasks")
public class Subtask {

	@EmbeddedId
	private SubtaskPrimaryKey primaryKey;

	@Column(name = "sbts_desc")
	private String subtaskDescription;

	//
	// @Column(name = "subtask_description")
	// private String subtaskDescription;

	@Column(name = "sbts_noh")
	private Double numberOfHours;

	// @Column(name = "number_of_hours")
	// private Double numberOfHours;

	@Column(name = "sbts_cre_date")
	private Date creationDate;

	// @Column(name = "creation_date")
	// private Date creationDate;

	@Column(name = "sbts_status")
	private String sbts_status;

	public Subtask(SubtaskPrimaryKey primaryKey, String subtaskDescription, Double numberOfHours, Date creationDate,
			String sbts_status) {
		super();
		this.primaryKey = primaryKey;
		this.subtaskDescription = subtaskDescription;
		this.numberOfHours = numberOfHours;
		this.creationDate = creationDate;
		this.sbts_status = sbts_status;
	}

	public Subtask() {
		super();
	}

	public String getSbts_status() {
		return sbts_status;
	}

	public void setSbts_status(String sbts_status) {
		this.sbts_status = sbts_status;
	}

	public SubtaskPrimaryKey getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(SubtaskPrimaryKey primaryKey) {
		this.primaryKey = primaryKey;
	}

	public String getSubtaskDescription() {
		return subtaskDescription;
	}

	public void setSubtaskDescription(String subtaskDescription) {
		this.subtaskDescription = subtaskDescription;
	}

	public Double getNumberOfHours() {
		return numberOfHours;
	}

	public void setNumberOfHours(Double numberOfHours) {
		this.numberOfHours = numberOfHours;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}