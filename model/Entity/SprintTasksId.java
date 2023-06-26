package com.pennant.prodmtr.model.Entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Embeddable
public class SprintTasksId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name = "sprn_id")
	private Sprint sprnId;

	@Override
	public String toString() {
		return "SprintTasksId [sprnId=" + sprnId + ", taskId=" + taskId + "]";
	}

	@OneToOne
	@JoinColumn(name = "task_id")
	private Task taskId;

	public SprintTasksId() {
	}

	public SprintTasksId(Sprint sprnId, Task taskId) {
		this.sprnId = sprnId;
		this.taskId = taskId;
	}

	// Getters and Setters

	public Sprint getSprnId() {
		return sprnId;
	}

	public void setSprnId(Sprint sprnId) {
		this.sprnId = sprnId;
	}

	public Task getTaskId() {
		return taskId;
	}

	public void setTaskId(Task taskId) {
		this.taskId = taskId;
	}

	// Equals and HashCode (based on sprnId and taskId)

}