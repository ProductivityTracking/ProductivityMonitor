package com.pennant.prodmtr.model.Dto;

import java.math.BigDecimal;
import java.sql.Date;

import com.pennant.prodmtr.model.Entity.Task;

public class TaskDto {
	private int taskId;
	private String taskName;
	private Date taskCreationDateTime;
	private String taskType;
	private int referencedTaskId;
	private String taskCategory;
	private String taskDescription;
	private int taskCreatorId;
	private BigDecimal numberOfHoursRequired;
	private Date taskExpectedDateTime;
	private Date taskCompletedDateTime;
	private int taskSupervisorId;
	private String taskRemarks;
	private String taskStatus;
	private int projectId;
	private int moduleId;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Date getTaskCreationDateTime() {
		return taskCreationDateTime;
	}

	public void setTaskCreationDateTime(Date taskCreationDateTime) {
		this.taskCreationDateTime = taskCreationDateTime;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public int getReferencedTaskId() {
		return referencedTaskId;
	}

	public void setReferencedTaskId(int referencedTaskId) {
		this.referencedTaskId = referencedTaskId;
	}

	public String getTaskCategory() {
		return taskCategory;
	}

	public void setTaskCategory(String taskCategory) {
		this.taskCategory = taskCategory;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public int getTaskCreatorId() {
		return taskCreatorId;
	}

	public void setTaskCreatorId(int taskCreatorId) {
		this.taskCreatorId = taskCreatorId;
	}

	public BigDecimal getNumberOfHoursRequired() {
		return numberOfHoursRequired;
	}

	public void setNumberOfHoursRequired(BigDecimal numberOfHoursRequired) {
		this.numberOfHoursRequired = numberOfHoursRequired;
	}

	public Date getTaskExpectedDateTime() {
		return taskExpectedDateTime;
	}

	public void setTaskExpectedDateTime(Date taskExpectedDateTime) {
		this.taskExpectedDateTime = taskExpectedDateTime;
	}

	public Date getTaskCompletedDateTime() {
		return taskCompletedDateTime;
	}

	public void setTaskCompletedDateTime(Date taskCompletedDateTime) {
		this.taskCompletedDateTime = taskCompletedDateTime;
	}

	public int getTaskSupervisorId() {
		return taskSupervisorId;
	}

	public void setTaskSupervisorId(int taskSupervisorId) {
		this.taskSupervisorId = taskSupervisorId;
	}

	public String getTaskRemarks() {
		return taskRemarks;
	}

	public void setTaskRemarks(String taskRemarks) {
		this.taskRemarks = taskRemarks;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public TaskDto() {
	}

	public static TaskDto fromEntity(Task task) {
		TaskDto dto = new TaskDto();
		dto.setTaskId(task.getTaskId());
		dto.setTaskName(task.getTaskName());
		dto.setTaskCreationDateTime(task.getTaskCreationDateTime());
		dto.setTaskType(task.getTaskType());

		if (task.getReferencedTask() != null) {
			dto.setReferencedTaskId(task.getReferencedTask().getTaskId());
		}

		dto.setTaskCategory(task.getTaskCategory());
		dto.setTaskDescription(task.getTaskDescription());

		if (task.getTaskCreator() != null) {
			dto.setTaskCreatorId(task.getTaskCreator().getUserId());
		}

		dto.setNumberOfHoursRequired(task.getNumberOfHoursRequired());
		dto.setTaskExpectedDateTime(task.getTaskExpectedDateTime());
		dto.setTaskCompletedDateTime(task.getTaskCompletedDateTime());

		if (task.getTaskSupervisor() != null) {
			dto.setTaskSupervisorId(task.getTaskSupervisor().getUserId());
		}

		dto.setTaskRemarks(task.getTaskRemarks());
		dto.setTaskStatus(task.getTaskStatus());

		if (task.getProject() != null) {
			dto.setProjectId(task.getProject().getProjectId());
		}

		if (task.getModule() != null) {
			dto.setModuleId(task.getModule().getModuleId());
		}

		return dto;
	}

}
