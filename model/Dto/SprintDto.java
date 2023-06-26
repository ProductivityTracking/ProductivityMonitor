package com.pennant.prodmtr.model.Dto;

import java.sql.Timestamp;

import com.pennant.prodmtr.model.Entity.Sprint;

public class SprintDto {
	private int sprintId;
	private int moduleId;
	private int masterId;
	private Timestamp startDate;
	private Timestamp endDate;
	private int projectId;
	private String sprintName;
	private String sprintStatus;

	// Constructors, getters, and setters

	public SprintDto() {
	}

	public int getSprintId() {
		return sprintId;
	}

	public void setSprintId(int sprintId) {
		this.sprintId = sprintId;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public int getMasterId() {
		return masterId;
	}

	public void setMasterId(int masterId) {
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

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
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

	public static SprintDto fromEntity(Sprint sprint) {
		SprintDto sprintDto = new SprintDto();
		sprintDto.setSprintId(sprint.getSprintId());
		sprintDto.setModuleId(sprint.getModuleId().getModuleId());
		sprintDto.setMasterId(sprint.getMasterId().getUserId());
		sprintDto.setStartDate(sprint.getStartDate());
		sprintDto.setEndDate(sprint.getEndDate());
		sprintDto.setProjectId(sprint.getProjectId().getProjectId());
		sprintDto.setSprintName(sprint.getSprintName());
		sprintDto.setSprintStatus(sprint.getSprintStatus());
		return sprintDto;
	}
}
