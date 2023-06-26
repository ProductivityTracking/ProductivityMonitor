package com.pennant.prodmtr.model.Input;


import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.pennant.prodmtr.model.Entity.Module;
import com.pennant.prodmtr.model.Entity.Project;
import com.pennant.prodmtr.model.Entity.Task;
import com.pennant.prodmtr.model.Entity.User;

public class TaskInput {
	private String taskName;
	private String taskCreationDateTime;
	private String taskType;
	private Integer referencedTaskId;
	private String taskCategory;
	private String taskDescription;
	private Integer taskCreatorId;
	private BigDecimal numberOfHoursRequired;
	private String taskExpectedDateTime;
	private String taskCompletedDateTime;
	private Integer taskSupervisorId;
	private String taskRemarks;
	private String taskStatus;
	private int projectId;
	private short moduleId;


	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskCreationDateTime() {
		return taskCreationDateTime;
	}

	public void setTaskCreationDateTime(String taskCreationDateTime) {
		this.taskCreationDateTime = taskCreationDateTime;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public Integer getReferencedTaskId() {
		return referencedTaskId;
	}

	public void setReferencedTaskId(Integer referencedTaskId) {
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

	public Integer getTaskCreatorId() {
		return taskCreatorId;
	}

	public void setTaskCreatorId(Integer taskCreatorId) {
		this.taskCreatorId = taskCreatorId;
	}

	public BigDecimal getNumberOfHoursRequired() {
		return numberOfHoursRequired;
	}

	public void setNumberOfHoursRequired(BigDecimal numberOfHoursRequired) {
		this.numberOfHoursRequired = numberOfHoursRequired;
	}

	public String getTaskExpectedDateTime() {
		return taskExpectedDateTime;
	}

	public void setTaskExpectedDateTime(String taskExpectedDateTime) {
		this.taskExpectedDateTime = taskExpectedDateTime;
	}

	public String getTaskCompletedDateTime() {
		return taskCompletedDateTime;
	}

	public void setTaskCompletedDateTime(String taskCompletedDateTime) {
		this.taskCompletedDateTime = taskCompletedDateTime;
	}

	public Integer getTaskSupervisorId() {
		return taskSupervisorId;
	}

	public void setTaskSupervisorId(Integer taskSupervisorId) {
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

	public short getModuleId() {
		return moduleId;
	}

	public void setModuleId(short moduleId) {
		this.moduleId = moduleId;
	}

	@Override
	public String toString() {
		return "TaskInput [taskId="  + ", taskName=" + taskName + ", taskCreationDateTime="
				+ taskCreationDateTime + ", taskType=" + taskType + ", referencedTaskId=" + referencedTaskId
				+ ", taskCategory=" + taskCategory + ", taskDescription=" + taskDescription + ", taskCreatorId="
				+ taskCreatorId + ", numberOfHoursRequired=" + numberOfHoursRequired + ", taskExpectedDateTime="
				+ taskExpectedDateTime + ", taskCompletedDateTime=" + taskCompletedDateTime + ", taskSupervisorId="
				+ taskSupervisorId + ", taskRemarks=" + taskRemarks + ", taskStatus=" + taskStatus + ", projectId="
				+ projectId + ", moduleId=" + moduleId + "]";
	}

	public TaskInput(int taskId, String taskName, String taskCreationDateTime, String taskType,
			Integer referencedTaskId, String taskCategory, String taskDescription, Integer taskCreatorId,
			BigDecimal numberOfHoursRequired, String taskExpectedDateTime, String taskCompletedDateTime,
			Integer taskSupervisorId, String taskRemarks, String taskStatus, int projectId, short moduleId) {
		super();
		this.taskName = taskName;
		this.taskCreationDateTime = taskCreationDateTime;
		this.taskType = taskType;
		this.referencedTaskId = referencedTaskId;
		this.taskCategory = taskCategory;
		this.taskDescription = taskDescription;
		this.taskCreatorId = taskCreatorId;
		this.numberOfHoursRequired = numberOfHoursRequired;
		this.taskExpectedDateTime = taskExpectedDateTime;
		this.taskCompletedDateTime = taskCompletedDateTime;
		this.taskSupervisorId = taskSupervisorId;
		this.taskRemarks = taskRemarks;
		this.taskStatus = taskStatus;
		this.projectId = projectId;
		this.moduleId = moduleId;
	}

	public TaskInput() {
		super();
	}

	public Task toEntity() {
		Task task = new Task();

		User assignedUser = new User();
		task.setTaskSupervisor(assignedUser);

		task.setTaskName(this.taskName);
		task.setTaskCreationDateTime(parseDate(this.taskCreationDateTime));
		task.setTaskType(this.taskType);

		Task referencedTask = new Task();
		if (this.referencedTaskId != null) {
			referencedTask.setTaskId(this.referencedTaskId);
			task.setReferencedTask(referencedTask);
		} else {
		}

		task.setTaskCategory(this.taskCategory);
		task.setTaskDescription(this.taskDescription);

		User taskCreator = new User();

		if (this.taskCreatorId != null) {
			taskCreator.setUserId(this.taskCreatorId);
			task.setTaskCreator(taskCreator);
		} else {
			// Handle the case when taskCreatorId is null
			// You can throw an exception, set a default value, or handle it according to your application's logic
		}

		task.setNumberOfHoursRequired(this.numberOfHoursRequired);
		task.setTaskExpectedDateTime(parseDate(this.taskExpectedDateTime));
		task.setTaskCompletedDateTime(parseDate(this.taskCompletedDateTime));

		User taskSupervisor = new User();
		taskSupervisor.setUserId(this.taskSupervisorId);
		task.setTaskSupervisor(taskSupervisor);

		task.setTaskRemarks(this.taskRemarks);
		task.setTaskStatus(this.taskStatus);

		Project project = new Project();
		project.setProjectId((short)this.projectId);
		task.setProject(project);

		Module module = new Module();
		module.setModuleId(this.moduleId);
		task.setModule(module);

		return task;
	}

	private Date parseDate(String dateString) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (dateString != null) {
				java.util.Date parsedDate = dateFormat.parse(dateString);
				return new Date(parsedDate.getTime());
			}
		} catch (ParseException e) {
			// Handle the exception or log an error
			e.printStackTrace();
			return null;
		}
		return null;
	}

}
