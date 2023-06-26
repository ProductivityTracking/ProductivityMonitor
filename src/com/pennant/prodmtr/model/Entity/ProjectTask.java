package com.pennant.prodmtr.model.Entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pm_ProjectTasks")
public class ProjectTask {
	@Id
	@Column(name = "task_id")
	private int taskId;

	@ManyToOne
	@JoinColumn(name = "task_user_id")
	private User assignedUser;

	@Column(name = "task_name", length = 200)
	private String taskName;

	@Column(name = "task_cdatetime")
	private Date taskCreationDateTime;

	@Column(name = "task_category", length = 50)
	private String taskCategory;

	@Column(name = "task_desc", columnDefinition = "text")
	private String taskDescription;

	@ManyToOne
	@JoinColumn(name = "task_creator")
	private User taskCreator;

	@Column(name = "task_noh_reqd")
	private BigDecimal numberOfHoursRequired;

	@Column(name = "task_exp_datetime")
	private Date taskExpectedDateTime;

	@Column(name = "task_actualhours")
	private BigDecimal actualHours;

	@Column(name = "task_cmp_datetime")
	private Date taskCompletedDateTime;

	@Column(name = "task_status", length = 4)
	private String taskStatus;

	@ManyToOne
	@JoinColumn(name = "task_proj_id")
	private Project project;

	// Constructors
	public ProjectTask() {
	}

	// Getters and Setters
	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public User getAssignedUser() {
		return assignedUser;
	}

	public void setAssignedUser(User assignedUser) {
		this.assignedUser = assignedUser;
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

	public User getTaskCreator() {
		return taskCreator;
	}

	public void setTaskCreator(User taskCreator) {
		this.taskCreator = taskCreator;
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

	public BigDecimal getActualHours() {
		return actualHours;
	}

	public void setActualHours(BigDecimal actualHours) {
		this.actualHours = actualHours;
	}

	public Project getproject() {
		return project;
	}

	public void setproject(Project project) {
		this.project = project;
	}

	public String gettaskStatus() {
		return taskStatus;
	}

	public void settaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
}
