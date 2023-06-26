package com.pennant.prodmtr.model.Dto;


import java.sql.Date;

import com.pennant.prodmtr.model.Entity.Subtask;
import com.pennant.prodmtr.model.Entity.SubtaskPrimaryKey;

public class SubtaskDto {

	private Integer taskId;
	private Integer subtaskId;
	private String subtaskDescription;
	private Double numberOfHours;
	private Date creationDate;

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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public static SubtaskDto fromEntity(Subtask subtask) {
		SubtaskDto subDto = new SubtaskDto();

		SubtaskPrimaryKey primaryKey = subtask.getPrimaryKey();
		subDto.setTaskId(primaryKey.getSubtaskId());
		subDto.setSubtaskId(primaryKey.getSubtaskId());

		subDto.setSubtaskDescription(subtask.getSubtaskDescription());
		subDto.setNumberOfHours(subtask.getNumberOfHours());
		subDto.setCreationDate(subtask.getCreationDate());

		return subDto;
	}
}