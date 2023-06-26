package com.pennant.prodmtr.model.view;

public class Past30CompletionSummary {
	private String completedDate;
	private int tasksCompleted;
	private int subtasksCompleted;

	// Constructors, getters, and setters

	public String getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(String completedDate) {
		this.completedDate = completedDate;
	}

	public int getTasksCompleted() {
		return tasksCompleted;
	}

	public void setTasksCompleted(int tasksCompleted) {
		this.tasksCompleted = tasksCompleted;
	}

	public int getSubtasksCompleted() {
		return subtasksCompleted;
	}

	public void setSubtasksCompleted(int subtasksCompleted) {
		this.subtasksCompleted = subtasksCompleted;
	}
}
