package com.pennant.prodmtr.model.Dto;

public class TFilterCriteria {
	private int taskId;
	private String taskStatus;
	private int taskSupervisorId;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getTaskSupervisorId() {
		return taskSupervisorId;
	}

	public void setTaskSupervisorId(int taskSupervisorId) {
		this.taskSupervisorId = taskSupervisorId;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

}
