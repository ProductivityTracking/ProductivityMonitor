package com.pennant.prodmtr.model.Dto;

public class ResTaskFilter {
	private Short projectId;
	private String status;
	private String category;
	private int userId;

	public Short getProject() {
		return projectId;
	}

	public void setProject(Short projectId) {
		this.projectId = projectId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String statusFilter) {
		this.status = statusFilter;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}