package com.pennant.prodmtr.model.Input;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.pennant.prodmtr.model.Entity.Subtask;
import com.pennant.prodmtr.model.Entity.SubtaskPrimaryKey;

public class SubtaskInput {
	private Subtask subtask;
	private Integer taskId;
	private Integer subtaskId;
	private String subtaskDescription;
	private Double numberOfHours;
	private String creationDate;

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Integer getSubtaskId() {
		return subtaskId;
	}

	public void setSubtaskId(Integer subtaskId) {
		this.subtaskId = subtaskId;
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

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public Subtask toEntity() {

		Subtask subtask = new Subtask();
		SubtaskPrimaryKey primaryKey = new SubtaskPrimaryKey();

		primaryKey.setSubtaskId(this.taskId);
		primaryKey.setSubtaskId(this.subtaskId);

		subtask.setPrimaryKey(primaryKey);
		subtask.setSubtaskDescription(this.subtaskDescription);
		subtask.setNumberOfHours(this.numberOfHours);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date utilDate = dateFormat.parse(this.creationDate);
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			subtask.setCreationDate(sqlDate);
		} catch (ParseException e) {
			// Handle the parse exception
			e.printStackTrace();
		}

		return subtask;
	}

}