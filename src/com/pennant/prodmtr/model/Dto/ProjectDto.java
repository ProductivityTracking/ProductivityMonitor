package com.pennant.prodmtr.model.Dto;

import java.util.Date;

import com.pennant.prodmtr.model.Entity.Project;

public class ProjectDto {
	private short projectId;
	private String projectName;
	private String projectDescription;
	private Date projectStartDate;
	private int projectManagerId;
	private String projectStatus;
	private Date projectLastUpdatedDate;

	private int totalSprints;
	private int completedSprints;

	private int totalTasks;
	private int completedTasks;

	private int totalIndvTasks;
	private int completedIndvTasks;

	public int getCompletedTasks() {
		return completedTasks;
	}

	public void setCompletedTasks(int completedTasks) {
		this.completedTasks = completedTasks;
	}

	public int getTotalIndvTasks() {
		return totalIndvTasks;
	}

	public void setTotalIndvTasks(int totalIndvTasks) {
		this.totalIndvTasks = totalIndvTasks;
	}

	public int getTotalTasks() {
		return totalTasks;
	}

	public void setTotalTasks(int totalTasks) {
		this.totalTasks = totalTasks;
	}

	public int getCompletedIndvTasks() {
		return completedIndvTasks;
	}

	public void setCompletedIndvTasks(int completedIndvTasks) {
		this.completedIndvTasks = completedIndvTasks;
	}

	public int getTotalSprints() {
		return totalSprints;
	}

	public void setTotalSprints(int totalSprints) {
		this.totalSprints = totalSprints;
	}

	public int getCompletedSprints() {
		return completedSprints;
	}

	public void setCompletedSprints(int completedSprints) {
		this.completedSprints = completedSprints;
	}

	// public String toString() {
	// return "res " + sprint_data.get(0);
	// }

	public short getProjectId() {
		return projectId;
	}

	public int getProjectManagerId() {
		return projectManagerId;
	}

	public void setProjectManagerId(int projectManagerId) {
		this.projectManagerId = projectManagerId;
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

	public int getProjectManagerName() {
		return projectManagerId;
	}

	public void setProjectManagerName(int i) {
		this.projectManagerId = i;
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

	public void setProjectLastUpdatedDate(Date projectLastUpdatedDate) {
		this.projectLastUpdatedDate = projectLastUpdatedDate;
	}

	public static ProjectDto fromEntity(Project project) {
		ProjectDto projectDto = new ProjectDto();
		projectDto.setProjectId(project.getProjectId());
		projectDto.setProjectName(project.getProjectName());
		projectDto.setProjectDescription(project.getProjectDescription());
		projectDto.setProjectStartDate(project.getProjectStartDate());
		projectDto.setProjectManagerName((short) project.getProjectManager().getUserId());
		projectDto.setProjectStatus(project.getProjectStatus());
		projectDto.setProjectLastUpdatedDate(project.getProjectLastUpdatedDate());
		return projectDto;
	}
}
